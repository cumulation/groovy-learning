package com.monical.groovy.learning.jmx

import javax.management.MBeanServerConnection
import java.lang.management.ManagementFactory
import java.lang.management.MemoryMXBean
import java.lang.management.OperatingSystemMXBean
import java.lang.management.RuntimeMXBean
import java.lang.management.ThreadMXBean

/**
 * @author monical* @date 2020-05-15 17:36:46
 */
/**
 * Display thread information based on ThreadMXBean associated with the provided
 * MBeanServerConnection.
 *
 * @param server MBeanServerConnection to use for obtaining thread information
 *    via the ThreadMXBean.
 */
def static void displayThreadInfo(MBeanServerConnection server)
{
    def remoteThreadBean = ManagementFactory.newPlatformMXBeanProxy(
            server,
            ManagementFactory.THREAD_MXBEAN_NAME,
            ThreadMXBean.class);

    println "Deadlocked Threads: ${remoteThreadBean.findDeadlockedThreads()}"
    println "Monitor Deadlocked Threads: ${remoteThreadBean.findMonitorDeadlockedThreads()}"
    println "Thread IDs: ${Arrays.toString(remoteThreadBean.getAllThreadIds())}"
    def threads = remoteThreadBean.dumpAllThreads(true, true);
    threads.each
            {
                println "\t${it.getThreadName()} (${it.getThreadId()}): ${it.getThreadState()}"
            }
}

/**
 * Display operating system information based on ThreadMXBean associated with
 * the provided MBeanServerConnection.
 *
 * @param server MBeanServerConnection to use for obtaining thread information
 *    via the OperatingSystemMXBean.
 */
def static void displayOperatingSystemInfo(MBeanServerConnection server)
{
    def osMxBean = ManagementFactory.newPlatformMXBeanProxy(
            server,
            ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
            OperatingSystemMXBean.class)
    println "Architecture: ${osMxBean.getArch()}"
    println "Number of Processors: ${osMxBean.getAvailableProcessors()}"
    println "Name: ${osMxBean.getName()}"
    println "Version: ${osMxBean.getVersion()}"
    println "System Load Average: ${osMxBean.getSystemLoadAverage()}"
}

/**
 * Display operating system information based on RuntimeMXBean associated with
 * the provided MBeanServerConnection.
 *
 * @param server MBeanServerConnection to use for obtaining thread information
 *    via the RuntimeMXBean.
 */
def static void displayRuntimeInfo(MBeanServerConnection server)
{
    def remoteRuntime = ManagementFactory.newPlatformMXBeanProxy(
            server,
            ManagementFactory.RUNTIME_MXBEAN_NAME,
            RuntimeMXBean.class);

    println "Target Virtual Machine: ${remoteRuntime.getName()}"
    println "Uptime: ${remoteRuntime.getUptime()}"
    println "Classpath: ${remoteRuntime.getClassPath()}"
    println "Arguments: ${remoteRuntime.getInputArguments()}"
}


/**
 * Display operating system information based on MemoryMXBean associated with
 * the provided MBeanServerConnection.
 *
 * @param server MBeanServerConnection to use for obtaining thread information
 *    via the MemoryMXBean.
 */
def static void displayMemoryInfo(MBeanServerConnection server)
{
    def memoryMxBean = ManagementFactory.newPlatformMXBeanProxy(
            server,
            ManagementFactory.MEMORY_MXBEAN_NAME,
            MemoryMXBean.class);
    println "HEAP Memory: ${memoryMxBean.getHeapMemoryUsage()}"
    println "Non-HEAP Memory: ${memoryMxBean.getNonHeapMemoryUsage()}"
}