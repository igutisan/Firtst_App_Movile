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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)

        etxtName = findViewById(R.id.etxt_edit_name)
        etxtLastName = findViewById(R.id.etxt_edit_last_name)
        etxtPhone = findViewById(R.id.etxt_edit_phone)
        val btnSaveChanges = findViewById<Button>(R.id.btn_save_changes)

        loadUserData()

        btnSaveChanges.setOnClickListener {
            saveUserData()
        }
    }

    private fun loadUserData() {
        etxtName.setText(sharedPreferences.getString("name", ""))
        etxtLastName.setText(sharedPreferences.getString("lastName", ""))
        etxtPhone.setText(sharedPreferences.getString("phone", ""))
    }

    private fun saveUserData() {
        val name = etxtName.text.toString().trim()
        val lastName = etxtLastName.text.toString().trim()
        val phone = etxtPhone.text.toString().trim()

        if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferences.edit {
            putString("name", name)
            putString("lastName", lastName)
            putString("phone", phone)
            // No editamos el email ni la contraseña aquí para mantenerlo simple
        }

        Toast.makeText(this, "Perfil actualizado correctamente", Toast.LENGTH_SHORT).show()
        finish() // Cierra la actividad y vuelve al perfil
    }
}