package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.dtos.DtoInputTroc

/**
 * A fragment representing a list of Items.
 */
class ListArticleFragment : Fragment() {
    private val trocList:ArrayList<DtoInputTroc> = arrayListOf();
    private val trocAdapter = TrocRecyclerViewAdapter(trocList);

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_article, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = trocAdapter
            }
        }
        return view
    }

    fun replaceTrocList(list: List<DtoInputTroc>){
        trocList.clear()
        trocList.addAll(list)
        trocAdapter.notifyDataSetChanged()
    }

    fun addTroc(dto:DtoInputTroc){
        trocList.add(dto)
        trocAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = ListArticleFragment()
    }
}