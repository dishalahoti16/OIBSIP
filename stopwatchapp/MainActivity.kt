package com.techmania.stopwatchapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart : Button
    private lateinit var btnStop : Button
    private lateinit var btnHold : Button
    private lateinit var chronometer : Chronometer
    var pauseAt : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnHold = findViewById(R.id.btnHold)
        chronometer = findViewById(R.id.chronometer)

        btnStart.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()-pauseAt
            chronometer.start()
        }
        btnStop.setOnClickListener {
            pauseAt = SystemClock.elapsedRealtime()-chronometer.base
            chronometer.stop()
        }
        btnHold.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
        }

    }
}
