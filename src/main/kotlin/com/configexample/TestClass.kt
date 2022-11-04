package com.configexample

import com.configexample.configs.EncryptedConfigPrinter
import com.configexample.configs.TechConfiguration
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory


@Singleton
class TestClass(
    private val configPrinter: EncryptedConfigPrinter,
    private val techConfiguration: TechConfiguration
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    init {
        log.info("")
    }
}