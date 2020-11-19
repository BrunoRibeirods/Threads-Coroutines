package com.example.coroutines_threads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Splash com Thread
//        Thread(
//            Runnable {
//                Thread.sleep(5000)
//                runOnUiThread {
//                    val intent = Intent(this, MainActivity :: class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            }
//        ).start()

        // Splash com Handler
//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity :: class.java)
//                    startActivity(intent)
//                    finish()
//        }, 5000)

        // Splash com Coroutines
        scope.launch {
            delay(5000)
            val intent = Intent(this@SplashActivity, MainActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }


}