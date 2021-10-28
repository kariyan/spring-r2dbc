package com.example.r2dbc.domain.service

import com.example.r2dbc.domain.entity.WonderHotelBooking
import reactor.core.publisher.Mono

interface BookingService {
    fun findBookingById(bookingId: Long): Mono<WonderHotelBooking>
    fun modifyRoomTypeName(id: Long, roomTypeName: String): Mono<WonderHotelBooking>
}
