package com.example.r2dbc.config

import com.example.r2dbc.config.converter.CodeEnumReadingConverterFactory
import com.example.r2dbc.config.converter.CodeEnumWritingConverterFactory
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfig : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory {
        val userName = "grp_travel_dev"
        val password = "NjI3ZDUwNzM5N2Jj"
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "pool")
                .option(ConnectionFactoryOptions.PROTOCOL, "mysql")
                .option(ConnectionFactoryOptions.HOST, "nd-integrated.devdb.wemakeprice.work")
                .option(ConnectionFactoryOptions.PORT, 3307)
                .option(ConnectionFactoryOptions.DATABASE, "hms_dev")
                .option(ConnectionFactoryOptions.USER, userName)
                .option(ConnectionFactoryOptions.PASSWORD, password)
                .build()
        )
    }

    override fun getCustomConverters(): List<Any> {
        val converterList = mutableListOf<Any>()
        converterList.add(CodeEnumReadingConverterFactory())
        converterList.add(CodeEnumWritingConverterFactory())
        return converterList
    }
}
