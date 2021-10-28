package com.example.r2dbc.domain.entity

import com.example.r2dbc.common.CodeEnum
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
    var roomTypeName: String,
    val bookingStatus: BookingStatus
)

enum class BookingStatus(private val _code: String): CodeEnum {
    BOOKED("booked"),
    CANCEL("cancel"),
    STANDBY("standby"),
    PENDING("pending"),
    PENDING_CANCEL("pendingCancel"),
    ;

    override fun getCode(): String {
        return _code
    }
}

