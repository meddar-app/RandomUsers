package com.codabee.randomusers.service

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//BaseURL
private val BaseUrl = "https://randomuser.me/"
//ConfigureRetrofit
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BaseUrl)
    .build()
//Apiservices pour les appels
 interface ApiServices {
     @GET("api/")
     suspend fun getRandonUser(
         @Query("results") results: String = "55"
     ):String
 }
//Gerer l'appel
object ApiManager {

    val Service: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}