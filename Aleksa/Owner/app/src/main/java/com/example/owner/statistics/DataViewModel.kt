package com.example.myapplication

import androidx.lifecycle.ViewModel
import co.yml.charts.common.model.Point
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class DataViewModel : ViewModel() {
    private val _visitations = MutableStateFlow(listOf<Point>())
    val visitations = _visitations.asStateFlow()
    private val _waitTime = MutableStateFlow(listOf<Point>())
    val waitTime = _waitTime.asStateFlow()
    private val _avgWaitTime = MutableStateFlow(listOf<Point>())
    val avgWaitTime = _avgWaitTime.asStateFlow()
    private val _avgPickupTime = MutableStateFlow(listOf<Point>())
    val avgPickupTime = _avgPickupTime.asStateFlow()

    fun setVisitData(newValue: List<Point>) { _visitations.update { newValue } }
    fun setWaitTime(newValue: List<Point>) { _waitTime.update { newValue } }
    fun setWaitTimeAvg(newValue: List<Point>) { _avgWaitTime.update { newValue } }
    fun setAvgPickupTime(newValue: List<Point>) { _avgPickupTime.update { newValue } }

    fun setDay1() { day1VisitData(); day1WaitTime(); calcWaitTimeAvg(); day1AvgPickupTime(); }
    fun setDay2() { day2VisitData(); day2WaitTime(); calcWaitTimeAvg(); day2AvgPickupTime(); }
    fun setDay3() { day3VisitData(); day3WaitTime(); calcWaitTimeAvg(); day3AvgPickupTime(); }

    fun day1VisitData() {
        setVisitData(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 0f, "p1"),
                Point( 8f, 3f, "p2"), Point( 9f, 10f, "p3"),
                Point( 10f, 15f, "p4"), Point( 11f, 6f, "p5"),
                Point( 12f, 3f, "p1"), Point( 13f, 2f, "p1"),
                Point( 14f, 12f, "p2"), Point( 15f, 11f, "p3"),
                Point( 16f, 5f, "p4"), Point( 17f, 16f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 9f, "p5"),
                Point( 20f, 16f, "p5"), Point( 21f, 9f, "p5"),
                Point( 22f, 8f, "p5"), Point( 23f, 2f, "p5"),
            )
        )
    }

    fun day2VisitData() {
        setVisitData(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 1f, "p1"),
                Point( 8f, 3f, "p2"), Point( 9f, 2f, "p3"),
                Point( 10f, 7f, "p4"), Point( 11f, 7f, "p5"),
                Point( 12f, 7f, "p1"), Point( 13f, 2f, "p1"),
                Point( 14f, 1f, "p2"), Point( 15f, 10f, "p3"),
                Point( 16f, 25f, "p4"), Point( 17f, 17f, "p5"),
                Point( 18f, 8f, "p5"), Point( 19f, 9f, "p5"),
                Point( 20f, 16f, "p5"), Point( 21f, 19f, "p5"),
                Point( 22f, 8f, "p5"), Point( 23f, 2f, "p5"),
            )
        )
    }

    fun day3VisitData() {
        setVisitData(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 5f, "p1"),
                Point( 8f, 3f, "p2"), Point( 9f, 12f, "p3"),
                Point( 10f, 7f, "p4"), Point( 11f, 7f, "p5"),
                Point( 12f, 7f, "p1"), Point( 13f, 2f, "p1"),
                Point( 14f, 1f, "p2"), Point( 15f, 4f, "p3"),
                Point( 16f, 5f, "p4"), Point( 17f, 7f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 12f, "p5"),
                Point( 20f, 11f, "p5"), Point( 21f, 9f, "p5"),
                Point( 22f, 8f, "p5"), Point( 23f, 2f, "p5"),
            )
        )
    }

    fun day1WaitTime() {
        setWaitTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 5f, "p1"),
                Point( 8f, 15f, "p2"), Point( 9f, 70f, "p3"),
                Point( 10f, 10f, "p4"), Point( 11f, 57f, "p5"),
                Point( 12f, 8f, "p1"), Point( 13f, 100f, "p1"),
                Point( 14f, 13f, "p2"), Point( 15f, 84f, "p3"),
                Point( 16f, 35f, "p4"), Point( 17f, 45f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 150f, "p5"),
                Point( 20f, 110f, "p5"), Point( 21f, 20f, "p5"),
                Point( 22f, 90f, "p5"), Point( 23f, 10f, "p5"),
            )
        )
    }
    fun day2WaitTime() {
        setWaitTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 9f, "p1"),
                Point( 8f, 25f, "p2"), Point( 9f, 50f, "p3"),
                Point( 10f, 17f, "p4"), Point( 11f, 37f, "p5"),
                Point( 12f, 5f, "p1"), Point( 13f, 80f, "p1"),
                Point( 14f, 4f, "p2"), Point( 15f, 54f, "p3"),
                Point( 16f, 35f, "p4"), Point( 17f, 5f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 100f, "p5"),
                Point( 20f, 130f, "p5"), Point( 21f, 27f, "p5"),
                Point( 22f, 70f, "p5"), Point( 23f, 7f, "p5"),
            )
        )
    }
    fun day3WaitTime() {
        setWaitTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 33f, "p1"),
                Point( 8f, 25f, "p2"), Point( 9f, 20f, "p3"),
                Point( 10f, 57f, "p4"), Point( 11f, 137f, "p5"),
                Point( 12f, 55f, "p1"), Point( 13f, 70f, "p1"),
                Point( 14f, 54f, "p2"), Point( 15f, 44f, "p3"),
                Point( 16f, 25f, "p4"), Point( 17f, 15f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 20f, "p5"),
                Point( 20f, 80f, "p5"), Point( 21f, 17f, "p5"),
                Point( 22f, 50f, "p5"), Point( 23f, 7f, "p5"),
            )
        )
    }

    fun avgWt(wt: Float, nv: Float) : Float {
        var num = wt / nv;
        if (num.isNaN()) num = 0f
        if (num.isInfinite()) num = 0f
        return num
    }

    fun calcWaitTimeAvg() {
        setWaitTimeAvg(
            listOf(
                Point( 0f, avgWt(waitTime.value[0].y, visitations.value[0].y), "p1"),
                Point( 1f, avgWt(waitTime.value[1].y, visitations.value[1].y), "p1"),
                Point( 2f, avgWt(waitTime.value[2].y, visitations.value[2].y), "p1"),
                Point( 3f, avgWt(waitTime.value[3].y, visitations.value[3].y), "p1"),
                Point( 4f, avgWt(waitTime.value[4].y, visitations.value[4].y), "p1"),
                Point( 5f, avgWt(waitTime.value[5].y, visitations.value[5].y), "p1"),
                Point( 6f, avgWt(waitTime.value[6].y, visitations.value[6].y), "p1"),
                Point( 7f, avgWt(waitTime.value[7].y, visitations.value[7].y), "p1"),
                Point( 8f, avgWt(waitTime.value[8].y, visitations.value[8].y), "p1"),
                Point( 9f, avgWt(waitTime.value[9].y, visitations.value[9].y), "p1"),
                Point( 10f, avgWt(waitTime.value[10].y, visitations.value[10].y), "p1"),
                Point( 11f, avgWt(waitTime.value[11].y, visitations.value[11].y), "p1"),
                Point( 12f, avgWt(waitTime.value[12].y, visitations.value[12].y), "p1"),
                Point( 13f, avgWt(waitTime.value[13].y, visitations.value[13].y), "p1"),
                Point( 14f, avgWt(waitTime.value[14].y, visitations.value[14].y), "p1"),
                Point( 15f, avgWt(waitTime.value[15].y, visitations.value[15].y), "p1"),
                Point( 16f, avgWt(waitTime.value[16].y, visitations.value[16].y), "p1"),
                Point( 17f, avgWt(waitTime.value[17].y, visitations.value[17].y), "p1"),
                Point( 18f, avgWt(waitTime.value[18].y, visitations.value[18].y), "p1"),
                Point( 19f, avgWt(waitTime.value[19].y, visitations.value[19].y), "p1"),
                Point( 20f, avgWt(waitTime.value[20].y, visitations.value[20].y), "p1"),
                Point( 21f, avgWt(waitTime.value[21].y, visitations.value[21].y), "p1"),
                Point( 22f, avgWt(waitTime.value[22].y, visitations.value[22].y), "p1"),
                Point( 23f, avgWt(waitTime.value[23].y, visitations.value[23].y), "p1"),
            )
        )
    }

    fun day1AvgPickupTime() {
        setAvgPickupTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 0f, "p1"),
                Point( 8f, 5f, "p2"), Point( 9f, 15f, "p3"),
                Point( 10f, 17f, "p4"), Point( 11f, 16f, "p5"),
                Point( 12f, 30f, "p1"), Point( 13f, 12f, "p1"),
                Point( 14f, 12f, "p2"), Point( 15f, 21f, "p3"),
                Point( 16f, 5f, "p4"), Point( 17f, 26f, "p5"),
                Point( 18f, 13f, "p5"), Point( 19f, 19f, "p5"),
                Point( 20f, 16f, "p5"), Point( 21f, 3f, "p5"),
                Point( 22f, 8f, "p5"), Point( 23f, 2f, "p5"),
            )
        )
    }

    fun day2AvgPickupTime() {
        setAvgPickupTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 3f, "p1"),
                Point( 8f, 31f, "p2"), Point( 9f, 12f, "p3"),
                Point( 10f, 7f, "p4"), Point( 11f, 7f, "p5"),
                Point( 12f, 7f, "p1"), Point( 13f, 2f, "p1"),
                Point( 14f, 7f, "p2"), Point( 15f, 10f, "p3"),
                Point( 16f, 25f, "p4"), Point( 17f, 2f, "p5"),
                Point( 18f, 28f, "p5"), Point( 19f, 2f, "p5"),
                Point( 20f, 36f, "p5"), Point( 21f, 19f, "p5"),
                Point( 22f, 8f, "p5"), Point( 23f, 0f, "p5"),
            )
        )
    }

    fun day3AvgPickupTime() {
        setAvgPickupTime(
            listOf(
                Point( 0f, 0f, "p1"), Point( 1f, 0f, "p1"),
                Point( 2f, 0f, "p2"), Point( 3f, 0f, "p3"),
                Point( 4f, 0f, "p4"), Point( 5f, 0f, "p5"),
                Point( 6f, 0f, "p1"), Point( 7f, 5f, "p1"),
                Point( 8f, 13f, "p2"), Point( 9f, 12f, "p3"),
                Point( 10f, 17f, "p4"), Point( 11f, 17f, "p5"),
                Point( 12f, 17f, "p1"), Point( 13f, 12f, "p1"),
                Point( 14f, 10f, "p2"), Point( 15f, 24f, "p3"),
                Point( 16f, 5f, "p4"), Point( 17f, 27f, "p5"),
                Point( 18f, 18f, "p5"), Point( 19f, 52f, "p5"),
                Point( 20f, 13f, "p5"), Point( 21f, 19f, "p5"),
                Point( 22f, 4f, "p5"), Point( 23f, 2f, "p5"),
            )
        )
    }



}
