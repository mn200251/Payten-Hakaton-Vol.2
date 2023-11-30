package com.example.owner.ui

import java.security.MessageDigest

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.owner.R
import com.example.owner.models.Category
import com.example.owner.models.Item
import com.example.owner.models.Order
import com.example.owner.models.Worker
import com.example.owner.ui.theme.LightBlue
import com.example.owner.ui.theme.LightGreen
import com.example.owner.ui.theme.OwnerTheme
import com.example.owner.ui.theme.Red
import java.lang.reflect.ReflectPermission
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun shorten(text: String): String {
    return if (text.length > 70) "${text.take(67)}..."
    else text
}

fun getDate(date: String): LocalDateTime {
    return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}

@Composable
fun OrderStatusBar(status: Int, modifier: Modifier = Modifier) {
    var text = ""
    var color = Color.LightGray
    when(status) {
        Order.PENDING -> { text = "Pending"; color = LightGreen }
        Order.WAITING -> { text = "Waiting"; color = Red }
        Order.IDLE -> { text = "Idle";}
        Order.PAYMENT -> { text = "Payment"; color = LightBlue }
        Order.DONE -> { text = "Done"; }
    }
    OutlinedCard(shape = MaterialTheme.shapes.medium, modifier = modifier.background(color = color, shape = MaterialTheme.shapes.medium)) {
        Text(text = text, style = MaterialTheme.typography.labelMedium,  modifier = Modifier.background(color = color).padding(10.dp))
    }

}

fun shaEncode(input: String): String {
    // Create a SHA-512 MessageDigest instance
    val digest = MessageDigest.getInstance("SHA-512")

    // Update the digest with the input bytes
    val hashBytes = digest.digest(input.toByteArray(Charsets.UTF_8))

    // Convert the byte array to a hexadecimal string
    val hexString = hashBytes.joinToString("") { "%02x".format(it) }

    return hexString
}
fun toRSD(usd: Double): Double {
    return usd * 106.86
}
private fun nozero(t: Double): String {
    var res: String = t.toString()
    while (res.length > 0 && res.last() == '0') res = res.substring(0, res.length - 1)
    if (res.last() == '.') res = res.substring(0, res.length - 1)
    return res
}
var ecr: Long = System.currentTimeMillis() % 1000000
fun getPaytenRequestJson(base: Double, tip: Double): String {
    //var req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"ecr\":\"${ecr++}\"},\"amounts\":{\"base\":%s,\"tip\":%s,\"total\":%s,\"currencyCode\":\"RSD\"},\"options\":{\"print\":false}}}"
    var req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"ecr\":\"${ecr++}\"},\"amounts\":{\"base\":%s,\"tip\":%s,\"currencyCode\":\"RSD\"},\"options\":{\"print\":false}}}"
    req = String.format(req, nozero(base), nozero(tip)) + "}"

    //req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"ecr\":\"${ecr++}\"},\"amounts\":{\"base\":1.6,\"tip\":2.4,\"total\":10,\"currencyCode\":\"RSD\"},\"options\":{\"print\":false}}}}"
    val length = req.toByteArray().size
    val sha = shaEncode(req)

    return "{\"header\":{\"length\":${length},\"hash\":\"" + sha + "\",\"version\":\"01\"}," + req
}

fun getNow(): LocalDateTime {
    return getDate("2023-11-28 12:15:00")
}