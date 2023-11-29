package com.example.mojkonobar.screens

import android.R
import android.content.Context
import android.content.res.loader.ResourcesLoader
import android.os.Build
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.posaplikacija.stateholders.MojKonobarViewModel


@Composable
fun HomeScreen(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier,
               context: Context)
{
    val uiState by viewModel.uiState.collectAsState()

    // val context = LocalContext.current

    LazyColumn {
        itemsIndexed(items = uiState.places) { index, place ->
            Card {
                Column {
                    Row(
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 8.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        ),
                    ) {
                        Column {
                            Button(onClick = { /*TODO*/ } ,
                                shape = RectangleShape,
                                colors = ButtonColors(Color.Transparent,Color.Black,Color.Gray,Color.Gray),
                                modifier = modifier
                                    .fillMaxSize()
                                    .height(160.dp)) {
                                Row {
                                    Column(modifier = modifier
                                        .fillMaxWidth(0.45f)) {

//                                        Image(
//                                            painter = painterResource(id = R.mipmap.richard),
//                                            contentDescription = "Image"
//                                        )

                                    }
                                        Column(modifier = modifier
                                            .fillMaxWidth()) {
                                            Row {
                                                Text(text = place.location, fontSize = 24.sp)
                                            }
                                            Spacer(modifier = Modifier.height(10.dp))
                                            Row {
                                                Text(text = place.description)
                                            }
                                            Row {
                                                //ProgressBar()
                                                //val simpleProgressBar = findViewById(com.example.mojkonobar.R.id.simpleProgressBar) as ProgressBar
                                                // var simpleProgressBar = ProgressBar(context).setProgress(50, false)
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
