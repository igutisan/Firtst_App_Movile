package com.example.basics1.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.basics1.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etxtName: EditText
    private lateinit var etxtLastName: EditText
    private lateinit var etxtPhone: EditText

    private lateinit var etxtEmail: EditText

    private lateinit var etxtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)

        etxtName = findViewById(R.id.tiet_nombres)
        etxtLastName = findViewById(R.id.tiet_apellidos)
        etxtPhone = findViewById(R.id.tiet_phone)
        etxtEmail = findViewById(R.id.tiet_email)
        etxtPassword = findViewById(R.id.tiet_password)
        val btnSaveChanges = findViewById<Button>(R.id.btn_save_edit_changes)

        loadUserData()

        btnSaveChanges.setOnClickListener {
            saveUserData()
        }
    }

    private fun loadUserData() {
        etxtName.setText(sharedPreferences.getString("name", ""))
        etxtLastName.setText(sharedPreferences.getString("lastName", ""))
        etxtPhone.setText(sharedPreferences.getString("phone", ""))
        etxtEmail.setText(sharedPreferences.getString("email", ""))
        etxtPassword.setText(sharedPreferences.getString("password", ""))

    }

    private fun saveUserData() {
        val name = etxtName.text.toString().trim()
        val lastName = etxtLastName.text.toString().trim()
        val phone = etxtPhone.text.toString().trim()
        val email = etxtEmail.text.toString().trim()
        val password = etxtPassword.text.toString().trim()

        if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferences.edit {
            putString("name", name)
            putString("lastName", lastName)
            putString("phone", phone)
            putString("email", email)
            putString("password", password)

        }

        Toast.makeText(this, "Perfil actualizado correctamente", Toast.LENGTH_SHORT).show()
        finish()
    }
}