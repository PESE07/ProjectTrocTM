package com.example.wlt_groupe03

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.databinding.ActivityAddingItemsBinding
import com.example.wlt_groupe03.databinding.FragmentAddItemsBinding
import com.example.wlt_groupe03.databinding.FragmentTrocManagerBinding
import com.example.wlt_groupe03.dtos.DtoOutputAddItem

class AddingItemsFragment : Fragment() {

    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentAddItemsBinding
    private lateinit var listArticleFragment: ListArticleFragment

    private var formCreateArticleFragment = FormCreateArticleFragment.newInstance {
        viewModel.launchCreateArticle(it)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView_fragmentAddArticle, listArticleFragment)
            .commit()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemsBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)


        return binding.root
    }
}