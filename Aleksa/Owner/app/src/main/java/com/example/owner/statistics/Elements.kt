package com.example.owner.statistics

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.extensions.formatToSinglePrecision
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.components.Legends
import co.yml.charts.common.extensions.formatToSinglePrecision
import co.yml.charts.common.model.AccessibilityConfig
import co.yml.charts.common.model.LegendLabel
import co.yml.charts.common.model.LegendsConfig
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.GroupBar
import co.yml.charts.ui.combinedchart.CombinedChart
import co.yml.charts.ui.combinedchart.model.CombinedChartData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import co.yml.charts.ui.piechart.utils.proportion
import kotlin.random.Random


@Composable
fun Spinner(
    value: String,
    onSelect: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize()
                .height(40.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { isExpanded = !isExpanded },
        ) {
            Text(text = value)
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
        }

        // https://m2.material.io/components/menus/android
        // https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            offset = DpOffset(0.dp, (-32).dp),
            modifier = Modifier.wrapContentSize(),
            content = {
                options.forEach {
                    DropdownMenuItem(
                        onClick = {
                            onSelect(it)
                            isExpanded = false
                        },
                        text = { Text(text = it, style = MaterialTheme.typography.labelMedium) }
                    )
                }
            }
        )}
}

@Composable
fun SingleLineChartWithGridLines(pointsData: List<Point>, columnHeader1: String,
    columnHeader2: String, spinerName: String, onSelect: (String) -> Unit, options: List<String>) {
    val steps = 15
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .topPadding(105.dp)
        .steps(pointsData.size - 1)
        .labelData { i -> /*pointsData[i].x.toInt().toString()*/ "  " + i.toString() }
        .labelAndAxisLinePadding(10.dp)
        .build()
    val yAxisData = AxisData.Builder()
        .steps(steps)
        .labelAndAxisLinePadding(30.dp)
        .labelData { i ->
            // Add yMin to get the negative axis values to the scale
            val yMin = pointsData.minOf { it.y }
            val yMax = pointsData.maxOf { it.y }
            val yScale = (yMax - yMin) / steps
            ((i * yScale) + yMin * 0f).formatToSinglePrecision()
            //pointsData[i].y.formatToSinglePrecision()
        }.build()
    val data = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        lineType = LineType.SmoothCurve(isDotted = true)
                    ),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )
    LazyColumn{
        item {
            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                lineChartData = data
            )
        }
        item {
            Spinner(spinerName, onSelect, options)
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = columnHeader1,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                        .fillMaxSize()
                )
                Text(
                    text = columnHeader2,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                        .fillMaxSize()
                )
            }
        }
        items(pointsData) {it ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = it.x.toString(),
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                )
                Text(
                    text = it.y.toString(),
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                )
            }
        }
    }
}


