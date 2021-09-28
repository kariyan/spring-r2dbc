package com.example.r2dbc.service.logic

import com.example.r2dbc.domain.entity.WonderHotelBooking
import com.example.r2dbc.domain.service.BookingService
import com.example.r2dbc.domain.store.WonderHotelBookingRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookingServiceLogic(private val wonderHotelBookingRepository: WonderHotelBookingRepository) : BookingService {
    override fun findBookings(): Flux<WonderHotelBooking> {
        return wonderHotelBookingRepository.findFirst10By()
    }

    override fun modifyRoomTypeName(id: Long, roomTypeName: String): Mono<WonderHotelBooking> {
        return wonderHotelBookingRepository.findById(id)
            .map {
                it.roomTypeName = roomTypeName
                it
            }
            .doOnSuccess { wonderHotelBookingRepository.save(it) }
            .then(wonderHotelBookingRepository.findById(id))
    }
}
