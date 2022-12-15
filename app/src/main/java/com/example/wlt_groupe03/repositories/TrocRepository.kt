package com.example.wlt_groupe03.repositories

import com.example.wlt_groupe03.dtos.DtoInputTroc
import retrofit2.http.GET

interface TrocRepository {
    @GET("article")
    suspend fun fetchAll(): List<DtoInputTroc>

}