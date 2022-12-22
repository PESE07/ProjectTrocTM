package com.example.wlt_groupe03

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.FragmentListArticleItemBinding
import com.example.wlt_groupe03.dtos.DtoInputTroc

/**
 * A fragment representing a list of Items.
 */
class ListUsersArticleFragment : Fragment() {
    private val trocList:ArrayList<DtoInputTroc> = arrayListOf()
    private val trocAdapter = TrocRecyclerViewAdapter(trocList)
    private lateinit var binding: FragmentListArticleItemBinding
    private lateinit var updateArticleFragment : UpdateArticleFragment
    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var detailArticleFragment: DetailArticleFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListArticleItemBinding.inflate(layoutInflater,container, false)
        val view = inflater.inflate(R.layout.fragment_list_users_article, container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = trocAdapter.apply {
                    onItemUpdateOnClickListener = {
                        updateArticleFragment = UpdateArticleFragment(it)
                        parentFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, updateArticleFragment)
                            .commit()
                    }
                    onItemDeleteOnClickListener = {
                        viewModel.launchDeleteArticle(it)
                        Toast.makeText(activity, "L'article a bien été supprimé", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, MainMenuActivity::class.java)
                        startActivity(intent)
                    }
                    onItemDetailOnClickListener = {
                        detailArticleFragment = DetailArticleFragment(it)
                        parentFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, detailArticleFragment)
                            .commit()
                    }
                }
            }
        }

        return view
    }

    fun replaceArticleList(list: List<DtoInputTroc>){
        trocList.clear()
        trocList.addAll(list)
        trocAdapter.notifyDataSetChanged()
    }

    fun addArticle(dto:DtoInputTroc){
        trocList.add(dto)
        trocAdapter.notifyDataSetChanged()
    }

    fun deleteArticle(dto:DtoInputTroc){
        trocList.remove(dto)
        trocAdapter.notifyDataSetChanged()
    }



    companion object {
        fun newInstance() = ListUsersArticleFragment()
    }
}