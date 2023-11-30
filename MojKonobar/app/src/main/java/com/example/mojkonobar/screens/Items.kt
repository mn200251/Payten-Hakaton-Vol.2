package com.example.mojkonobar.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.R
import com.example.posaplikacija.stateholders.MojKonobarViewModel
@Composable
fun ItemsActivity(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier, context: Context) {
    // A surface container using the 'background' color from the theme
    val uiState by viewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ItemsScreen(onAddItem = {
            viewModel.changeScreen(4)
        //    intent = Intent(this, AddItemActivity::class.java)
        //    startActivity(intent)
        }, items = Item.getFakeItems().filter { it.categoryId == uiState.currCategory},
            onEdit = {
                     viewModel.changeScreen(4)
              //  intent = Intent(this, UpdateItemActivity::class.java)
              //  startActivity(intent)
              //  (this.applicationContext as App).item = it
            }, modifier = Modifier.fillMaxSize());

    }
    }


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemsScreen(
    onAddItem: () -> Unit,
    items: List<Item>,
    onEdit: (Item) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
//        item {
//            Row(
//                modifier = Modifier
//                    .clickable { onAddItem() }
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Add Item", modifier = Modifier
//                    .padding(10.dp)
//                    .size(75.dp))
//                Text(text = "Return", style = MaterialTheme.typography.labelLarge)
//            }

        items(items) {
            ItemButton(item = it, onEdit = {onEdit(it)}, modifier = Modifier.fillMaxWidth())
        }
    };

    
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
            Row {
                if (item.description.length > 70)
                    Text(text = if (fullDescription) "Show less" else "Show more",
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .clickable { fullDescription = !fullDescription }
                    )
                Icon(imageVector = Icons.Default.Star, contentDescription = "Loyalty points")
                Text(text = "${item.loyaltyPoints} loyalty")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "$${item.price}")
                Spacer(modifier = Modifier.width(5.dp))
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Edit",
                    modifier = Modifier.clickable { onEdit() }
                )
            }
            Row {



                Text(text = "Add note")
                Spacer(modifier = Modifier.width(5.dp))
                Icon(imageVector = Icons.Default.NoteAlt,
                    contentDescription = "Note",
                    modifier = Modifier.clickable { onEdit() }
                )
            }
        }
    }
}fun shorten(text: String): String {
    return if (text.length > 70) "${text.take(67)}..."
    else text
}
//class Item(
//    val id: Int = 0,
//    val categoryId: Int = 0,
//    val name: String = "",
//    val description: String = "",
//    val price: Double = 0.0,
//    val image: Int = 0,
//    val loyaltyPoints: Int = 0
//) {
//
//    companion object {
//        @Composable
//        public fun getFakeItems(): List<Item> {
//            return listOf(
//                Item(id = 0, categoryId = 0, name = "Margherita", description = "The classic cocktail.",
//                    price = 3.0, image = R.drawable.margherita, loyaltyPoints = 1),
//                Item(id = 1, categoryId = 0, name = "Mojito", description = "The traditional Cuban punch.",
//                    price = 3.5, image = R.drawable.mojito, loyaltyPoints = 2),
//                Item(id = 2, categoryId = 0, name = "Blue Lagoon", description = "Blue Curaçao mixed with vodka and lemonade.",
//                    price = 4.0, image = R.drawable.bluelagoon, loyaltyPoints = 3),
//                Item(id = 3, categoryId = 3, name = "Cheesecake", description = "Sweet dessert consisting of a mixture of cream cheese, sugar, and eggs baked on a crust made of crushed cookies.",
//                    price = 2.0, image = R.drawable.cheesecake, loyaltyPoints = 0),
//                Item(id = 4, categoryId = 3, name = "Sachertorte", description = "chocolate cake, or torte, of Austrian origin, invented by Franz Sacher.",
//                    price = 2.5, image = R.drawable.sacher, loyaltyPoints = 4),
//                Item(id = 5, categoryId = 3, name = "Apple Pie", description = "Pastry with an apple filling spiced with cinnamon, nutmeg, and lemon juice.",
//                    price = 3.0, image = R.drawable.applepie, loyaltyPoints = 0),
//                Item(id = 6, categoryId = 3, name = "Chocolate Muffin", description = "Rich and delicious Chocolate Muffins made with an intense chocolate batter and studded with chocolate chips throughout.",
//                    price = 1.5, image = R.drawable.muffin, loyaltyPoints = 2),
//                Item(id = 7, categoryId = 3, name = "Tiramisu", description = "An elegant and rich layered Italian dessert made with delicate ladyfinger cookies, espresso or instant espresso, mascarpone cheese, eggs, sugar, Marsala wine, rum and cocoa powder.",
//                    price = 2.2, image = R.drawable.tiramisu, loyaltyPoints = 3),
//                Item(id = 8, categoryId = 2, name = "Club Sandwich", description = "Ham, Cheese, Eggs, Salad, Fries and Toast.",
//                    price = 3.3, image = R.drawable.clubsandwich, loyaltyPoints = 5)
//            )
//        }
//    }
//
//    @Composable
//    public fun getPainter(): Painter {
//        return painterResource(id = image)
//    }
//
//}