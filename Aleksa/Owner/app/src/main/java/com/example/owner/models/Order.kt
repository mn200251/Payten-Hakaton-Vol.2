package com.example.owner.models

import android.os.Parcelable
import com.example.owner.ui.getDate
import com.example.owner.ui.getNow
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Order(
    val id: Int = 0,
    val placeId: Int = 0,
    val username: String = "",
    val workerId: Int? = 0,
    val table: String? = null,
    var itemsServed: Int = 0,
    val totalItems: Int = 0,
    val paymethod: Int? = 0,
    val price: Double = 0.0,
    val tip: Double? = 0.0,
    val dateOrdered: LocalDateTime = getDate("2023-11-28 12:00:00"),
    val datePaid: LocalDateTime? = null
) {
    public val status: Int
        get() {
            if (workerId == null) return PENDING
            else if (datePaid != null) return DONE
            else if (itemsServed != totalItems) return WAITING
            else if (paymethod == null) return IDLE
            else return PAYMENT
        }
    companion object {
        const val PENDING: Int = 0
        const val WAITING: Int = 1
        const val IDLE: Int = 2
        const val PAYMENT: Int = 3
        const val DONE: Int = 4

        const val CASH = 0
        const val CARD = 1

        public val fakeOrders: List<Order> = listOf(
            Order(id = 1, placeId = 0, username = "user2", workerId = null, table = "Table 2-1", itemsServed = 0,
                totalItems = 1, paymethod = null, price = 1.5, tip = null,
                dateOrdered = getDate("2023-11-28 12:00:01"), datePaid = null),
            Order(id = 0, placeId = 0, username = "user", workerId = 0, table = "Table 1-3", itemsServed = 1,
                totalItems = 3, paymethod = null, price = 9.5, tip = null,
                dateOrdered = getDate("2023-11-28 11:59:00"), datePaid = null),
            Order(id = 4, placeId = 0, username = "anna123", workerId = 0, table = null, itemsServed = 0,
                totalItems = 1, paymethod = CASH, price = 3.3, tip = 0.2,
                dateOrdered = getDate("2023-11-28 12:10:23"), datePaid = null),
            Order(id = 3, placeId = 0, username = "user4", workerId = 0, table = "Table 1-5", itemsServed = 2,
                totalItems = 2, paymethod = CARD, price = 6.0, tip = 0.5,
                dateOrdered = getDate("2023-11-28 11:00:01"), datePaid = null),
            Order(id = 2, placeId = 0, username = "user3", workerId = 0, table = "Table 2-2", itemsServed = 3,
                totalItems = 3, paymethod = null, price = 9.5, tip = null,
                dateOrdered = getDate("2023-11-28 11:10:22"), datePaid = null),
            )

        private val fakeItems0: List<OrderItem> = listOf(
            OrderItem(
                id = 0,
                orderId =  0,
                note = "No salt please",
                itemId = 0,
                name = "Margarita",
                price = 3.0,
                dateOrdered = getDate("2023-11-28 11:59:00"),
                dateServed = null
            ),
            OrderItem(
                id = 1,
                orderId = 0,
                note = null,
                itemId = 1,
                name = "Mojito",
                price = 3.5,
                dateOrdered = getDate("2023-11-28 11:59:00"),
                dateServed = null
            ),
            OrderItem(
                id = 2,
                orderId = 0,
                note = "",
                itemId = 5,
                name = "Apple pie",
                price = 3.0,
                dateOrdered = getDate("2023-11-28 11:59:00"),
                dateServed = getDate("2023-11-28 12:00:56")
            )
        )
        private val fakeItems1: List<OrderItem> = listOf(
            OrderItem(
                id = 3,
                orderId = 1,
                note = null,
                itemId = 6,
                name = "Chocolate Muffin",
                price = 1.5,
                dateOrdered = getDate("2023-11-28 12:00:01"),
                dateServed = null
            )
        )
        private val fakeItems2: List<OrderItem> = listOf(
            OrderItem(
                id = 4,
                orderId = 2,
                note = null,
                itemId = 0,
                name = "Margarita",
                price = 3.0,
                dateOrdered = getDate("2023-11-28 11:10:22"),
                dateServed = getDate("2023-11-28 11:13:21")

            ),
            OrderItem(
                id = 5,
                orderId = 2,
                note = null,
                itemId = 0,
                name = "Margarita",
                price = 3.0,
                dateOrdered = getDate("2023-11-28 11:10:22"),
                dateServed = getDate("2023-11-28 11:13:21")
            ),
            OrderItem(
                id = 6,
                orderId = 2,
                note = null,
                itemId = 2,
                name = "Blue Lagoon",
                price = 3.5,
                dateOrdered = getDate("2023-11-28 11:10:22"),
                dateServed = getDate("2023-11-28 11:13:21")
            )
        )
        private val fakeItems3: List<OrderItem> = listOf(
            OrderItem(
                id = 7,
                orderId = 3,
                note = "Extra chocolate filling on the side please.",
                itemId = 4,
                name = "Sachertorte",
                price = 2.5,
                dateOrdered = getDate("2023-11-28 11:00:01"),
                dateServed = getDate("2023-11-28 11:10:02")
            ),
            OrderItem(
                id = 8,
                orderId = 3,
                note = null,
                itemId = 1,
                name = "Mojito",
                price = 3.5,
                dateOrdered = getDate("2023-11-28 11:00:01"),
                dateServed = getDate("2023-11-28 11:10:02")
            )
        )
        private val fakeItems4: List<OrderItem> = listOf(
            OrderItem(
                id = 9,
                orderId = 4,
                note = "Add lots of ketchup pls",
                itemId = 8,
                name = "Club Sandwich",
                price = 3.3,
                dateOrdered = getDate("2023-11-28 12:10:23"),
                dateServed = null
            )
        )
    }
    public val waitTimeSecs: Long
        get () {
            if (status == PENDING) return Duration.between(dateOrdered, getNow()).seconds
            if (status != WAITING) return 0
            var max: Long = 0
            for (item in getItems()) if (!item.served && item.waitTimeSecs > max) max = item.waitTimeSecs
            return max
        }
    public val waitTime: String
        get() {
            return String.format("%02d:%02d", waitTimeSecs/60, waitTimeSecs%60)
        }


    public fun getItems(): List<OrderItem> {
        /*TO DO
        *
        * Create a flow that queries the server periodically,
        * and convert it to a state flow.*/
        if (id == 0) return fakeItems0
        else if (id == 1) return fakeItems1
        else if (id == 2) return fakeItems2
        else if (id == 3) return fakeItems3
        else if (id == 4) return fakeItems4
        else return listOf()
    }
}