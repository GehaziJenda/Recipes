package com.gehazijenda.recipes.data.api

import com.gehazijenda.recipes.data.constants.AppConstants
import com.gehazijenda.recipes.data.models.CategoriesResponse
import com.gehazijenda.recipes.data.models.RegionsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(AppConstants.baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService: ApiService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("list.php?a=list")
    suspend fun getRegions(): RegionsResponse

}