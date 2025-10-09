package com.example.basics1.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.basics1.R
import com.example.basics1.fragments.HomeFragment
import com.example.basics1.fragments.MyProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private val homeFragment = HomeFragment()
    private val myProfileFragment = MyProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        val menuButton = findViewById<ImageView>(R.id.menu_button)

        menuButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // Establecer el listener para los ítems del menú
        navigationView.setNavigationItemSelectedListener(this)


        if (savedInstanceState == null) {
            replaceFragment(homeFragment)
            navigationView.setCheckedItem(R.id.menu_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Manejar la selección de ítems del menú
        when (item.itemId) {
            R.id.menu_home -> replaceFragment(homeFragment)
            R.id.menu_profile -> replaceFragment(myProfileFragment)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}