package com.example.wlt_groupe03

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.databinding.FragmentTrocManagerBinding

class TrocManagerFragment : Fragment() {
    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentTrocManagerBinding
    private lateinit var listArticleFragment: ListArticleFragment
    private lateinit var detailArticleFragment : DetailArticleFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrocManagerBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listArticleFragment = childFragmentManager.findFragmentByTag("trocList") as ListArticleFragment


        viewModel.mutableLiveDataDeleteArticle.observe(viewLifecycleOwner){
            listArticleFragment.deleteArticle(it)
        }
        // affichage des articles
        viewModel.mutableLiveDataListTroc.observe(viewLifecycleOwner){
            listArticleFragment.replaceArticleList(it)
        }

        // création des articles
        viewModel.mutableLiveDataCreateArticle.observe(viewLifecycleOwner){
            listArticleFragment.addArticle(it)
        }




        //lancement de la requete
        viewModel.launchFetchAllTodo()

        return binding.root
    }







}