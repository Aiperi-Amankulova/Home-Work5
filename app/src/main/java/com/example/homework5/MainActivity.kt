package com.example.homework5

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginINFirstActivity = findViewById<EditText>(R.id.loginINFirstActivity)
        val passwordInFirstActivity = findViewById<EditText>(R.id.passwordINFirstActivity)
        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        val preference = getSharedPreferences("HomeWork", Context.MODE_PRIVATE)

        btnSignIn.setOnClickListener {

            val intent = Intent(applicationContext,  RegistrationActivity::class.java)

            startActivity(intent)


            val textInSecondActivity  =  preference.getString("text","not saved")
            loginINFirstActivity.setText(textInSecondActivity)

            val textInSecondActivity2 =  preference.getString("text2","not saved")
            passwordInFirstActivity.setText(textInSecondActivity2 )

                finish()
            }

        btnSignUp.setOnClickListener {
            val textToLogin = loginINFirstActivity.text.toString()
            val textToPassword = passwordInFirstActivity.text.toString()
            val text = "Data saved"
            val duration = Toast.LENGTH_SHORT


            preference.edit().putString("login",  textToLogin).apply()
            preference.edit().putString("password", textToPassword).apply()

            Toast.makeText(applicationContext, text, duration).show()

        }


        startActivity(intent)
        }
    }
