package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wlt_groupe03.databinding.ActivityMainMenuBinding

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

        binding.btnDisplayMyItems.setOnClickListener{
            val intent = Intent(this, DisplayingUsersItems::class.java)
            startActivity(intent)
        }

        binding.btnAddItem.setOnClickListener {

            val intent = Intent(this, AddingItems::class.java)
            startActivity(intent)
        }

        binding.btnDisplayAllItems.setOnClickListener {

            val intent = Intent(this, DisplayingAllItems::class.java)
            startActivity(intent)
        }


    }
}


