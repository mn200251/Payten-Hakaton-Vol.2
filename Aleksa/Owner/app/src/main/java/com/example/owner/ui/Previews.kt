package com.example.owner.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.owner.models.Category
import com.example.owner.models.Item
import com.example.owner.models.Order
import com.example.owner.models.OrderItem
import com.example.owner.models.Worker
import com.example.owner.ui.theme.OwnerTheme


//@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    OwnerTheme {
        LoginScreen("Username", "Password", "Login", {val1, val2 -> })
    }
}

//@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    OwnerTheme {
        RegisterScreen(onClick = {inputName, inputLocation, inputDescription, inputImage, inputID, inputEmail, inputPassword -> },
            Modifier
                .fillMaxWidth()
                .padding(10.dp))
    }
}

//@Preview(showBackground = true)
@Composable
fun HomePreview() {
    OwnerTheme {
        HomeScreen(
            onLoginAdmin = { /*TODO*/ },
            onLoginWorker = { /*TODO*/ },
            onRegister = { /*TODO*/ },
            modifier = Modifier.fillMaxSize())
    }
}

//@Preview(showBackground = true)
@Composable
fun UpdateMenuScreenPreview() {
    OwnerTheme {
        UpdateMenuScreen(onAddCategory = { /*TODO*/ }, categories = listOf(Category(id = 0, icon =  "drink", name = "Drinks", placeId = 0), Category(id = 1, icon = "food", name = "Food", placeId = 0)), onClick = {}, modifier = Modifier.fillMaxSize())
    }
}

//@Preview(showBackground = true)
@Composable
fun AddCategoryScreenPreview() {
    OwnerTheme {
        AddCategoryScreen(onAdd = {name, icon -> }, modifier = Modifier.fillMaxSize())
    }
}

//@Preview(showBackground = true)
@Composable
fun ItemButtonPreview() {
    OwnerTheme {
        ItemButton(
            item = Item(
                id = 0,
                name = "Ceasar",
                categoryId = 0,
                description = "WOW what a delicious ceasar salad",
                image = 0,
                price = 100.0
            ), onEdit = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth())
    }
}

//@Preview(showBackground = true)
@Composable
fun WorkerButtonPreview() {
    OwnerTheme {
        WorkerButton(
            worker = Worker(
                id = 0,
                placeId = 0,
                name = "Worker",
                lastName = "Workeric",
                image = 0
            ), onViewStatistics = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth())
    }
}

//@Preview(showBackground = true)
@Composable
fun OrderButtonPreview1() {
    OwnerTheme {
        OrderButton(
            order = Order(
                id = 0,
                placeId = 0,
                itemsServed = 3,
                price = 0.0,
                table = "TABLE 1",
                workerId = 0
            ), workerId = 0, onTake = { /*TODO*/ }, onDetails = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .padding(10.dp))
    }
}

//@Preview(showBackground = true)
@Composable
fun OrderButtonPreview2() {
    OwnerTheme {
        OrderButton(
            order = Order(
                id = 0,
                placeId = 0,
                itemsServed = 3,
                price = 0.0,
                table = "TABLE 1",
                workerId = 0
            ), workerId = 0, onTake = { /*TODO*/ }, onDetails = { /*TODO*/ }, Modifier.fillMaxWidth())
    }
}
//@Preview(showBackground = true)
@Composable
fun OrderButtonPreview3() {
    OwnerTheme {
        OrderButton(
            order = Order(
                id = 0,
                placeId = 0,
                itemsServed = 3,
                price = 0.0,
                table = "TABLE 1",
                workerId = null
            ), workerId = 0, onTake = { /*TODO*/ }, onDetails = { /*TODO*/ }, Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun ItemElementPreview() {
    OwnerTheme {
        OrderItemElement(orderItem = OrderItem(
            id = 0,
            name = "Some item",
            note =  "No salt please",
            dateServed = getDate("2023-11-28 12:00:00"),
            dateOrdered = getDate("2023-11-28 11:54:10")
        ), onServe = { /*TODO*/ })
    }
}