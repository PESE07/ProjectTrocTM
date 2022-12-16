package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.databinding.FragmentAddItemsBinding
import com.example.wlt_groupe03.databinding.FragmentFormCreateArticleBinding
import com.example.wlt_groupe03.dtos.DtoOutputAddItem

class FormCreateArticleFragment : Fragment() {
    private lateinit var binding: FragmentFormCreateArticleBinding
    private var callbackOnSubmit:((dto: DtoOutputAddItem)->Unit)? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormCreateArticleBinding.inflate(layoutInflater, container, false)

        binding.btnAddItems.setOnClickListener {
            val article = DtoOutputAddItem(binding.etNomArticle.text.toString(),binding.etImageArticle.text.toString()
                ,binding.etCategorieArticle.text.toString(),binding.etDescriptionArticle.text.toString())
            binding.etNomArticle.text.clear()
            binding.etImageArticle.text.clear()
            binding.etCategorieArticle.text.clear()
            binding.etDescriptionArticle.text.clear()
            callbackOnSubmit?.invoke(article)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(callback: ((DtoOutputAddItem) -> Unit)) =
            FormCreateArticleFragment().apply { callbackOnSubmit = callback }
    }
}