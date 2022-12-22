package com.example.wlt_groupe03


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import com.example.wlt_groupe03.dtos.DtoUser
import com.example.wlt_groupe03.repositories.TrocRepository
import com.example.wlt_groupe03.utils.RetrofitHelper
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TrocManagerViewModel : ViewModel() {
    private val trocRepository = RetrofitHelper.newInstance().create(TrocRepository::class.java)
    val mutableLiveDataListUsersArticle: MutableLiveData<List<DtoInputTroc>> = MutableLiveData()
    val mutableLiveDataCreateArticle: MutableLiveData<DtoInputTroc> = MutableLiveData()
    val mutableLiveDataLoginUser: MutableLiveData<DtoUser?> = MutableLiveData()
    val mutableLiveDataDeleteArticle : MutableLiveData<DtoInputTroc> = MutableLiveData()
    val mutableLiveDataError : MutableLiveData<String> = MutableLiveData()
    val mutableLiveDataListArticle: MutableLiveData<List<DtoInputTroc>> = MutableLiveData()



    fun launchFetchAllUsersArticle(){
        viewModelScope.launch {
            // flèche tout à gauche signifie qu'on est bien synchrone

            try{
                val articleList = trocRepository.fetchAllArticleForUser()
                mutableLiveDataListUsersArticle.postValue(articleList)
            }
            catch(e : Exception){
                mutableLiveDataError.postValue("errorLogin")
            }
        }
    }

    fun launchFetchAllArticle(){
        viewModelScope.launch {
            // flèche tout à gauche signifie qu'on est bien synchrone


                val articleList = trocRepository.fetchAllArticle()
                mutableLiveDataListArticle.postValue(articleList)

        }
    }

    fun launchCreateArticle(dtoOutputAddItem: DtoOutputAddItem){
        viewModelScope.launch {
            val article = trocRepository.createArticle(dtoOutputAddItem.name, dtoOutputAddItem.urlImage,
                dtoOutputAddItem.categoryName, dtoOutputAddItem.description)

            mutableLiveDataCreateArticle.postValue(article)
        }
    }

    fun launchGetUser(email : String, mdp :String) {
        viewModelScope.launch {

            try{
                mutableLiveDataLoginUser.postValue(trocRepository.connexion(email, mdp))

            }
            catch(e : HttpException){
                mutableLiveDataLoginUser.postValue(null)
            }

        }
    }

    fun launchUpdateArticle(name : String, description :String,url : String, id : Int ) {
        viewModelScope.launch {

            trocRepository.update(name, description, url, id)

        }
    }

    fun launchDeleteArticle(dtoInputTroc: DtoInputTroc) {
        viewModelScope.launch {

            trocRepository.deleteArticle(dtoInputTroc.id)
            mutableLiveDataDeleteArticle.postValue(dtoInputTroc)
        }
    }














}