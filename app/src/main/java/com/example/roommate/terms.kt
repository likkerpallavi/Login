package com.example.roommate

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class terms:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()

        }
    }
}