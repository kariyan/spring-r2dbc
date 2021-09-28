package com.example.r2dbc.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class WonderHotelBooking(
    @Id
    val id: Long,
    val bookingId: String,
    val hotelId: Int,
    val wid: Long?,
    @Column("roomtype_id")
    val roomTypeId: String,
    @Column("roomtype_name")
    var roomTypeName: String
)
