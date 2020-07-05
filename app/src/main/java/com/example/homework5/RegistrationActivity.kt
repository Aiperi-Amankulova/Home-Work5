package com.example.homework5

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val loginInSecondActivity = findViewById<EditText>(R.id.loginInSecondActivity)
        val passwordInSecondActivity = findViewById<EditText>(R.id.passwordInSecondActivity)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val prefInSecondActivity = getSharedPreferences("HomeWork5", Context.MODE_PRIVATE)
        val preference = getSharedPreferences("HomeWork", Context.MODE_PRIVATE)

        val textInFirstActivity  =  preference.getString("text","not saved")
        loginInSecondActivity.setText(textInFirstActivity)

        val textInFirstActivity2 =  preference.getString("text2","not saved")
        passwordInSecondActivity.setText(textInFirstActivity2 )

        btnUpdate.setOnClickListener {
            val textToLogin = loginInSecondActivity.text.toString()
            val textToPassword = passwordInSecondActivity.text.toString()

            preference.edit().putString("login",  textToLogin).apply()
            preference.edit().putString("password", textToPassword).apply()

        }


        btnLogout.setOnClickListener {
            val textToLoginInSecondActivity = loginInSecondActivity.text.toString()
            val textToPasswordInSecondActivity = passwordInSecondActivity.text.toString()

            prefInSecondActivity.edit().putString("login", textToLoginInSecondActivity).apply()
            prefInSecondActivity.edit().putString("password", textToPasswordInSecondActivity).apply()

            val intent = Intent( this, MainActivity::class.java)
            intent.putExtra("textToLoginInSecondActivity", textToLoginInSecondActivity)
            intent.putExtra("textToPasswordInSecondActivity", textToPasswordInSecondActivity)


            setResult(Activity.RESULT_OK, intent)
            }
        }

    }
