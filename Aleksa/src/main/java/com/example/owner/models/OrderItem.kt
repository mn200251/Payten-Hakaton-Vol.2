package com.example.owner.models

import com.example.owner.ui.getDate
import com.example.owner.ui.getNow
import java.time.Duration
import java.time.LocalDateTime

class OrderItem(
    val id: Int = 0,
    val itemId: Int = 0,
    val orderId: Int = 0,
    val note: String? = null,
    val name: String = "",
    val price: Double = 0.0,
    val dateOrdered: LocalDateTime = getDate("2023-11-28 11:59:00"),
    val dateServed: LocalDateTime? = null
) {
    public val served: Boolean
        get() {
            return dateServed != null
        }

    public val waitTimeSecs: Long
        get() {
            if (dateServed != null) return Duration.between(dateOrdered, dateServed).seconds
            else return Duration.between(dateOrdered, getNow()).seconds
        }

    public val waitTime: String
        get() {
            val secs = waitTimeSecs
            return String.format("%02d:%02d", waitTimeSecs/60, waitTimeSecs%60)
        }
}