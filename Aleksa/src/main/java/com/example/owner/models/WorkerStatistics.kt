package com.example.owner.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.owner.R

class WorkerStatistics(
    val workerId: Int = 0,
    val workerName: String = "",
    val workerLastName: String = "",
    val workerImage: Int = 0,
    val tablesServed: Int = 0,
    val moneyEarned: Double = 0.0,
    val tipsEarned: Double = 0.0,
    val avgWaitTime: Int = 0
) {

    @Composable
    public fun getPainter(): Painter {
        return painterResource(id = workerImage)
    }
    companion object {
        const val DAILY = 0
        const val MONTHLY = 1
        const val YEARLY = 2

        const val TABLES = 0
        const val MONEY = 1
        const val TIPS = 2
        const val WAIT = 3
        @Composable
        fun getFakeStatistics(period: Int): List<WorkerStatistics> {
            val mul = when(period) {DAILY -> 1; MONTHLY -> 30; YEARLY -> 365; else -> 1}
            return listOf(
                WorkerStatistics(
                    workerId = 0,
                    workerName = "Mark",
                    workerLastName = "Anderson",
                    workerImage = R.drawable.worker0,
                    tablesServed = 15 * mul,
                    moneyEarned = 120.56 * mul,
                    tipsEarned = 12.5 * mul,
                    avgWaitTime = 130
                ),
                WorkerStatistics(
                    workerId = 1,
                    workerName = "Peter",
                    workerLastName = "Jones",
                    workerImage = R.drawable.worker1,
                    tablesServed = 20 * mul,
                    moneyEarned = 107.5 * mul,
                    tipsEarned = 10.0 * mul,
                    avgWaitTime = 234
                ),
                WorkerStatistics(
                    workerId = 2,
                    workerName = "Maya",
                    workerLastName = "Williams",
                    workerImage = R.drawable.worker2,
                    tablesServed = 26 * mul,
                    moneyEarned = 170.34 * mul,
                    tipsEarned = 26.0 * mul,
                    avgWaitTime = 90
                ),
                WorkerStatistics(
                    workerId = 3,
                    workerName = "Tanya",
                    workerLastName = "Ivanovich",
                    workerImage = R.drawable.worker3,
                    tablesServed = 13 * mul,
                    moneyEarned = 50.2 * mul,
                    tipsEarned = 6.7 * mul,
                    avgWaitTime = 236
                )
            )
        }
    }
}