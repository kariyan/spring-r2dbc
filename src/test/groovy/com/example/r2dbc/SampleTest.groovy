package com.example.r2dbc

import com.example.r2dbc.domain.entity.BaseEntity
import com.example.r2dbc.domain.entity.WonderHotelBooking
import spock.lang.Specification

class SampleTest extends Specification {

    def "Java 테스트"() {
        given:
        def entity = new BaseEntity("sample")

        expect:
        entity.getName() == "sample"
    }

    def "Kotlin 테스트"() {
        given:
        def booking = new WonderHotelBooking(0, "20201010", 13156, 112141L,
                "SM-30", "WindowPool")

        expect:
        booking.hotelId == 13156
    }
}
