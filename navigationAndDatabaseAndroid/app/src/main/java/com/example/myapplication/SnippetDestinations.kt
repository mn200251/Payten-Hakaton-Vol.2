package com.example.myapplication

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

interface SnippetDestination {
    val icon: ImageVector
    val route: String
}

object SelectScreen : SnippetDestination {
    override val icon = Icons.Default.Lock
    override val route = "SelectScreen"
}

object Visitation : SnippetDestination {
    override val icon = Icons.Default.Phone
    override val route = "Visitation"
}

object ItemSales : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "ItemSales"
}

object AverageWaitTime : SnippetDestination {
    override val icon = Icons.Default.Lock
    override val route = "AverageWaitTime"
}

object TotalWaitTime : SnippetDestination {
    override val icon = Icons.Default.Phone
    override val route = "TotalWaitTime"
}

object UnclaimedOrders : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "WaiterSales"
}

object AverageOrderPickupTime : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "AvgPickupTime"
}

val snippetDestinations = listOf(
    SelectScreen, Visitation, ItemSales, AverageWaitTime,
    TotalWaitTime, UnclaimedOrders, AverageOrderPickupTime
)