package com.example.mojkonobar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopBar(modifier: Modifier, text: String, backScreenNumber: Int)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(232, 78, 54), RectangleShape)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
            ) {
                Row {
                    Spacer(modifier = modifier.width(4.dp))
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Sharp.ArrowBackIosNew,
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = modifier.background(Color.Transparent)
                        )
                    }
                    Spacer(modifier = modifier.width(15.dp))

                    Column {
                        Spacer(modifier = modifier.height(10.dp))
                        Text(text = text, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
                    }

                }

            }
        }
        Spacer(modifier = modifier.height(20.dp))

    }
}