package com.example.roommate

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.roommate.databinding.ActivityTermsPolicyBinding
import com.google.firebase.auth.FirebaseAuth

class Register:AppCompatActivity() {
    var back: ImageView? = null
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
            setContentView(R.layout.activity_register)
           val name = findViewById<EditText>(R.id.namer)
            val email = findViewById<EditText>(R.id.emailt)
            val password = findViewById<EditText>(R.id.passt)
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            mAuth = FirebaseAuth.getInstance()
            back = findViewById<View>(R.id.backr) as ImageView
            back!!.setOnClickListener { finish() }
           val logn = findViewById<TextView>(R.id.logina)
            logn.setOnClickListener(View.OnClickListener {
                    startActivity(Intent(applicationContext, login::class.java))
                    finish()
                })

        val regi = findViewById<TextView>(R.id.register)
            regi.setOnClickListener(object : View.OnClickListener {
                var ema: String = email.getText().toString()
                override fun onClick(view: View) {
                    if (name.getText().toString().isEmpty()) {
                        name.setError("name cannot be empty")
                    } else if (email.getText().toString().isEmpty()) {
                        email.setError("email cannot be empty")
                    } else if (!email.getText().toString().matches(emailPattern.toRegex())) {
                        email.setError("Enter the correct email")
                    } else if (password.getText().toString().isEmpty()) {
                        password.setError("passeord cannot be empty")
                    } else if (password.getText().toString().length < 8) {
                        password.setError("password should be more than 8 characters")
                    } else {
                        //    connect();
                        showCustomeDialog()
                    }
                }
            })
    }


    fun showCustomeDialog(){

        val dialogBinding: ActivityTermsPolicyBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(this),
                R.layout.activity_terms_policy,
                null,
                false
            )

        val cb=dialogBinding.cb1



        dialogBinding.termsandConditions.setOnClickListener {
            val intent= Intent(this,terms::class.java)
            startActivity(intent)
        }
        dialogBinding.privacy.setOnClickListener {
            val intent= Intent(this,privacy::class.java)
            startActivity(intent)
        }

        val customDialog = AlertDialog.Builder(this, 0).create()



        dialogBinding?.accept?.setOnClickListener {
            if(cb.isChecked) {
                //   val intent = Intent(applicationContext, SecondPage::class.java)
                //  startActivity(intent)
                //  finish()

                    connect()

            }else {
                Toast.makeText(this,"please accpet terms & conditions", Toast.LENGTH_SHORT).show()

            }
            customDialog.dismiss()


        }

        customDialog.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setView(dialogBinding?.root)
            setCancelable(false)
        }.show()
    }


    private fun connect() {
        val emaila: String = findViewById<EditText>(R.id.emailt).getText().toString()
        val pass: String = findViewById<EditText>(R.id.passt).getText().toString()
        mAuth
            ?.createUserWithEmailAndPassword(emaila, pass)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        "Registration successful!",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    // if the user created intent to login activity
                    val intent = Intent(
                        applicationContext,
                        home::class.java
                    )
                    startActivity(intent)
                } else {

                    // Registration failed
                    Toast.makeText(
                        applicationContext, "Registration failed!!"
                                + " Please try again later",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
    }

}