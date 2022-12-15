package com.example.wlt_groupe03

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.databinding.FragmentListArticleItemBinding

class TrocManagerFragment : Fragment() {private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentListArticleItemBinding
    private lateinit var listArticleFragment: ListArticleFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListArticleItemBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listArticleFragment = childFragmentManager.findFragmentByTag("trocList") as ListArticleFragment

        viewModel.mutableLiveDataListTodo.observe(viewLifecycleOwner){
            listArticleFragment.replaceTrocList(it)
        }

        //lancement de la requete
        viewModel.launchFetchAllTodo()

        return binding.root
    }

}