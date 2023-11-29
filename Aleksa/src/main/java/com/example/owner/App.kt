package com.example.owner

import android.app.Application
import com.example.owner.models.Category
import com.example.owner.models.Item
import com.example.owner.models.Order

class App: Application() {

    var category: Category? = null
    var item: Item? = null
    var order: Order? = null
}