@Composable
fun PiechartWithSliceLables(context: Context, pointsData: List<Point>, columnHeader1: String,
    columnHeader2: String, spinerName: String, onSelect: (String) -> Unit, options: List<String>) {
    // val pieChartData = DataUtils.getPieChartData2()

    var item1 by rememberSaveable { mutableStateOf("Cheesecake") }
    var item2 by rememberSaveable { mutableStateOf("Sachertorte") }
    var item3 by rememberSaveable { mutableStateOf("Apple Pie") }
    var item4 by rememberSaveable { mutableStateOf("Chocolate Muffin") }

    var val1 by rememberSaveable { mutableStateOf(65f) }
    var val2 by rememberSaveable { mutableStateOf(35f) }
    var val3 by rememberSaveable { mutableStateOf(10f) }
    var val4 by rememberSaveable { mutableStateOf(40f) }

    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice(item1, val1, Color(0xFF012B5B)),
            PieChartData.Slice(item2, val2, Color(0xFF2B4965)),
            PieChartData.Slice(item3, val3, Color(0xFF246C84)),
            PieChartData.Slice(item4, val4, Color(0xFF8D7B91))
        ),
        plotType = PlotType.Pie
    )

    val pieChartConfig = PieChartConfig(
        activeSliceAlpha = .9f,
        isEllipsizeEnabled = true,
        sliceLabelEllipsizeAt = TextUtils.TruncateAt.MIDDLE,
        sliceLabelTypeface = Typeface.defaultFromStyle(Typeface.ITALIC),
        isAnimationEnable = true,
        chartPadding = 20,
        showSliceLabels = true,
        labelVisible = true
    )

    LazyColumn{
        item {
            Column(modifier = Modifier.height(500.dp)) {
                Legends(legendsConfig = DataUtils.getLegendsConfigFromPieChartData(pieChartData, 3))
                PieChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    pieChartData,
                    pieChartConfig
                ) { slice ->
                    Toast.makeText(context, slice.label, Toast.LENGTH_SHORT).show()
                }
            }
        }
        item {
            Spinner(spinerName, {when(it) {
                "morning" -> {
                    item1 = "Cheesecake"; item2 = "Sachertorte"; item3 = "Apple Pie"; item4 = "Chocolate Muffin";
                    val1 = 65f; val2 = 35f; val3 = 10f; val4 = 40f;
                }
                "noon" -> {
                    item1 = "Sachertorte"; item2 = "Cheesecake"; item3 = "Apple pie"; item4 = "Chocolate Muffin";
                    val1 = 75f; val2 = 25f; val3 = 30f; val4 = 20f;

                }
                "evening" -> {
                    item1 = "Cheesecake"; item2 = "Sachertorte"; item3 = "Chocolate Muffin"; item4 = "Apple pie";
                    val1 = 85f; val2 = 15f; val3 = 5f; val4 = 45f;

                }
            } }, listOf<String>("morning", "noon", "evening"))
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = columnHeader1,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                        .fillMaxSize()
                )
                Text(
                    text = columnHeader2,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                        .fillMaxSize()
                )
            }
        }
        item { Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = item1,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f))
                Text(text = val1.toString(),
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f))
        }}
        item { Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = item2,
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f))
            Text(text = val2.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f))
        }}
        item { Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = item3,
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f))
            Text(text = val3.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f))
        }}
        item { Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = item4,
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f))
            Text(text = val4.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f))
        }}
    }


}

fun getGroupBarCharData(pointsData: List<Point>, barSize: Int): List<GroupBar> {
    val list = mutableListOf<GroupBar>()
    for (index in 1 until pointsData.size) {
        val barList = mutableListOf<BarData>()
        for (i in 0 until barSize) {
            barList.add(
                BarData(
                    pointsData[index],
                    label = "B$i",
                    description = "Bar at $index with label B$i has value ${
                        String.format(
                            "%.2f", pointsData[index].y
                        )
                    }"
                )
            )
        }
        list.add(GroupBar(index.toString(), barList))
    }
    return list
}

@Composable
fun BarWithLineChartAndBackground(pointsData: List<Point>, columnHeader1: String,
    columnHeader2: String, spinerName: String, onSelect: (String) -> Unit, options: List<String>) {
    val maxRange = 25
    val groupBarData = getGroupBarCharData(pointsData, 1)
    val yStepSize = 10
    val xAxisData = AxisData.Builder()
        .backgroundColor(Color.White)
        .labelData { index -> index.toString() }
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .backgroundColor(Color.White)
        .labelAndAxisLinePadding(30.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()
    val linePlotData = LinePlotData(
        lines = listOf(
            Line(
                dataPoints = pointsData,
                lineStyle = LineStyle(color = Color.Blue),
            ),
        )
    )
    val colorPaletteList = listOf<Color>(Color(0xFF012B5B))
    val barPlotData = BarPlotData(
        groupBarList = groupBarData,
        barStyle = BarStyle(barWidth = 20.dp),
        barColorPaletteList = colorPaletteList
    )
    val combinedChartData = CombinedChartData(
        combinedPlotDataList = listOf(barPlotData, linePlotData),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        backgroundColor = Color.White
    )
    LazyColumn{
        item {
            CombinedChart(
                modifier = Modifier.height(300.dp),
                combinedChartData = combinedChartData
            )
        }
        item {
            Spinner(spinerName, onSelect, options)
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = columnHeader1,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                        .fillMaxSize()
                )
                Text(
                    text = columnHeader2,
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                        .fillMaxSize()
                )
            }
        }
        items(pointsData) {it ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = it.x.toString(),
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                )
                Text(
                    text = it.y.toString(),
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                )
            }
        }
    }
}

