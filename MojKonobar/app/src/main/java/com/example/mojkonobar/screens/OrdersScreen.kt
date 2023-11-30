package com.example.mojkonobar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.MainActivity
import com.example.mojkonobar.composables.TopBar
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

    val headingSize = 22.sp;
    val normalSize=17.sp;
    val letterSizePoeni=12.sp;

    Column {
        TopBar(modifier = Modifier, text = "My orders", backScreenNumber =  1)

        LazyColumn (modifier= modifier.fillMaxHeight(0.9f)) {
            itemsIndexed(items = orders) { index, order ->
                Card() {
                    Column() {
                        Row(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                top = 10.dp,
                                end = 4.dp,
                                bottom = 0.dp
                            ),
                        ) {
                            Column(modifier = modifier
                                .fillMaxWidth()) {
                                Row(
                                    modifier = modifier.fillMaxWidth()
                                ) {
                                    Row ()
                                    {
                                        Text(text = order.place.location,
                                            fontSize = headingSize,
                                            fontWeight = FontWeight.Bold)
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End
                                    )
                                    {
                                        Text(text = order.date.toString(),
                                            fontSize = headingSize,
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.End)
                                    }
                                }

                                order.items.forEach()
                                { item ->
                                    Column(modifier = modifier.padding(top = 4.dp)) {
                                        Row(
                                            // modifier = modifier.weight(0.45f)
                                        )
                                        {
                                            Spacer(modifier = modifier.width(25.dp))
                                            Text(
                                                text = item.name,
                                                fontSize = normalSize
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
    }
}