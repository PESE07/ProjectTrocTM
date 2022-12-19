package com.example.wlt_groupe03

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.FragmentAddItemsBinding
import com.example.wlt_groupe03.databinding.FragmentFormCreateArticleBinding
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import retrofit2.http.Url

class FormCreateArticleFragment : Fragment() {
    private lateinit var binding: FragmentFormCreateArticleBinding
    private lateinit var viewModel: TrocManagerViewModel
    private var callbackOnSubmit:((dto: DtoOutputAddItem)->Unit)? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormCreateArticleBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        binding.btnAddItems.setOnClickListener {

            if(binding.etNomArticle.text.isNullOrBlank() || binding.etImageArticle.text.isNullOrBlank()
                || binding.etCategorieArticle.text.isNullOrBlank() || binding.etDescriptionArticle.text.isNullOrBlank()){
                Toast.makeText(it.context, "Veuillez remplir tout les champs si dessus", Toast.LENGTH_SHORT).show()
            }
            else{
                val article = DtoOutputAddItem(binding.etNomArticle.text.toString(),binding.etImageArticle.text.toString()
                    ,binding.etCategorieArticle.text.toString(),binding.etDescriptionArticle.text.toString())
                binding.etNomArticle.text.clear()
                binding.etImageArticle.text.clear()
                binding.etCategorieArticle.text.clear()
                binding.etDescriptionArticle.text.clear()
                callbackOnSubmit?.invoke(article)

                viewModel.launchCreateArticle(article)

            }
        }
        return binding.root


    }

    companion object {

        @JvmStatic
        fun newInstance(callback: ((DtoOutputAddItem) -> Unit)) =
            FormCreateArticleFragment().apply { callbackOnSubmit = callback }
    }


}