package com.example.practicingkotlinandandroidstudio.inventory

import androidx.lifecycle.*
import com.example.practicingkotlinandandroidstudio.inventory.data.Item
import com.example.practicingkotlinandandroidstudio.inventory.data.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String)
    : Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt(),
        )
    }

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String, ) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insertItem(newItem)
    }

    // check empty fields
    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String)
    : Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }

    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()
    }

    private fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.update(item)
        }
    }

    fun sellItem(item: Item) {
        if (item.quantityInStock > 0) {
            val newItem = item.copy(quantityInStock = item.quantityInStock -1)
            updateItem(newItem)
        }
    }

    fun isStockAvailable(item: Item): Boolean {
        return (item.quantityInStock > 0)
    }
}

// can be reused
class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }

}