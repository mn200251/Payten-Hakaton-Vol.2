package com.example.owner.models

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.owner.R

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