package com.example.r2dbc.domain.store

import com.example.r2dbc.domain.entity.WonderHotelBooking
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface WonderHotelBookingRepository : ReactiveCrudRepository<WonderHotelBooking, Long> {
    fun findFirst10By(): Flux<WonderHotelBooking>
}
