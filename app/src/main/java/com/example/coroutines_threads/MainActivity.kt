package com.example.coroutines_threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThread.setOnClickListener {
            Thread(
                Runnable {
                    Thread.sleep(5000)
                    runOnUiThread {
                        tvSaida.text = "Click Thread"
                    }
                }
            ).start()

        }

        btnHandler.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({ tvSaida.text = "Click Handler"}, 5000)

        }

        btnCoroutine.setOnClickListener {
            scope.launch {
                delay(5000)
                tvSaida.text = "Click Coroutines"
            }
        }

    }
}