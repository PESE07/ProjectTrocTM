package com.example.wlt_groupe03

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.repositories.TrocRepository
import com.example.wlt_groupe03.utils.RetrofitHelper
import kotlinx.coroutines.launch

class TrocManagerViewModel : ViewModel() {
    private val trocRepository = RetrofitHelper.newInstance().create(TrocRepository::class.java)
    val mutableLiveDataListTodo: MutableLiveData<List<DtoInputTroc>> = MutableLiveData()

    fun launchFetchAllTodo(){
        viewModelScope.launch {
            // flèche tout à gauche signifie qu'on est bien synchrone
            val articleList = trocRepository.fetchAll()
            mutableLiveDataListTodo.postValue(articleList)
        }
    }
}