package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.ActivityMainBinding
import com.example.wlt_groupe03.databinding.ActivityMainMenuBinding
import com.example.wlt_groupe03.databinding.ActivityModifyProfileBinding
import com.example.wlt_groupe03.dtos.DtoUser

class ModifyProfileActivity(user: Int) : AppCompatActivity() {

    lateinit var binding: ActivityModifyProfileBinding
    private val iduser = user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_modify_profile)

        enableListener()
    }

    private fun enableListener(){

        val viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)


        Toast.makeText(this, "${iduser}", Toast.LENGTH_SHORT).show()



    }
}