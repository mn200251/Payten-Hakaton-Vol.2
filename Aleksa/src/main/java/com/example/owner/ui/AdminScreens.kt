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
import com.example.owner.models.Worker
import com.example.owner.ui.theme.OwnerTheme
import java.lang.reflect.ReflectPermission


@Composable
fun AdminHomeScreen(
    onUpdatePlace: () -> Unit,
    onUpdateMenu: () -> Unit,
    onManageWorkers: () -> Unit,
    onGetQR: () -> Unit,
    onStatistics: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LargeCenteredTextButton(text = "Update Place Data", onClick = onUpdatePlace, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Update Menu", onClick = onUpdateMenu, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Manage Workers", onClick = onManageWorkers, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Get QR code", onClick = onGetQR, modifier = Modifier.weight(1f))
        LargeCenteredTextButton(text = "Statistics", onClick = onStatistics, modifier = Modifier.weight(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePlaceInfoScreen(curName: String, curLocation: String, curDesription: String, curImage: Uri, onUpdate: (String, String, String, Uri) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        var inputName: String by rememberSaveable { mutableStateOf(curName) }
        var inputLocation: String by rememberSaveable { mutableStateOf(curLocation) }
        var inputDescription: String by rememberSaveable { mutableStateOf(curDesription) }
        var inputImage: Uri? by rememberSaveable { mutableStateOf(curImage) }
        Text(text = "Name:")
        OutlinedTextField(value = inputName, onValueChange = { inputName = it })
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Location:")
        OutlinedTextField(value = inputLocation, onValueChange = { inputLocation = it })
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Description:")
        OutlinedTextField(value = inputDescription, onValueChange = { inputDescription = it })
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Image:")
        ImageSelector(input = inputImage, onSelect = { inputImage = it }, Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = {onUpdate(inputName, inputLocation, inputDescription, inputImage!!)}) {
            Text(text = "Update")
        }
    }
}

@Composable
fun UpdateMenuScreen(
    onAddCategory: () -> Unit,
    categories: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.clickable { onAddCategory() }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Category", modifier = Modifier
                    .size(75.dp)
                    .fillMaxHeight()
                    .padding(5.dp))
                Text(text = "Add category", style = MaterialTheme.typography.labelMedium)
            }
        }
        items(categories) {
            CategoryButton(category = it, onClick = { onClick(it) }, modifier = Modifier.fillMaxWidth())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryScreen(
    onAdd: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var inputName: String by rememberSaveable { mutableStateOf("") }
    var inputIcon: String by rememberSaveable {mutableStateOf("food")}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = "Name:")
        OutlinedTextField(value = inputName, onValueChange = {inputName = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Icon:")
        CategoryIconsDropdown(selected = inputIcon, onSelect = {inputIcon = it})
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = { onAdd(inputName, inputIcon)}) {
            Text("Add")
        }
    }
}

@Composable
fun ItemsScreen(
    onAddItem: () -> Unit,
    items: List<Item>,
    onEdit: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .clickable { onAddItem() }
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Item", modifier = Modifier
                    .padding(10.dp)
                    .size(75.dp))
                Text(text = "Add New Item", style = MaterialTheme.typography.labelMedium)
            }
        }
        items(items) {
            ItemButton(item = it, onEdit = {onEdit(it)}, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun UpdateItemScreen() {
    Text("TO DO -> Update Item Form")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(onClick: (String, String, Double, Uri?) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        var name: String by rememberSaveable { mutableStateOf("") }
        var description: String by rememberSaveable { mutableStateOf("") }
        var price: String by rememberSaveable { mutableStateOf("") }
        var uri: Uri? by rememberSaveable { mutableStateOf(null) }
        var message by rememberSaveable { mutableStateOf("") }
        Text(text = "Name:")
        OutlinedTextField(value = name, onValueChange = {name = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Description:")
        OutlinedTextField(value = description, onValueChange = {description = it}, modifier = Modifier.height(300.dp))
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Price:")
        OutlinedTextField(value = price, onValueChange = { price = it})
        if (message != "") Text(text = message, style = MaterialTheme.typography.bodySmall, color = Color.Red)
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Image:")
        ImageSelector(input = uri, onSelect = {uri = it}, modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = {
            val tmp = price.toDoubleOrNull()
            if (tmp == null) message = "Enter a valid floating point value!"
            else onClick(name, description, tmp, uri)
        }) {
            Text(text = "Add")
        }
    }
}

@Composable
fun ManageWorkersScreen(
    onAddWorker: () -> Unit,
    workers: List<Worker>,
    onViewStatistics: (Worker) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        item() {
            Row(
                modifier = Modifier
                    .clickable { onAddWorker() }
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Worker", modifier = Modifier
                    .padding(10.dp)
                    .size(75.dp))
                Text(text = "Add New Worker", style = MaterialTheme.typography.labelMedium)
            }
        }
        items(workers) {
            WorkerButton(worker = it, onViewStatistics = { onViewStatistics(it) }, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun WorkerStatisticsScreen() {
    Text("TO DO - Show tables/items served, money/tips earned, for selected period (past day, month or year)")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWorkerScreen(onClick: (String, String, String, Uri?) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        var id: String by rememberSaveable { mutableStateOf("") }
        var name: String by rememberSaveable { mutableStateOf("") }
        var lastName: String by rememberSaveable { mutableStateOf("") }
        var uri: Uri? by rememberSaveable { mutableStateOf(null) }

        Text(text = "ID:")
        OutlinedTextField(value = id, onValueChange = {id = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Name:")
        OutlinedTextField(value = name, onValueChange = {name = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Last name:")
        OutlinedTextField(value = lastName, onValueChange = {lastName = it})
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Image:")
        ImageSelector(input = uri, onSelect = {uri = it}, modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = {onClick(id, name, lastName, uri)}) {
            Text(text = "Add")
        }
    }
}


@Composable
fun StaticsScreen() {
    Text("TO DO -> STATISTICS")
}