package com.example.r2dbc.service.controller

import com.example.r2dbc.config.KmsProperties
import com.example.r2dbc.domain.entity.WonderHotelBooking
import com.example.r2dbc.domain.service.BookingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class BookingController(
    private val bookingService: BookingService,
    private val kmsProperties: Mono<KmsProperties>
) {
    @GetMapping("/{bookingId}")
    fun findBookingInfo(@PathVariable bookingId: Long): Mono<WonderHotelBooking> {
        return bookingService.findBookingById(bookingId)
    }

    @PutMapping("/{id}")
    fun modifyRoomTypeName(@PathVariable id: Long, roomTypeName: String): Mono<WonderHotelBooking> {
        return bookingService.modifyRoomTypeName(id, roomTypeName)
    }

    @GetMapping("kms")
    fun promptKmsProperties(): KmsProperties? {
        return kmsProperties.block()
    }
}
