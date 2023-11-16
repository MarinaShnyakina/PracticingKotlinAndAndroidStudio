package com.example.practicingkotlinandandroidstudio.invertory

import android.app.Application
import com.example.practicingkotlinandandroidstudio.inventory.data.ItemRoomDatabase

class InventoryApplication : Application() {
    val database: ItemRoomDatabase by lazy {
        ItemRoomDatabase.getDatabase(this)
    }

}