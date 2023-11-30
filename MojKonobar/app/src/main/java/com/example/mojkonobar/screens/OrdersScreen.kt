package com.example.mojkonobar.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.MainActivity
import com.example.mojkonobar.classes.Order
import com.example.mojkonobar.composables.TopBar
import com.example.mojkonobar.ui.theme.RedOrange
import com.example.posaplikacija.stateholders.MojKonobarViewModel
import com.example.posaplikacija.stateholders.orders
import com.example.posaplikacija.stateholders.places


@Composable
fun OrderScreen(
    viewModel: MojKonobarViewModel = viewModel(),
    modifier: Modifier = Modifier,
    mainActivity: MainActivity
)
{
    val uiState by viewModel.uiState.collectAsState()

    val headingSize = 24.sp
    val normalSize = 17.sp
    val totalPriceSize = 20.sp

    Column {
        TopBar(modifier = Modifier, text = "My orders", 1)

        LazyColumn (modifier= modifier.fillMaxHeight(0.9f)) {
            itemsIndexed(items = orders) { index, order ->
                Card() {
                    Column() {
                        Row(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                top = 12.dp,
                                end = 12.dp,
                                bottom = 10.dp
                            ),
                        ) {
                            Column(modifier = modifier
                                .fillMaxWidth()) {

                                Row{

                                    Column(modifier = modifier.weight(0.5f)) {
                                        Row ()
                                        {
                                            Text(text = order.place.location,
                                                fontSize = headingSize,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Start)
                                        }
                                    }

                                    Column {
                                        Text(text = order.date.toString(),
                                            fontSize = headingSize,
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.End,
                                            modifier = Modifier.wrapContentWidth(Alignment.End)
                                        )
                                    }
                                }

                                order.items.forEach()
                                { item ->
                                    Column(modifier = modifier.padding(top = 4.dp)) {
                                        Spacer(modifier = modifier.width(25.dp))
                                        Row()
                                        {
                                            Column(modifier = modifier.weight(0.5f)) {
                                                Text(
                                                    text = item.name,
                                                    fontSize = normalSize
                                                )
                                            }
                                            Column {
                                                Text(
                                                    text = "$${item.price.toString()}",
                                                    fontSize = normalSize,
                                                    textAlign = TextAlign.End,
                                                    modifier = Modifier.wrapContentWidth(Alignment.End)
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = modifier.height(25.dp))

                                Row()
                                {
                                    Column(modifier = modifier.weight(0.5f)) {

                                    }

                                    Column {
                                        Text(text = "Tip: $${order.tip ?: 0.0}",
                                            fontSize = normalSize,
                                            textAlign = TextAlign.End,
                                            modifier = Modifier.wrapContentWidth(Alignment.End)
                                        )
                                    }
                                }

                                Row()
                                {
                                    Column(modifier = modifier.weight(0.5f)) {
//                                        OutlinedCard (
//                                            modifier = modifier.padding(4.dp),
//                                            shape = RoundedCornerShape(8.dp),
//                                            // border = BorderStroke(2.dp, RedOrange)
//                                        ) {
                                            Text(text = if (order.status == Order.WAITING) "WAITING"
                                                            else "FINISHED",
                                                fontSize = headingSize,
                                                fontStyle = FontStyle.Normal,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Start,
                                                modifier = Modifier
                                                    .wrapContentWidth(Alignment.Start),
                                                    // .background(Color.Gray),
                                                    // .border(1.dp, Color.Black, RoundedCornerShape(8f)),
                                                color = if (order.status == Order.WAITING) Color(224, 193, 36)
                                                        else Color(15, 128, 0),
                                            )
//                                        }
                                    }
                                    Column {
                                        Text(text = "Total: $${order.price + (order.tip ?: 0.0)}",
                                            fontSize = headingSize,
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.End,
                                            modifier = Modifier.wrapContentWidth(Alignment.End)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                HorizontalDivider(
                    modifier = modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }

        }
    }
}