package com.company.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
        set(value) {
            field = value
            countLiveData.value = value
        }

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }
}