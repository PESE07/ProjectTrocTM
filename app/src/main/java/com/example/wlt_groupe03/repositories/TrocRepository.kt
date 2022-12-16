package com.example.wlt_groupe03.repositories

import com.example.wlt_groupe03.dtos.DtoInputTroc
import com.example.wlt_groupe03.dtos.DtoOutputAddItem
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TrocRepository {
    @GET("article")
    suspend fun fetchAll(): List<DtoInputTroc>

    @POST("article/create")
    suspend fun create(@Query("name") name:String,
                       @Query("urlImage") urlImage:String,
                       @Query("categoryName") categoryName:String,
                       @Query("description") description:String):DtoInputTroc
}