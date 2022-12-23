package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.FragmentTrocManagerBinding
import com.example.wlt_groupe03.databinding.FragmentUsersManagerBinding


class UsersManagerFragment : Fragment() {

    private lateinit var viewModel: TrocManagerViewModel
    private lateinit var binding: FragmentUsersManagerBinding
    private lateinit var listUsersFragment: ListUsersFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersManagerBinding.inflate(layoutInflater,container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)
        listUsersFragment = childFragmentManager.findFragmentByTag("userList") as ListUsersFragment


        // affichage des utilisateurs
        viewModel.mutableLiveDataUsers.observe(viewLifecycleOwner){
            listUsersFragment.replaceArticleList(it)
        }


        //lancement de la requete
        viewModel.launchFetchAllUsers()

        return binding.root
    }
}