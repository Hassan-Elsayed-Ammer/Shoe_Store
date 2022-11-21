package com.hassan.elsayed.ammer.shoe_store.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hassan.elsayed.ammer.shoe_store.model.Shoe

class FakeShoeDao {

    private val shoeList = mutableListOf<Shoe>()

    private val _Shoe = MutableLiveData<List<Shoe>>()
    val shoe: LiveData<List<Shoe>> = _Shoe

    init {
        _Shoe.value =
            shoeList
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _Shoe.value = shoeList
    }

    fun getAllShoes() = shoe
}