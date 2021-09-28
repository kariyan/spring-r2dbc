package com.example.r2dbc.config

import mu.KLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono
import java.time.Duration

@Configuration
class WKmsConfig {
    companion object : KLogging()

    @Bean
    fun kmsProperties(): Mono<KmsProperties> {
        return Mono.defer {
            Mono.just(KmsProperties("sample"))
                .doOnSuccess { logger.debug("check!!") }
                .delayElement(Duration.ofSeconds(3))
        }
    }
}

data class KmsProperties(private val key: String)
