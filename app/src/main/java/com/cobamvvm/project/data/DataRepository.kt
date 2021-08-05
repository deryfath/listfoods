package com.cobamvvm.project.data

import com.cobamvvm.project.data.api.ApiService
import com.cobamvvm.project.data.model.FoodResponseItem

class DataRepository(private val apiDataRepository: ApiService
                     ) {

    suspend fun getFoodData():List<FoodResponseItem>{
        return apiDataRepository.getFoodData().await()
    }

}