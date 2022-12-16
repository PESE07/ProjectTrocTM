package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableListener()
    }

    private fun enableListener(){
        binding.btnMainActivityDisplayingItems.setOnClickListener {
            val intent = Intent(this, DisplayingItems::class.java).also {
                startActivity(it)

            }
        }
    }

}