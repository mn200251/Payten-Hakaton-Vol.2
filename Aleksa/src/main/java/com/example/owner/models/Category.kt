package com.example.owner.models

import androidx.compose.runtime.Composable
import com.example.owner.R

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
                "softdrink" to R.drawable.softdrink, "dessert" to R.drawable.dessert)
        }

        @Composable
        public fun getFakeCategories(): List<Category> {
            return listOf(
                Category(id = 0, placeId = 0, name = "Drinks", icon = "drink"),
                Category(id = 1, placeId = 0, name = "Soft Drinks", icon = "softdrink"),
                Category(id = 2, placeId = 0, name = "Food", icon = "food"),
                Category(id = 3, placeId = 0, name = "Dessert", icon = "dessert")
            )
        }
    }
}