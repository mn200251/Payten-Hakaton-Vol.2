package com.example.mojkonobar.screens

import android.content.Context
import android.content.Intent
import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.posaplikacija.stateholders.MojKonobarViewModel
import com.example.mojkonobar.composables.rememberCoffee
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.mojkonobar.R
import com.example.mojkonobar.composables.rememberFastfood
import com.example.mojkonobar.composables.rememberFoodBank
import com.example.mojkonobar.composables.rememberLocalPizza
import com.example.mojkonobar.ui.theme.ComplementaryRed
import com.example.posaplikacija.stateholders.places


@Composable
fun HomeScreen(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier,
               context: Context)
{
    val uiState by viewModel.uiState.collectAsState()


    val iconHashMap = HashMap<Int, ImageVector>()
    iconHashMap[0] = rememberFoodBank()
    iconHashMap[1] = rememberFastfood()
    iconHashMap[2] = rememberCoffee()
    iconHashMap[3] = rememberLocalPizza()
    iconHashMap[4] = rememberCoffee()

    val upperPaddingHashMap = HashMap<Int, Dp>()
    upperPaddingHashMap[0] = 4.dp
    upperPaddingHashMap[1] = 12.dp
    upperPaddingHashMap[2] = 0.dp
    upperPaddingHashMap[3] = 0.dp
    upperPaddingHashMap[4] = 0.dp
    // val context = LocalContext.current

    val letterSizeHeading=23.sp;
    val letterSizeOpis=13.sp;
    val letterSizePoeni=12.sp;
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {}
        LazyColumn(modifier = modifier.fillMaxHeight(0.9f)) {
            itemsIndexed(items = places) { index, place ->
                Card() {
                    Column() {
                        Row(
                            modifier = Modifier.padding(
                                start = 0.dp,
                                top = 4.dp,
                                end = 4.dp,
                                bottom = 0.dp
                            ),
                        ) {

                            Column {
                                Button(onClick = { if (index == 4) viewModel.changeScreen(4) },
                                    shape = RectangleShape,
                                    colors = ButtonColors(
                                        Color.Transparent,
                                        Color.Black,
                                        Color.Gray,
                                        Color.Gray
                                    ),// ButtonColors(MaterialTheme.colorScheme.secondary,MaterialTheme.colorScheme.tertiary,MaterialTheme.colorScheme.secondary,MaterialTheme.colorScheme.tertiary),
                                    modifier = modifier
                                        .fillMaxSize()
                                        .height(180.dp)
                                ) {

                                    Row {
                                        Column(
                                            modifier = modifier
                                                .fillMaxWidth(0.5f)
                                                .padding(end = 15.dp)
                                        ) {

                                            val imageModifier = Modifier
                                                .requiredHeight(220.dp)
                                                .requiredWidth(170.dp)
                                                //.size(150.dp)
                                                .background(Color.Transparent)

                                            Image(
                                                painter = painterResource(id = place.imageLink),
                                                contentDescription = null,
                                                modifier = imageModifier
                                            )

                                        }
                                        Column(
                                            modifier = modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row {
                                                Text(
                                                    text = place.location,
                                                    fontSize = letterSizeHeading
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(10.dp))
                                            Row() {
                                                Text(
                                                    text = place.description,
                                                    fontSize = letterSizeOpis
                                                )
                                            }
                                            Spacer(modifier = modifier.height(10.dp))
                                            Row {
                                                Column(
                                                    modifier = modifier.padding(
                                                        top = upperPaddingHashMap[index] ?: 0.dp
                                                    )
                                                ) {
                                                    Text(
                                                        text = "" + place.currLoyalityPoints + " / " + place.requiredLoyalityPoints + " ",
                                                        fontSize = letterSizePoeni,
                                                        modifier = Modifier.padding(
                                                            start = 0.dp,
                                                            top = 4.dp,
                                                            end = 0.dp,
                                                            bottom = 0.dp
                                                        ),
                                                    )
                                                }
                                                Column(
                                                    modifier = modifier.padding(
                                                        top = upperPaddingHashMap[index] ?: 0.dp
                                                    )
                                                ) {
                                                    //Spacer(modifier = modifier.height(upperPaddingHashMap[index] ?: 10.dp))
                                                    LinearProgressIndicator(
                                                        progress = {
                                                            (place.currLoyalityPoints.toFloat() / place.requiredLoyalityPoints.toFloat())
                                                        },
                                                        color = if (place.currLoyalityPoints.toFloat() == place.requiredLoyalityPoints.toFloat()) Color.Green else Color.Blue,
//                                                        if (place.currLoyalityPoints.toFloat() / place.requiredLoyalityPoints.toFloat() > 0.9f) Color.Green
//                                                        else if (place.currLoyalityPoints.toFloat() / place.requiredLoyalityPoints.toFloat() < 0.2f) Color.Red
//                                                        else if (place.currLoyalityPoints.toFloat() / place.requiredLoyalityPoints.toFloat() < 0.5f) Color.Yellow
//                                                        else Color.Blue,
                                                        trackColor = Color.Gray,
                                                        modifier = Modifier
                                                            .fillMaxWidth(0.7f)
                                                            .padding(
                                                                start = 0.dp,
                                                                top = 13.dp,
                                                                end = 0.dp,
                                                                bottom = 0.dp
                                                            ),
                                                        strokeCap = StrokeCap.Butt
                                                    )
                                                }
                                                Column() {
                                                    iconHashMap[index]?.let { Icon(it, "") }
                                                }

                                            }

//                                            Row()
//                                            {
//                                                Text(text = "Points: " + place.currLoyalityPoints + " out of " + place.requiredLoyalityPoints,
//                                                    fontSize = 14.sp)
//                                            }
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
        Spacer(modifier = modifier.height(60.dp))
    }
}
