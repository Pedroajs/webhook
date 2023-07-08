package com.example.pipefywebhook

import org.slf4j.Logger

open class LoggerUtil {
    fun log(s: String) {
        logger().info(s)
    }
}

fun <T : Any> T.logger(): Logger = getLogger(getClassForLogging(javaClass))