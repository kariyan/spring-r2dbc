package com.example.r2dbc

import com.example.r2dbc.domain.entity.BaseEntity
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    val baseEntity = BaseEntity("base entity")
    logger.info(baseEntity.name)
}
