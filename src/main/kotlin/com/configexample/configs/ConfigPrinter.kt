package com.configexample.configs

import io.micronaut.context.annotation.Context
import io.micronaut.context.env.DefaultEnvironment
import io.micronaut.core.convert.format.MapFormat
import io.micronaut.core.naming.conventions.StringConvention
import org.slf4j.LoggerFactory

@Context
class EncryptedConfigPrinter(
    defaultEnvironment: DefaultEnvironment
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    init {
        val configMap = defaultEnvironment.getAllProperties(StringConvention.RAW, MapFormat.MapTransformation.NESTED).toSortedMap()
        log.info("config_current_encrypted","config" to configMap.toSortedMap())
    }
}