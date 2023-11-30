package com.example.owner.activities.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.owner.App
import com.example.owner.models.Item
import com.example.owner.ui.ItemsScreen
import com.example.owner.ui.theme.OwnerTheme

class ItemsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = (this.applicationContext as App).category
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ItemsScreen(onAddItem = {
                        intent = Intent(this, AddItemActivity::class.java)
                        startActivity(intent)
                    }, items = Item.getFakeItems().filter { it.categoryId == category?.id},
                        onEdit = {
                        intent = Intent(this, UpdateItemActivity::class.java)
                        startActivity(intent)
                            (this.applicationContext as App).item = it
                    }, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
