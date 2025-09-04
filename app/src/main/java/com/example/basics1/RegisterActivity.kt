package com.example.basics1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.apply
import kotlin.toString

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        sharedPreferences = getSharedPreferences("userData",MODE_PRIVATE)
        setupOnClickListener()
    }



    private fun setupOnClickListener() {
        val etxtNombre = findViewById<EditText>(R.id.tiet_nombres)
        val etxtApellido = findViewById<EditText>(R.id.tiet_apellidos)
        val etxtCorreo = findViewById<EditText>(R.id.tiet_email)
        val etxtTelefono = findViewById<EditText>(R.id.tiet_phone)
        val etxtContraseña = findViewById<EditText>(R.id.tiet_password)
        val etxtReContraseña = findViewById<EditText>(R.id.tiet_confirm_password)

        val btnRegistro = findViewById<Button>(R.id.btn_create_account)
        btnRegistro.setOnClickListener {
            val nombre = etxtNombre.text.toString().trim()
            val apellido = etxtApellido.text.toString().trim()
            val correo = etxtCorreo.text.toString().trim()
            val telefono = etxtTelefono.text.toString().trim()
            val contraseña = etxtContraseña.text.toString().trim()
            val reContraseña = etxtReContraseña.text.toString().trim()

            if (validarCampos(nombre, apellido, correo, telefono, contraseña, reContraseña)) {
                guardarDatosUsuario(nombre, apellido, correo, telefono, contraseña)

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
    private fun validarCampos(nombre: String, apellido: String, correo: String, telefono: String, contraseña: String, reContraseña: String): Boolean {
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contraseña.isEmpty() || reContraseña.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun guardarDatosUsuario(nombre: String, apellido: String, correo: String, telefono: String, contraseña: String) {
        val editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.putString("apellido", apellido)
        editor.putString("correo", correo)
        editor.putString("telefono", telefono)
        editor.putString("contraseña", contraseña)
        editor.apply()
    }

}


