package com.example.mojkonobar.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.R
import com.example.posaplikacija.stateholders.MojKonobarViewModel
import com.example.posaplikacija.stateholders.places

class MenuScreen {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(viewModel: MojKonobarViewModel = viewModel(), modifier: Modifier = Modifier, context: Context) {

    val uiState by viewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        /*
        TO DO: Retrieve categories for current place from database.

         */





        UpdateMenuScreen(
            onAddCategory = {
//            intent = Intent(this, AddCategoryActivity::class.java)
//            startActivity(intent)
            },
            categories = Category.getFakeCategories(),
            onClick = {
//                intent = Intent(this, ItemsActivity::class.java)
//               startActivity(intent)
                //          (this.applicationContext as App).category = it
                viewModel.changeCategory(it.id)
                if(it.id==4){viewModel.changeScreen(6)}else{
                    viewModel.changeCategory(it.id)
                viewModel.changeScreen(5)}
            }, modifier = Modifier.fillMaxHeight()
        )
    }}



@Composable
fun UpdateMenuScreen(
    onAddCategory: () -> Unit,
    categories: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {

    Row(modifier = Modifier.weight(0.9f)){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {val imageModifier = Modifier
        .fillMaxWidth()

        //.size(150.dp)
        .background(Color.Transparent)

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.clickable { onAddCategory() }.fillMaxWidth().padding(horizontal =20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Row(){
                        Text(text = places[4].location,fontSize = 26.sp )}
                Row {


                Image(
                    painter = painterResource(id = places[4].imageLink),
                    contentDescription = null,
                    modifier = imageModifier
                )}
                    Row(){
                        Text(text = places[4].description,fontSize = 14.sp )}

                //Text(text = "Richard", style = MaterialTheme.typography.labelLarge)
            }}
        }
        items(categories) {
            CategoryButton(category = it, onClick = { onClick(it) }, modifier = Modifier.fillMaxWidth().padding(horizontal =20.dp))
        }
    }};
    Row(modifier = Modifier.weight(0.1f)){ Button(onClick = { /*TODO*/ }) {
        Text(text = "Order")}}
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
            .size(65.dp)
            .fillMaxHeight()
            .padding(5.dp))
        Text(text = category.name, fontSize = 22.sp)
    }
}

class Category(
    val id: Int = 0,
    val placeId: Int = 0,
    val name: String = "",
    val icon: String = ""
) {

    companion object {
        @Composable
        public fun getCategoryIcons(): Map<String, Int> {
            return mapOf("drink" to R.drawable.drink, "food" to R.drawable.food,
                "softdrink" to R.drawable.softdrink, "dessert" to R.drawable.dessert,"check" to R.drawable.check)
        }

        @Composable
        public fun getFakeCategories(): List<Category> {
            return listOf(
                Category(id = 0, placeId = 0, name = "Drinks", icon = "drink"),
                Category(id = 1, placeId = 0, name = "Soft Drinks", icon = "softdrink"),
                Category(id = 2, placeId = 0, name = "Food", icon = "food"),
                Category(id = 3, placeId = 0, name = "Dessert", icon = "dessert"),
                Category(id = 4, placeId = 0, name = "Order", icon = "check"),

                )
        }
    }
}

class Item(
    val id: Int = 0,
    val categoryId: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val image: Int = 0,
    val loyaltyPoints: Int = 0
) {

    companion object {
        @Composable
        public fun getFakeItems(): List<Item> {
            return listOf(
                Item(id = 0, categoryId = 0, name = "Margherita", description = "The classic cocktail.",
                    price = 3.0, image = R.drawable.margherita, loyaltyPoints = 1),
                Item(id = 1, categoryId = 0, name = "Mojito", description = "The traditional Cuban punch.",
                    price = 3.5, image = R.drawable.mojito, loyaltyPoints = 2),
                Item(id = 2, categoryId = 0, name = "Blue Lagoon", description = "Blue Curaçao mixed with vodka and lemonade.",
                    price = 4.0, image = R.drawable.bluelagoon, loyaltyPoints = 3),
                Item(id = 3, categoryId = 3, name = "Cheesecake", description = "Sweet dessert consisting of a mixture of cream cheese, sugar, and eggs baked on a crust made of crushed cookies.",
                    price = 2.0, image = R.drawable.cheesecake, loyaltyPoints = 0),
                Item(id = 4, categoryId = 3, name = "Sachertorte", description = "chocolate cake, or torte, of Austrian origin, invented by Franz Sacher.",
                    price = 2.5, image = R.drawable.sacher, loyaltyPoints = 4),
                Item(id = 5, categoryId = 3, name = "Apple Pie", description = "Pastry with an apple filling spiced with cinnamon, nutmeg, and lemon juice.",
                    price = 3.0, image = R.drawable.applepie, loyaltyPoints = 0),
                Item(id = 6, categoryId = 3, name = "Chocolate Muffin", description = "Rich and delicious Chocolate Muffins made with an intense chocolate batter and studded with chocolate chips throughout.",
                    price = 1.5, image = R.drawable.muffin, loyaltyPoints = 2),
                Item(id = 7, categoryId = 3, name = "Tiramisu", description = "An elegant and rich layered Italian dessert made with delicate ladyfinger cookies, espresso or instant espresso, mascarpone cheese, eggs, sugar, Marsala wine, rum and cocoa powder.",
                    price = 2.2, image = R.drawable.tiramisu, loyaltyPoints = 3),
                Item(id = 8, categoryId = 2, name = "Club Sandwich", description = "Ham, Cheese, Eggs, Salad, Fries and Toast.",
                    price = 3.3, image = R.drawable.clubsandwich, loyaltyPoints = 5)
            )
        }
    }

    @Composable
    public fun getPainter(): Painter {
        return painterResource(id = image)
    }

}