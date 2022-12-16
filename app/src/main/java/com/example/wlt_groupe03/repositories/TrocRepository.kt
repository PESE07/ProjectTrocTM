package com.example.wlt_groupe03.repositories

import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import retrofit2.http.GET
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
}