@Composable
fun SimpleDonutChart() {

    var val1 by rememberSaveable { mutableStateOf(15f) }
    var val2 by rememberSaveable { mutableStateOf(30f) }
    var val3 by rememberSaveable { mutableStateOf(10f) }
    var val4 by rememberSaveable { mutableStateOf(15f) }
    var val5 by rememberSaveable { mutableStateOf(10f) }
    var val6 by rememberSaveable { mutableStateOf(30f) }

    val data = PieChartData(
        slices = listOf(
            PieChartData.Slice("Mark Anderson", val1, Color(0xFF5F0A87)),
            PieChartData.Slice("Peter Jones", val2, Color(0xFF20BF55)),
            PieChartData.Slice("Maya Williams", val3, Color(0xFFA40606)),
            PieChartData.Slice("Tanya Ivannovich", val4, Color(0xFFF53844)),
            PieChartData.Slice("John Smith", val5, Color(0xFFEC9F05)),
            PieChartData.Slice("Eric Ferguson", val6, Color(0xFF009FFD)),
        ),
        plotType = PlotType.Donut
    )
    val sumOfValues = data.totalLength

    // Calculate each proportion value
    val proportions = data.slices.proportion(sumOfValues)
    val pieChartConfig =
        PieChartConfig(
            labelVisible = true,
            strokeWidth = 120f,
            labelColor = Color.Black,
            activeSliceAlpha = .9f,
            isEllipsizeEnabled = true,
            labelTypeface = Typeface.defaultFromStyle(Typeface.BOLD),
            isAnimationEnable = true,
            chartPadding = 25,
            labelFontSize = 42.sp,
        )



    LazyColumn{
        item {
            Column(modifier = Modifier.fillMaxWidth().height(500.dp) ) {
                Legends(legendsConfig = DataUtils.getLegendsConfigFromPieChartData(pieChartData = data, 3))
                DonutPieChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    data,
                    pieChartConfig
                )
            }
        }
        item {
            Spinner("Time Of Day", {when(it) {
                "morning" -> {
                    val1= 15f; val2 = 30f; val3 = 10f;
                    val4 = 15f; val5 = 10f; val6 = 30f;
                }
                "noon" -> {
                    val1= 45f; val2 = 30f; val3 = 25f;
                    val4 = 5f; val5 = 5f; val6 = 10f;
                }
                "evening" -> {
                    val1= 5f; val2 = 0f; val3 = 55f;
                    val4 = 5f; val5 = 10f; val6 = 40f;
                }
            } }, listOf<String>("morning", "noon", "evening"))
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "WAITER",
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.3f)
                        .fillMaxSize()
                )
                Text(
                    text = "ORDERS HANDLED",
                    Modifier
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                        .weight(0.7f)
                        .fillMaxSize()
                )
            }
        }
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "Mark Anderson",
                Modifier.border(1.dp, Color.Black).padding(8.dp).weight(0.3f).fillMaxHeight())
            Text(text = val1.toString(),
                Modifier.border(1.dp, Color.Black).padding(8.dp).weight(0.7f).fillMaxHeight())
        }}
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "Peter Jones",
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f)
                    .fillMaxHeight())
            Text(text = val2.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f)
                    .fillMaxHeight())
        }}
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "Maya Williams",
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f)
                    .fillMaxHeight())
            Text(text = val3.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f)
                    .fillMaxHeight())
        }}
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "Tanya Ivannovich",
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f)
                    .fillMaxHeight())
            Text(text = val4.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f)
                    .fillMaxHeight())
        }}
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "John Smith",
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f)
                    .fillMaxHeight())
            Text(text = val5.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f)
                    .fillMaxHeight())
        }}
        item { Row(modifier = Modifier.fillMaxWidth().height(70.dp)) {
            Text(text = "Eric Ferguson",
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.3f)
                    .fillMaxHeight())
            Text(text = val6.toString(),
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
                    .weight(0.7f)
                    .fillMaxHeight())
        }}
    }

}