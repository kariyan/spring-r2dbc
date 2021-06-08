package com.example.r2dbc.domain.service

import com.example.r2dbc.domain.entity.WonderHotelBooking
import reactor.core.publisher.Flux

interface BookingService {
    fun findBookings(): Flux<WonderHotelBooking>
}
