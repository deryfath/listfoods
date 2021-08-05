package com.cobamvvm.project.data.api

import com.cobamvvm.project.data.model.FoodResponseItem
import retrofit2.http.GET
import kotlinx.coroutines.Deferred


interface ApiService {

    @GET("/foods")
    fun getFoodData():Deferred<List<FoodResponseItem>>
}