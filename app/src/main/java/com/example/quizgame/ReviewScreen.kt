package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReviewScreen : AppCompatActivity() {
 private lateinit var reviewText: TextView
 private lateinit var homeBtn: Button
 private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        reviewText= findViewById(R.id.reviewText)
        homeBtn = findViewById(R.id.homeBtn)
        exitBtn = findViewById(R.id.exitBtn)

        val questions = intent.getStringExtra("questions")
        val answers = intent.getBooleanArrayExtra("questions")
    }
}