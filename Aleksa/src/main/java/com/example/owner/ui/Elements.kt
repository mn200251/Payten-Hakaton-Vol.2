package com.example.owner.ui

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.owner.R
import com.example.owner.models.Category
import com.example.owner.models.Item
import com.example.owner.models.Order
import com.example.owner.models.OrderItem
import com.example.owner.models.Worker
import com.example.owner.ui.theme.LightBlue
import com.example.owner.ui.theme.LightGreen
import com.example.owner.ui.theme.OwnerTheme
import java.lang.reflect.ReflectPermission


@OptIn(ExperimentalCoilApi::class)
@Composable
fun ImageSelector(input: Uri?, onSelect: (Uri?) -> Unit, modifier: Modifier = Modifier) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        uri?.let {
            onSelect(it)
        }
    }

    Box(
        modifier = modifier
            .clickable {
                launcher.launch("image/*")
            },
        contentAlignment = Alignment.Center
    ) {
        if (input != null) {
            Image(
                painter = rememberImagePainter(data = input),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        } else {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun CategoryButton(
    category: Category,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val icons = Category.getCategoryIcons();
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onClick() }
    ) {
        Icon(painter = painterResource(id = icons[category.icon]!!), contentDescription = category.name, modifier = Modifier
            .size(75.dp)
            .fillMaxHeight()
            .padding(5.dp))
        Text(text = category.name, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun WorkerButton(worker: Worker, onViewStatistics: () -> Unit, modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
    ) {
        Image(painter = worker.getPainter(),
            contentDescription = worker.name,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .width(150.dp),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = worker.name + " " + worker.lastName, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Statistics",
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable { onViewStatistics() }
                )
            }
        }
    }
}

@Composable
fun ItemButton(item: Item, onEdit: () -> Unit, modifier: Modifier = Modifier) {
    var fullDescription: Boolean by rememberSaveable { mutableStateOf(false) }
    Row (
        modifier = modifier
    ) {
        Image(painter = item.getPainter(),
            contentDescription = item.description,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .height(150.dp),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.titleSmall)
            Text(text = if (fullDescription) item.description else shorten(item.description))
            Spacer(modifier = Modifier.height(10.dp))
            if (item.description.length > 70)
                Text(text = if (fullDescription) "Show less" else "Show more",
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable { fullDescription = !fullDescription }
                )
            Row {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Loyalty points")
                Text(text = "${item.loyaltyPoints} loyalty")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "$${item.price}")
                Spacer(modifier = Modifier.width(5.dp))
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    modifier = Modifier.clickable { onEdit() }
                )
            }
        }
    }
}

@Composable
fun CategoryIconsDropdown(
    selected: String,
    onSelect: (String) -> Unit
) {
    var expanded: Boolean by rememberSaveable { mutableStateOf(false) }
    val categories = Category.getCategoryIcons()
    Box {
        OutlinedButton(onClick = { expanded = !expanded }, shape = RectangleShape) {
            Icon(painter = painterResource(id = categories[selected]!!), contentDescription = selected, modifier = Modifier.size(50.dp))
            Spacer(Modifier.width(10.dp))
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Expand")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            for ((key, value) in categories) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(painter = painterResource(id = value), contentDescription = key, modifier = Modifier.size(50.dp))
                    },
                    text = {},
                    onClick = { onSelect(key); expanded = false })
            }
        }
    }

}

@Composable
fun LargeCenteredTextButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable { onClick() }
    ) {
        Text(text = text,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentHeight(align = Alignment.CenterVertically),
                //.clickable { onClick() },
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center)
    }

}

@Composable
fun OrderButton(order: Order, workerId: Int, onTake: () -> Unit, onDetails: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = if (order.workerId != workerId && order.workerId != null)
            modifier.background(color = Color.DarkGray)
            else modifier
    ) {
        Row {
            Text(text = order.table ?: "Takeout for\n'${order.username}'",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(10.dp),
                textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.weight(1f))
            OrderStatusBar(status = order.status, modifier = Modifier.padding(5.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.check), contentDescription = "Items served", modifier = Modifier.size(MaterialTheme.typography.bodyLarge.fontSize.value.dp))
            Spacer(Modifier.width(5.dp))
            Text("${order.itemsServed}/${order.totalItems}", style = MaterialTheme.typography.bodyMedium)
        }
        Row(modifier = Modifier.padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.clock), contentDescription = "Wait time", modifier = Modifier.size(MaterialTheme.typography.bodyLarge.fontSize.value.dp))
            Spacer(Modifier.width(5.dp))
            Text(order.waitTime, style = MaterialTheme.typography.bodyMedium)
        }
        if (order.status == Order.PENDING) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { onTake() }, shape = MaterialTheme.shapes.small, colors = ButtonDefaults.buttonColors(
                    containerColor = LightGreen
                )) {
                    Text(text = "Take order", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                }
            }
        } else if (order.workerId == workerId) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { onDetails() }, shape = MaterialTheme.shapes.small) {
                    Text("Details", style = MaterialTheme.typography.bodyLarge)
                }
            }
        } else {
            Text("Someone else is in charge of this order.", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun OrderItemElement(orderItem: OrderItem, onServe: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .padding(5.dp)
            .width(250.dp)) {
            Text(text = orderItem.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = R.drawable.clock), contentDescription = "Wait time", Modifier.size(MaterialTheme.typography.bodyLarge.fontSize.value.dp))
                Spacer(Modifier.size(10.dp))
                Text(orderItem.waitTime, style = MaterialTheme.typography.bodyMedium)
            }
            Text("Note: " + if (orderItem.note != null) orderItem.note else "None", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.weight(1f))
        val enabled = orderItem.served == false
        OutlinedButton(onClick = onServe, enabled = enabled, shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.inversePrimary, disabledContainerColor = Color.LightGray),
            modifier = Modifier.size(100.dp)) {
            //val text = if (enabled) "Serve" else "Served"
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Icon(imageVector = Icons.Default.Check, contentDescription = "Served")
            }
        }

    }
}