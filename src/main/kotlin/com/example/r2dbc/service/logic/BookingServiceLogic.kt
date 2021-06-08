package com.example.r2dbc.service.logic

import com.example.r2dbc.domain.entity.WonderHotelBooking
import com.example.r2dbc.domain.service.BookingService
import com.example.r2dbc.domain.store.WonderHotelBookingRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class BookingServiceLogic(val wonderHotelBookingRepository: WonderHotelBookingRepository) : BookingService {
    override fun findBookings(): Flux<WonderHotelBooking> {
        return wonderHotelBookingRepository.findFirst10By()
    }
}
