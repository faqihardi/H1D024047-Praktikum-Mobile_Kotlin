package com.example.faqih.network

import com.example.faqih.data.model.Category
import com.example.faqih.data.model.Product
import com.example.faqih.util.JualanConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiInterface {
    @GET("data/categories.json")
    suspend fun getCategories(): List<Category>

    @GET("data/products.json")
    suspend fun getProducts(): List<Product>
}

object ApiClient {

    val instance: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(JualanConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}