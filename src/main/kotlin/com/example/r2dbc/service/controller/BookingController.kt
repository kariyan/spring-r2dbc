package com.example.r2dbc.service.controller

import com.example.r2dbc.domain.entity.WonderHotelBooking
import com.example.r2dbc.domain.service.BookingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class BookingController(val bookingService: BookingService) {
    @GetMapping
    fun findBookingInfo(): Flux<WonderHotelBooking> {
        return bookingService.findBookings()
    }
}
