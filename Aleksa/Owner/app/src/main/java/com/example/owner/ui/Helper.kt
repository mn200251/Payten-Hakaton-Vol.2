package com.example.owner.ui

import java.security.MessageDigest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.owner.models.Order
import com.example.owner.ui.theme.LightBlue
import com.example.owner.ui.theme.LightGreen
import com.example.owner.ui.theme.Red
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.graphics.Bitmap
import android.util.Base64
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.io.ByteArrayOutputStream

fun generateQRBitmap(text: String, width: Int = 400, height: Int = 400): Bitmap {
    val bitMatrix: BitMatrix = MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height)
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
        }
    }

    return bitmap
}

fun bitmapToBase64(bitmap: Bitmap): String {
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
    val byteArray = outputStream.toByteArray()

    return Base64.encodeToString(byteArray, Base64.DEFAULT)
}


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
        Text(text = text, style = MaterialTheme.typography.labelMedium,  modifier = Modifier
            .background(color = color)
            .padding(10.dp))
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
fun getPaytenRequest(req: String): String {
    val length = req.toByteArray().size
    val sha = shaEncode(req)
    return "{\"header\":{\"length\":${length},\"hash\":\"" + sha + "\",\"version\":\"1\"}," + req
}
fun getPaytenSaleRequestJson(base: Double, tip: Double): String {
    //var req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"ecr\":\"${ecr++}\"},\"amounts\":{\"base\":%s,\"tip\":%s,\"total\":%s,\"currencyCode\":\"RSD\"},\"options\":{\"print\":false}}}"
    var req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"cashier\":\"worker0\"},\"amounts\":{\"base\":%s,\"tip\":%s,\"currencyCode\":\"RSD\"},\"options\":{\"print\":true}}}"
    req = String.format(req, nozero(base), nozero(tip)) + "}"

    //req = "\"request\":{\"financial\":{\"transaction\":\"sale\",\"id\":{\"ecr\":\"${ecr++}\"},\"amounts\":{\"base\":1.6,\"tip\":2.4,\"total\":10,\"currencyCode\":\"RSD\"},\"options\":{\"print\":false}}}}"
    /*
    val length = req.toByteArray().size
    val sha = shaEncode(req)

    return "{\"header\":{\"length\":${length},\"hash\":\"" + sha + "\",\"version\":\"01\"}," + req*/
    return getPaytenRequest(req)
}
fun getPaytenPrintRequestJson(data: String): String {
    var req = "\"request\":{\"command\":{\"printer\":{\"type\":\"QR\",\"data\":\"%s\"}}}"
    req = String.format(req, data) + "}"
    return getPaytenRequest(req)
}

fun getNow(): LocalDateTime {
    return getDate("2023-11-28 12:15:00")
}

@Composable
fun SimpleDropdown(labels: List<String>, values: List<Int>, selectedValue: Int, selectedLabel: String, onSelect: (Int, String) -> Unit, modifier:Modifier = Modifier) {
    var expanded: Boolean by rememberSaveable { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(onClick = { expanded = !expanded }, shape = MaterialTheme.shapes.small) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(selectedLabel, style = MaterialTheme.typography.labelMedium)
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Select")
            }
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false}) {
            val label = labels.iterator()
            val value = values.iterator()
            while (label.hasNext()) {
                val curlabel = label.next()
                val curvalue = value.next()
                DropdownMenuItem(
                    text = { Text(curlabel, style = MaterialTheme.typography.labelMedium) },
                    onClick = { expanded = false; onSelect(curvalue, curlabel) })
            }
        }
    }
}