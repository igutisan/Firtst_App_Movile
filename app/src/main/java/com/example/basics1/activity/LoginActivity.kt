package com.example.basics1.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basics1.R

class LoginActivity  : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //Redireccionamiento

        val startRegister = findViewById<TextView>(R.id.txt_register2)
        startRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val etEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val etPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)



        btnLogin.setOnClickListener {
            compareteLogin(etEmail, etPassword)
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

    private fun compareteLogin(etEmail: EditText, etPasswod: EditText){
        val email= etEmail.text.toString().trim()
        val password = etPasswod.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", "")
        val savedPassword = sharedPreferences.getString("password", "")

        if(email == savedEmail && password == savedPassword){
            // --- CAMBIO IMPORTANTE AQUÍ ---
            // Ahora iniciamos MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra LoginActivity para que el usuario no pueda volver con el botón "Atrás"
        }else{
            Toast.makeText(this,"Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}