package com.example.r2dbc.service.controller

import com.example.r2dbc.config.DatabaseConfig
import com.example.r2dbc.config.WKmsConfig
import com.example.r2dbc.domain.entity.BookingStatus
import com.example.r2dbc.service.logic.BookingServiceLogic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.AutoConfigureDataR2dbc
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@Import([BookingServiceLogic,
        DatabaseConfig,
        WKmsConfig,
])
@WebFluxTest(BookingController)
@AutoConfigureDataR2dbc
class BookingControllerTest extends Specification {

    @Autowired
    private WebTestClient webTestClient

    def "FindBookingInfo"() {
        expect:
        webTestClient.get()
                .uri("/483")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("\$.bookingStatus").value { it == BookingStatus.STANDBY.name() }
    }
}
