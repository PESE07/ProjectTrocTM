package com.example.wlt_groupe03

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import com.example.wlt_groupe03.repositories.TrocRepository
import com.example.wlt_groupe03.utils.RetrofitHelper
import kotlinx.coroutines.launch

class TrocManagerViewModel : ViewModel() {
    private val trocRepository = RetrofitHelper.newInstance().create(TrocRepository::class.java)
    val mutableLiveDataListTroc: MutableLiveData<List<DtoInputTroc>> = MutableLiveData()
    val mutableLiveDataCreateArticle: MutableLiveData<DtoInputTroc> = MutableLiveData()

    fun launchFetchAllTodo(){
        viewModelScope.launch {
            // flèche tout à gauche signifie qu'on est bien synchrone
            val articleList = trocRepository.fetchAll()

            mutableLiveDataListTroc.postValue(articleList)
        }
    }

    fun launchCreateArticle(dtoOutputAddItem: DtoOutputAddItem){
        viewModelScope.launch {
            val article = trocRepository.create(dtoOutputAddItem.name, dtoOutputAddItem.urlImage,
                dtoOutputAddItem.categoryName, dtoOutputAddItem.description)

            mutableLiveDataCreateArticle.postValue(article)
        }
    }
}