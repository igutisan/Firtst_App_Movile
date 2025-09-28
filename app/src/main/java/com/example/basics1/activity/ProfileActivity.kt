package com.example.basics1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basics1.R
import com.example.basics1.fragments.MyProfileFragment

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Si es la primera vez que se crea la actividad, cargamos el fragmento
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, MyProfileFragment())
                .commit()
        }
    }
}