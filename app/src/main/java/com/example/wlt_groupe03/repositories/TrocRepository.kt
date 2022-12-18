package com.example.wlt_groupe03.repositories

import android.webkit.HttpAuthHandler
import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoLogin
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import com.example.wlt_groupe03.dtos.DtoUser
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TrocRepository {
    @GET("Article")
    suspend fun fetchAll(): List<DtoInputTroc>

    @POST("Article/Create")
    suspend fun create(@Query("name") name:String,
                       @Query("urlImage") urlImage:String,
                       @Query("nomCat") categoryName:String,
                       @Query("description") description:String):DtoInputTroc


    @POST("Users/connexion")
    suspend fun connexion(@Query("email") email:String,
                        @Query("mdp") mdp : String): DtoUser
}