package com.example.owner.models

import com.example.owner.ui.getDate
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Order(
    val id: Int = 0,
    val placeId: Int = 0,
    val username: String = "",
    val workerId: Int? = 0,
    val table: String = "",
    val status: Int = 0,
    val itemsServed: Int = 0,
    val paymethod: Int? = 0,
    val price: Double = 0.0,
    val tip: Double? = 0.0,
    val date: LocalDateTime = getDate("2023-11-28 12:00:00")
) {

    companion object {
        const val PENDING: Int = 0
        const val WAITING: Int = 1
        const val IDLE: Int = 2
        const val PAYMENT: Int = 3
        const val DONE: Int = 4

        const val CASH = 0
        const val CARD = 1


        public fun getFakeOrders(): List<Order> {
            return listOf(
                Order(id = 0, placeId = 0, username = "user", workerId = 0, table = "Table 1-3", status = WAITING,
                    itemsServed = 2, paymethod = null, price = 9.5, tip = null, date = getDate("2023-11-28 11:46:00")),
                Order(id = 1, placeId = 0, username = "user2", workerId = 0, table = "Table 2-1", status = PENDING,
                    itemsServed = 0, paymethod = null, price = 1.5, tip = null, date = getDate("2023-11-28 12:00:01")),
                Order(id = 3, placeId = 0, username = "user4", workerId = 0, table = "Table 1-5", status = PAYMENT,
                    itemsServed = 2, paymethod = CARD, price = 6.0, tip = 0.5, date = getDate("2023-11-28 10:00:01")),
                Order(id = 2, placeId = 0, username = "user3", workerId = 0, table = "Table 2-2", status = IDLE,
                    itemsServed = 3, paymethod = null, price = 9.5, tip = null, date = getDate("2023-11-28 10:10:22")),
            )
        }
    }
    public fun getItems(): List<OrderItem> {
        /*TO DO
        *
        * Create a flow that queries the server periodically,
        * and convert it to a state flow.*/
        if (id == 0) return listOf(
            OrderItem(
                id = 0,
                orderId =  0,
                note = "No salt please",
                served = 0,
                itemId = 0,
                name = "Margherita",
                price = 3.0
            ),
            OrderItem(
                id = 1,
                orderId = 0,
                note = null,
                served = 0,
                itemId = 1,
                name = "Mojito",
                price = 3.5
            ),
            OrderItem(
                id = 2,
                orderId = 0,
                note = "",
                served = 1,
                itemId = 5,
                name = "Apple pie",
                price = 3.0
            )
        ) else if (id == 1) return listOf(
            OrderItem(
                id = 3,
                orderId = 1,
                note = null,
                served = 0,
                itemId = 6,
                name = "Chocolate Muffin",
                price = 1.5
            )
        ) else if (id == 2) return listOf(
            OrderItem(
                id = 4,
                orderId = 2,
                note = null,
                served = 1,
                itemId = 0,
                name = "Margherita",
                price = 3.0
            ),
            OrderItem(
                id = 5,
                orderId = 2,
                note = null,
                served = 1,
                itemId = 0,
                name = "Margherita",
                price = 3.0
            ),
            OrderItem(
                id = 6,
                orderId = 2,
                note = null,
                served = 1,
                itemId = 2,
                name = "Blue Lagoon",
                price = 3.5
            )
        ) else if (id == 3) return listOf(
            OrderItem(
                id = 7,
                orderId = 3,
                note = "Extra chocolate filling on the side please.",
                served = 1,
                itemId = 4,
                name = "Sachertorte",
                price = 2.5
            ),
            OrderItem(
                id = 8,
                orderId = 3,
                note = null,
                served = 1,
                itemId = 1,
                name = "Mojito",
                price = 3.5
            )
        )
        else return listOf()
    }
}