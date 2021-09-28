package com.example.r2dbc.domain.service

import com.example.r2dbc.domain.entity.WonderHotelBooking
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookingService {
    fun findBookings(): Flux<WonderHotelBooking>
    fun modifyRoomTypeName(id: Long, roomTypeName: String): Mono<WonderHotelBooking>
}
