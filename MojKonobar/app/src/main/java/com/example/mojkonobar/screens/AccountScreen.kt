package com.example.mojkonobar.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.R
import com.example.mojkonobar.composables.rememberCoffee
import com.example.mojkonobar.composables.rememberFastfood
import com.example.mojkonobar.composables.rememberFoodBank
import com.example.mojkonobar.composables.rememberLocalPizza
import com.example.posaplikacija.stateholders.MojKonobarViewModel
import com.example.posaplikacija.stateholders.places

@Composable
fun AccountScreen(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier,
               context: Context
)
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
    Column{
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(65.dp),
        verticalAlignment = Alignment.CenterVertically
    ){}
    LazyColumn (modifier= modifier.fillMaxHeight(0.9f)) {
        item {
            Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp, bottom = 10.dp)) {
                Text(text = "", modifier = Modifier.weight(0.3f))
                Image(
                    painter = painterResource(id = R.drawable.hakatonwiner),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredHeight(150.dp)
                        .requiredWidth(150.dp)
                        //.size(150.dp)
                        .background(Color.Transparent)
                        .weight(0.4f)
                )
                Text(text = "", modifier = Modifier.weight(0.3f))
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)) {
                Text(text = "", modifier = Modifier.weight(0.3f))
                Text(
                    text = "User Name", modifier = Modifier.weight(0.4f),
                    fontSize = 30.sp, textAlign = TextAlign.Center
                )
                Text(text = "", modifier = Modifier.weight(0.3f))
            }
        }
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

                        var rewards by remember {
                            mutableStateOf(1)
                        }
                        var activated by rememberSaveable {
                            mutableStateOf(0)
                        }
                        Column {
                            Button(
                                onClick = {
                                    if (rewards == 3 || rewards == 4) {
                                        if (place.location == "KST") {
                                            activated = 1
                                            rewards = 5
                                        } else {
                                            activated = 1
                                            rewards = 6
                                        }
                                    } else if (rewards == 1 && activated == 0)
                                        rewards = 2
                                    else if (activated == 0) rewards = 1
                                },
                                shape = RectangleShape,
                                colors = ButtonColors(
                                    Color.Transparent,
                                    Color.Black,
                                    Color.Gray,
                                    Color.Gray
                                ),// ButtonColors(MaterialTheme.colorScheme.secondary,MaterialTheme.colorScheme.tertiary,MaterialTheme.colorScheme.secondary,MaterialTheme.colorScheme.tertiary),
                                modifier = modifier
                                    .fillMaxSize()
                                    .height(100.dp)
                            ) {

                                if (rewards == 1) {
                                    Row {
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
                                                    Button(
                                                        onClick = {
                                                            when (place.location) {
                                                                "KST" -> {
                                                                    rewards = 3
                                                                    Toast.makeText(context, "Reward claimed", Toast.LENGTH_SHORT).show()
                                                                }
                                                                "Tramvaj " -> {
                                                                    rewards = 4
                                                                    Toast.makeText(context, "Reward claimed", Toast.LENGTH_SHORT).show()
                                                                }
                                                            }
                                                        }, shape = RoundedCornerShape(10),
                                                        modifier = Modifier
                                                            .width(70.dp)
                                                            .height(50.dp)
                                                            .padding(start = 20.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.gitf),
                                                            contentDescription = null,
                                                            modifier = Modifier
                                                                .requiredHeight(50.dp)
                                                                .requiredWidth(50.dp)
                                                                //.size(150.dp)
                                                                .background(Color.Transparent)
                                                        )

                                                    }
                                                }

                                            }
                                        }
                                    }
                                } else if (rewards == 2) {
                                    Row {
                                        when (place.location) {
                                            "Richard Gyros" -> Text(text = "Receive free gyros, coca-cola, pepsi and much more :)")
                                            "Poncho" -> Text(text = "Receive free pica, coca-cola, burger,...")
                                            "KST" -> Text(text = "Get free tickets for best parties")
                                            "Bucko" -> Text(text = "Try your luck for free pica or drink")
                                            "Tramvaj " -> Text(text = "Come and get a free bier")
                                        }
                                    }
                                } else if (rewards == 3) {
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.ticket),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .requiredHeight(50.dp)
                                                .requiredWidth(50.dp)
                                                //.size(150.dp)
                                                .background(Color.Transparent)
                                        )
                                    }
                                } else if (rewards == 4) {
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.cocacola),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .requiredHeight(50.dp)
                                                .requiredWidth(50.dp)
                                                //.size(150.dp)
                                                .background(Color.Transparent)
                                        )
                                    }
                                } else if (rewards == 5) {
                                    // KST
                                    Row {
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
                                            Row {
                                                Column(
                                                    modifier = modifier.padding(
                                                        top = upperPaddingHashMap[index] ?: 0.dp
                                                    )
                                                ) {
                                                    Text(
                                                        text = "" + 0 + " / " + place.requiredLoyalityPoints + " ",
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
                                                            0f
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
                                                    Button(
                                                        onClick = {
                                                        }, shape = RoundedCornerShape(10),
                                                        modifier = Modifier
                                                            .width(70.dp)
                                                            .height(50.dp)
                                                            .padding(start = 20.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.gitf),
                                                            contentDescription = null,
                                                            modifier = Modifier
                                                                .requiredHeight(50.dp)
                                                                .requiredWidth(50.dp)
                                                                //.size(150.dp)
                                                                .background(Color.Transparent)
                                                        )

                                                    }
                                                }

                                            }
                                        }
                                    }

                                } else if (rewards == 6) {
                                    // TRAMVAJ
                                    Row {
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
                                            Row {
                                                Column(
                                                    modifier = modifier.padding(
                                                        top = upperPaddingHashMap[index] ?: 0.dp
                                                    )
                                                ) {
                                                    Text(
                                                        text = "" + 0 + " / " + place.requiredLoyalityPoints + " ",
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
                                                            0f
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
                                                    Button(
                                                        onClick = {
                                                        }, shape = RoundedCornerShape(10),
                                                        modifier = Modifier
                                                            .width(70.dp)
                                                            .height(50.dp)
                                                            .padding(start = 20.dp)
                                                    ) {
                                                        Image(
                                                            painter = painterResource(id = R.drawable.gitf),
                                                            contentDescription = null,
                                                            modifier = Modifier
                                                                .requiredHeight(50.dp)
                                                                .requiredWidth(50.dp)
                                                                //.size(150.dp)
                                                                .background(Color.Transparent)
                                                        )

                                                    }
                                                }

                                            }
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
    Spacer(modifier = modifier.height(60.dp))}
}
