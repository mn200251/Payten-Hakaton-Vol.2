package com.example.owner.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.owner.R

class Worker(
    val id: Int = 0,
    val placeId: Int = 0,
    val name: String = "",
    val lastName: String = "",
    val image: Int = 0
) {

    companion object {
        @Composable
        public fun getFakeWorkers(): List<Worker> {
            return listOf(
                Worker(id = 0, placeId = 0, name = "Peter", lastName = "Jones", image = R.drawable.worker1),
                Worker(id = 1, placeId = 0, name = "Maya", lastName = "Williams", image = R.drawable.worker2)
            )
        }
    }

    @Composable
    public fun getPainter(): Painter {
        return painterResource(id = image)
    }
}