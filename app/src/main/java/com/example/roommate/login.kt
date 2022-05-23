package com.example.roommate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class login:AppCompatActivity() {
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emails = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.passwordedit)
        val back = findViewById<ImageView>(R.id.back)
        val log = findViewById<TextView>(R.id.login)
        mAuth = FirebaseAuth.getInstance()
        back.setOnClickListener(View.OnClickListener { finish() })
        log.setOnClickListener(View.OnClickListener {
            if (emails.getText().toString().isEmpty()) {
                emails.setError("email cannot be empty")
            } else if (!emails.getText().toString().matches(emailPattern.toRegex())) {
                emails.setError("Enter the correct email")
            } else if (pass.getText().toString().isEmpty()) {
                pass.setError("password cannot be empty")
            } else if (pass.getText().toString().length < 8) {
                pass.setError("password must contain more than 8 characters")
            } else {
                perfomrlogin()
                startActivity(Intent(applicationContext, home::class.java))
            }
        })
        val sign = findViewById<TextView>(R.id.signin)
        sign.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)
        })

}
    private fun perfomrlogin() {
        val email: String = findViewById<EditText>(R.id.username).getText().toString()
        val passa: String = findViewById<EditText>(R.id.passwordedit).getText().toString()
        mAuth!!.signInWithEmailAndPassword(email, passa).addOnSuccessListener {
            startActivity(
                Intent(
                    applicationContext,
                    home::class.java
                )
            )
        }
    }
}