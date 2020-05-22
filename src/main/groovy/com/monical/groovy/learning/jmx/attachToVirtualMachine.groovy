package com.monical.groovy.learning.jmx

import com.sun.tools.attach.VirtualMachine

import javax.management.MBeanServerConnection
import javax.management.remote.JMXConnectorFactory
import javax.management.remote.JMXServiceURL

/**
 * @author monical* @date 2020-05-15 17:35:13
 */
/**
 * Provide an MBeanServerConnection based on the provided process ID (pid).
 *
 * @param pid Process ID of Java process for which MBeanServerConnection is
 *    desired.
 * @return MBeanServerConnection connecting to Java process identified by pid.
 */
def static MBeanServerConnection retrieveServerConnection(String pid) {
    println "Get JMX Connector for pid ${pid}!"
    def connectorAddressStr = "com.sun.management.jmxremote.localConnectorAddress"
    def jmxUrl = retrieveUrlForPid(pid, connectorAddressStr)
    def jmxConnector = JMXConnectorFactory.connect(jmxUrl)
    return jmxConnector.getMBeanServerConnection()
}

def void method1() {

}
/**
 * Provide JMX URL for attaching to the provided process ID (pid).
 *
 * @param @pid Process ID for which JMX URL is needed to connect.
 * @param @connectorAddressStr String for connecting.
 * @return JMX URL to communicating with Java process identified by pid.
 */
def static JMXServiceURL retrieveUrlForPid(String pid, String connectorAddressStr) {
    // Attach to the target application's virtual machine
    def vm = VirtualMachine.attach(pid)

    // Obtain Connector Address
    def connectorAddress =
            vm.getAgentProperties().getProperty(connectorAddressStr)

    // Load Agent if no connector address is available
    if (connectorAddress == null) {
        def agent = vm.getSystemProperties().getProperty("java.home") +
                File.separator + "lib" + File.separator + "management-agent.jar"
        vm.loadAgent(agent)

        // agent is started, get the connector address
        connectorAddress =
                vm.getAgentProperties().getProperty(connectorAddressStr)
    }

    return new JMXServiceURL(connectorAddress);
}