package com.example.r2dbc.domain.store

import com.example.r2dbc.domain.entity.WonderHotelBooking
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface WonderHotelBookingRepository : ReactiveCrudRepository<WonderHotelBooking, Long>
