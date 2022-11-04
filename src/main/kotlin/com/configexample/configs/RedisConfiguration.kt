package com.configexample.configs

import io.micronaut.context.annotation.ConfigurationInject
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.EachProperty
import io.micronaut.context.annotation.Parameter
import jakarta.inject.Named
import jakarta.inject.Singleton

@Singleton
class RedisConfiguration(
    @Named("in") val inbound: TechConfiguration,
    @Named("out") val outbound: TechConfiguration,
) {
}

@Context
@EachProperty(TechConfiguration.PREFIX)
data class TechConfiguration
@ConfigurationInject
constructor(
    @Parameter val name: String,
    private val testConfigs: TechTestConfiguration,
    private val members: Int? = 1,
    private val maxMembers: Int? = 100
) {
    companion object {
        const val PREFIX = "tech"
    }
}

data class TechTestConfiguration
@ConfigurationInject
constructor(
    private val teamName: String,
    private val groupName: String? = null
) {
}

data class TechTestTaskConfiguration
@ConfigurationInject
constructor(
    private val enabled: Boolean? = null
) {
}