package com.example.basics1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)
        setupClickListeners()
    }


    private fun setupClickListeners() {
        val etxtName = findViewById<EditText>(R.id.tiet_nombres)
        val etxtLastName = findViewById<EditText>(R.id.tiet_apellidos)
        val etxtEmail = findViewById<EditText>(R.id.tiet_email)
        val etxtPhone = findViewById<EditText>(R.id.tiet_phone)
        val etxtPassword = findViewById<EditText>(R.id.tiet_password)
        val etxtConfirmPassword = findViewById<EditText>(R.id.tiet_confirm_password)

        val btnRegister = findViewById<Button>(R.id.btn_create_account)
        btnRegister.setOnClickListener {
            val name = etxtName.text.toString().trim()
            val lastName = etxtLastName.text.toString().trim()
            val email = etxtEmail.text.toString().trim()
            val phone = etxtPhone.text.toString().trim()
            val password = etxtPassword.text.toString().trim()
            val confirmPassword = etxtConfirmPassword.text.toString().trim()

            if (validateFields(name, lastName, email, phone, password, confirmPassword)) {
                saveUserData(name, lastName, email, phone, password)

                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }

    private fun validateFields(
        name: String,
        lastName: String,
        email: String,
        phone: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun saveUserData(
        name: String,
        lastName: String,
        email: String,
        phone: String,
        password: String
    ) {
        sharedPreferences.edit {
            putString("name", name)
            putString("lastName", lastName)
            putString("email", email)
            putString("phone", phone)
            putString("password", password)
        }
    }

}