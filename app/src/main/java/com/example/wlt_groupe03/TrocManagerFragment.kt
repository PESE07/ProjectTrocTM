package com.example.wlt_groupe03

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wlt_groupe03.databinding.FragmentTrocManagerBinding

class TrocManagerFragment : Fragment() {
    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentTrocManagerBinding
    private lateinit var listUsersArticleFragment: ListUsersArticleFragment



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrocManagerBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listUsersArticleFragment = childFragmentManager.findFragmentByTag("trocList") as ListUsersArticleFragment


        viewModel.mutableLiveDataError.observe(viewLifecycleOwner){
            Toast.makeText(activity, "Vous n'avez aucun article",Toast.LENGTH_SHORT).show()
        }

        viewModel.mutableLiveDataDeleteArticle.observe(viewLifecycleOwner){
            listUsersArticleFragment.deleteArticle(it)
        }
        // affichage des articles
        viewModel.mutableLiveDataListUsersArticle.observe(viewLifecycleOwner){
            listUsersArticleFragment.replaceArticleList(it)
        }

        // création des articles
        viewModel.mutableLiveDataCreateArticle.observe(viewLifecycleOwner){
            listUsersArticleFragment.addArticle(it)
        }




        //lancement de la requete
        viewModel.launchFetchAllUsersArticle()

        return binding.root
    }







}