package com.example.projectpraktikumpember

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    //pindah fragment
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, HomeFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_kategori -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, KategoriFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, PesananFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, AboutFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment())
            .commit()

    }
}