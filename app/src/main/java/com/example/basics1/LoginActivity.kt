package com.example.basics1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var buttonLogin = findViewById<Button>(R.id.btn_login)
        buttonLogin.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        var txtRecoverPassword = findViewById<TextView>(R.id.txt_resetpassword)
        txtRecoverPassword.setOnClickListener {
            var intent = Intent(this, RecoverPasswordActivity::class.java)
            startActivity(intent)
        }

        var txtRegister = findViewById<TextView>(R.id.txt_register2)
        txtRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}