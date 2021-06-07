package com.example.r2dbc.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

//@Configuration
class HmsDatabaseConfig : AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        TODO("Not yet implemented")
    }
}
