package com.example.roommate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val log = findViewById<TextView>(R.id.login)
        val Sign = findViewById<TextView>(R.id.register)

        log.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    login::class.java
                )
            )
        })
        Sign.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Register::class.java
                )
            )
        })
    }

}