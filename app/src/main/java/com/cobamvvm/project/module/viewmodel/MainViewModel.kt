package com.cobamvvm.project.module.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cobamvvm.project.data.DataRepository
import com.cobamvvm.project.data.model.FoodResponseItem
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository):AbstractVIewModel() {

    val confirmedResponseDetail = MutableLiveData<List<FoodResponseItem>>()

    fun getConfirmedList(){
        launch {
            try {
                setLoading()

                val dataConfirmed = repository.getFoodData()
                confirmedResponseDetail.postValue(dataConfirmed)

            }catch (t:Throwable){
                println("ERROR COROUTINE "+t.message)

                setError(t)
            }finally {
                setLoading(false)
            }
        }
    }

    fun start(){
        confirmedResponseDetail.value = emptyList()
    }
}