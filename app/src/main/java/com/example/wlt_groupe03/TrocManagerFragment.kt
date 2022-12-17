package com.example.wlt_groupe03

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.databinding.FragmentAddItemsBinding
import com.example.wlt_groupe03.databinding.FragmentTrocManagerBinding

class TrocManagerFragment : Fragment() {
    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentTrocManagerBinding
    private lateinit var listArticleFragment: ListArticleFragment
    private val detailArticleFragment = DetailArticleFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrocManagerBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listArticleFragment = childFragmentManager.findFragmentByTag("trocList") as ListArticleFragment


        // affichage des articles
        viewModel.mutableLiveDataListTroc.observe(viewLifecycleOwner){
            listArticleFragment.replaceTrocList(it)
        }

        // création des articles
        viewModel.mutableLiveDataCreateArticle.observe(viewLifecycleOwner){
            listArticleFragment.addTroc(it)
        }

        binding.bAfficherDetail.setOnClickListener(){
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, detailArticleFragment)
                .commit()
        }
        //lancement de la requete
        viewModel.launchFetchAllTodo()

        return binding.root
    }

}