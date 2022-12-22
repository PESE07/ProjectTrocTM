package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wlt_groupe03.dtos.DtoInputArticle
import com.example.wlt_groupe03.dtos.DtoUser
import com.example.wlt_groupe03.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ListUsersFragment : Fragment() {

    private val userList:ArrayList<DtoUser> = arrayListOf()
    private val trocAdapter = ListUsersAdapter(userList)
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_users, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = trocAdapter
            }
        }
        return view
    }

    companion object {


        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListUsersFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    fun replaceArticleList(list: List<DtoUser>){
        userList.clear()
        userList.addAll(list)
        trocAdapter.notifyDataSetChanged()
    }
}