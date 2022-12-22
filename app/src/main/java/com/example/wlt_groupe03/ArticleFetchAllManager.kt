package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.FragmentArticleFetchAllManagerBinding


class ArticleFetchAllManager : Fragment() {

    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentArticleFetchAllManagerBinding
    private lateinit var listAllArticleFragment: ListAllArticleFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleFetchAllManagerBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listAllArticleFragment = childFragmentManager.findFragmentByTag("allArticleList") as ListAllArticleFragment


        viewModel.mutableLiveDataDeleteArticle.observe(viewLifecycleOwner){
            listAllArticleFragment.deleteArticle(it)
        }
        // affichage des articles
        viewModel.mutableLiveDataListArticle.observe(viewLifecycleOwner){
            listAllArticleFragment.replaceArticleList(it)
        }

        // création des articles
        viewModel.mutableLiveDataCreateArticle.observe(viewLifecycleOwner){
            listAllArticleFragment.addArticle(it)
        }

        //lancement de la requete
        viewModel.launchFetchAllArticle()

        return binding.root
    }
}