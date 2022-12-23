package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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

        val viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)

        viewModel.mutableLiveDataLoginUser.observe(this) {
            val user = viewModel.mutableLiveDataLoginUser.value

            if(user == null){
                Toast.makeText(this, "Les données encoder ne sont pas correct", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, MainMenuActivity::class.java)
                startActivity(intent)
            }
        }
        binding.btnLogin.setOnClickListener {

            if(binding.tvEmailUser.text.isNullOrBlank() || binding.etPasswordUser.text.isNullOrBlank()){
                Toast.makeText(this, "Veuillez remplir tout les champs si dessus", Toast.LENGTH_SHORT).show()
            }
            else{

                val mail = binding.tvEmailUser.text.toString()
                val password = binding.etPasswordUser.text.toString()
                viewModel.launchGetUser(mail,password)
            }
        }
    }
}