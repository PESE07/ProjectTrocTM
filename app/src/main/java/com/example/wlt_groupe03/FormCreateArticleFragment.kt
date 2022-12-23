package com.example.wlt_groupe03


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.FragmentFormCreateArticleBinding
import com.example.wlt_groupe03.dtos.DtoOutputAddArticle

class FormCreateArticleFragment : Fragment() {
    private lateinit var binding: FragmentFormCreateArticleBinding
    private lateinit var viewModel: TrocManagerViewModel
    private var callbackOnSubmit:((dto: DtoOutputAddArticle)->Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormCreateArticleBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[TrocManagerViewModel::class.java]

        val spinner = binding.sCategory

        viewModel.mutableLiveDataCategories.observe(viewLifecycleOwner){

            
            val items = arrayListOf<String>()

            it.forEach{ it ->
                items.add(it.nomCategory)
            }

            val adapter =
                activity?.let { it1 -> ArrayAdapter(it1, R.layout.simple_spinner_item, items) }

            adapter?.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }

        binding.btnAddCamera.setOnClickListener{
            val intent = Intent(activity, CameraActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddItems.setOnClickListener {

            if(binding.etNomArticle.text.isNullOrBlank() || binding.etImageArticle.text.isNullOrBlank()
                ||  binding.etDescriptionArticle.text.isNullOrBlank()){
                Toast.makeText(it.context, "Veuillez remplir tout les champs si dessus", Toast.LENGTH_SHORT).show()
            }
            else{
                val article = DtoOutputAddArticle(binding.etNomArticle.text.toString(),binding.etImageArticle.text.toString()
                    ,spinner.selectedItem.toString(),binding.etDescriptionArticle.text.toString())
                binding.etNomArticle.text.clear()
                binding.etImageArticle.text.clear()
                spinner.setSelection(0)
                binding.etDescriptionArticle.text.clear()
                callbackOnSubmit?.invoke(article)

                viewModel.launchCreateArticle(article)

            }


        }
        viewModel.launchFetchAllCategories()

        return binding.root


    }

    


}