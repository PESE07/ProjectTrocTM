package com.example.wlt_groupe03.repositories

import com.example.wlt_groupe03.dtos.DtoInputArticle
import com.example.wlt_groupe03.dtos.DtoUser
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TrocRepository {
    @GET("Article/Id_Users")
    suspend fun fetchAllArticleForUser(): List<DtoInputArticle>

    @GET("Article")
    suspend fun fetchAllArticle(): List<DtoInputArticle>

    @GET("Users")
    suspend fun fetchAllUsers(): List<DtoUser>

    @DELETE("Article/{id}")
    suspend fun deleteArticle(@Path("id") id :Int) : Response<Void?>

    @POST("Article/Create")
    suspend fun createArticle(@Query("name") name:String,
                              @Query("urlImage") urlImage:String,
                              @Query("nomCat") categoryName:String,
                              @Query("description") description:String):DtoInputArticle


    @POST("Users/connexion")
    suspend fun connexion(@Query("email") email:String,
                        @Query("mdp") mdp : String): DtoUser

    @PUT("Article")
    suspend fun update(@Query("name") name:String,
                       @Query("description") description:String,
                       @Query("url") url: String,
                       @Query("id") id:Int) : Response<Void?>
}