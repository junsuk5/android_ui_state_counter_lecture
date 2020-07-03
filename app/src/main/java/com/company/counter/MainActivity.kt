package com.company.counter

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ")

        viewModel.countLiveData.observe(this, Observer { count ->
            counter_text.text = "$count"
        })

        add_button.setOnClickListener {
            viewModel.increaseCount()
        }

        sub_button.setOnClickListener {
            viewModel.decreaseCount()
        }

    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}