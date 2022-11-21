package com.hassan.elsayed.ammer.shoe_store.ui

import androidx.lifecycle.ViewModel
import com.hassan.elsayed.ammer.shoe_store.db.FakeShoeDao
import com.hassan.elsayed.ammer.shoe_store.model.Shoe

class MainActivityViewModel: ViewModel() {

    private val fakeShoeDao = FakeShoeDao()

    fun getShoes() = fakeShoeDao.getAllShoes()

    fun addShoe(shoe: Shoe) = fakeShoeDao.addShoe(shoe)

}

