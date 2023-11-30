package com.example.owner.statistics

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
    override val route = "Visits"
}

object ItemSales : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "Item Sales"
}

object AverageWaitTime : SnippetDestination {
    override val icon = Icons.Default.Lock
    override val route = "Average Wait Time"
}

object TotalWaitTime : SnippetDestination {
    override val icon = Icons.Default.Phone
    override val route = "Total Wait Time"
}

object UnclaimedOrders : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "Waiter Sales"
}

object AverageOrderPickupTime : SnippetDestination {
    override val icon = Icons.Default.Email
    override val route = "Average Pickup Time"
}

val snippetDestinations = listOf(
    SelectScreen, Visitation, ItemSales, AverageWaitTime,
    TotalWaitTime, UnclaimedOrders, AverageOrderPickupTime
)