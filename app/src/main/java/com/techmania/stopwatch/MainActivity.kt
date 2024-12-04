package com.techmania.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var holdButton: Button

    private var isRunning = false
    private var elapsedTime = 0L
    private val handler = Handler()

    private val runnable: Runnable = object : Runnable {
        override fun run() {
            elapsedTime += 1000
            updateTimerTextView()
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        holdButton = findViewById(R.id.holdButton)

        startButton.setOnClickListener {
            startTimer()
        }

        stopButton.setOnClickListener {
            stopTimer()
        }

        holdButton.setOnClickListener {
            holdTimer()
        }
    }

    private fun startTimer() {
        if (!isRunning) {
            isRunning = true
            handler.post(runnable)
        }
    }

    private fun stopTimer() {
        if (isRunning){
            isRunning = false
            handler.removeCallbacks(runnable)
        }

    }

    private fun holdTimer() {
            isRunning = false
            handler.removeCallbacks(runnable)  // Stop updating the timer
            elapsedTime = 0L
            updateTimerTextView()
    }

    private fun updateTimerTextView() {
        val hours = (elapsedTime / 3600000) % 24
        val minutes = (elapsedTime / 60000) % 60
        val seconds = (elapsedTime / 1000) % 60

        timerTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)


    }
}