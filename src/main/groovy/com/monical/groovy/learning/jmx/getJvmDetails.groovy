package com.monical.groovy.learning.jmx

import com.monical.groovy.learning.jmx.attachToVirtualMachine
import com.sun.management.HotSpotDiagnosticMXBean

import java.lang.management.ManagementFactory

/**
 * @author monical* @date 2020-05-15 17:38:22
 */

def serverConnection = attachToVirtualMachine.retrieveServerConnection(args[0])

//displayMxBeanDerivedInfo.displayThreadInfo(serverConnection)
//displayMxBeanDerivedInfo.displayOperatingSystemInfo(serverConnection)
//displayMxBeanDerivedInfo.displayRuntimeInfo(serverConnection)
//displayMxBeanDerivedInfo.displayMemoryInfo(serverConnection)

def HOTSPOT_BEAN_NAME = "com.sun.management:type=HotSpotDiagnostic"
def bean = ManagementFactory.newPlatformMXBeanProxy(serverConnection, HOTSPOT_BEAN_NAME, HotSpotDiagnosticMXBean)
bean.setVMOption('HeapDumpBeforeFullGC', 'true')
bean.setVMOption('HeapDumpAfterFullGC', 'true')
System.gc()
//bean.setVMOption('HeapDumpBeforeFullGC', 'false')
//bean.setVMOption('HeapDumpAfterFullGC', 'false')