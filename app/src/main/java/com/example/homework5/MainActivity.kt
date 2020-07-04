package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginINFirstActivity = findViewById<EditText>(R.id.loginINFirstActivity)
        val passwordInSecondActivity = findViewById<EditText>(R.id.passwordINFirstActivity)
        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnSignIn.setOnClickListener {
            val intent = Intent(applicationContext,  RegistrationActivity::class.java)

            startActivity(intent)
        }

        startActivity(intent)
        }
    }
