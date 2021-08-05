package com.cobamvvm.project.data.model

import java.io.Serializable

class FoodResponse : ArrayList<FoodResponseItem>()

data class FoodResponseItem(
    val desc: String,
    val image: String,
    val name: String
):Serializable