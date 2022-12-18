package com.example.wlt_groupe03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.databinding.ActivityMainBinding
import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoLogin
import retrofit2.HttpException


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: TrocManagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableListener()
    }

    private fun enableListener(){

        binding.btnLogin.setOnClickListener {

            if(binding.tvEmailUser.text.isNullOrBlank() || binding.tvPasswordUser.text.isNullOrBlank()){
                Toast.makeText(this, "Veuillez remplir tout les champs si dessus", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)

                val mail = binding.tvEmailUser.text.toString()
                val password = binding.tvPasswordUser.text.toString()


                val user = viewModel.launchGetUser(mail, password)

                Toast.makeText(this, "${user}", Toast.LENGTH_SHORT).show()
                if(user == null){
                    Toast.makeText(this, "Les données encoder ne sont pas correct", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this, MainMenuActivity::class.java)
                    startActivity(intent)
                }

            }

        }


    }

}