package com.example.r2dbc.domain.entity

import org.springframework.data.annotation.Id

data class WonderHotelBooking(
    @Id
    val id: Long,
    val bookingId: String,
    val hotelId: Int,
    val wid: Long?,
    val roomtypeId: String,
    val roomtypeName: String
)
