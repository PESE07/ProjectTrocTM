package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.ActivityMainBinding
import com.example.wlt_groupe03.databinding.ActivityMainMenuBinding
import com.example.wlt_groupe03.dtos.DtoUser

class MainMenuActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainMenuBinding
    // constructeur avec arguments




    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        enableListener()
    }

    private fun enableListener(){

        binding.btnDisplayItems.setOnClickListener{
            val intent = Intent(this, DisplayingItems::class.java)
            startActivity(intent)
        }

        binding.btnAddItem.setOnClickListener {

            val intent = Intent(this, AddingItems::class.java)
            startActivity(intent)
        }

        binding.btnModifyProfile.setOnClickListener {

            val intent = Intent(this, ModifyProfileActivity::class.java)
            startActivity(intent)
        }
    }
}


