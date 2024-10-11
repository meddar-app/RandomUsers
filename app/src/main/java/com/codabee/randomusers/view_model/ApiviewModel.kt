package com.codabee.randomusers.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codabee.randomusers.model.ApiResults
import com.codabee.randomusers.service.ApiManager
import com.google.gson.Gson
import kotlinx.coroutines.launch


class ApiviewModel: ViewModel() {
    private val _state = MutableLiveData<ApiResults>()
    val state: LiveData<ApiResults>
        get() = _state
    fun launchApi(){
        viewModelScope.launch {
            _state.value = ApiResults(results = listOf())
            try {
                val result = ApiManager.Service.getRandonUser()
                println(result)
                //convert the json result to a kotlin object (result.json > DataUser)
                val gson = Gson()
                val data = gson.fromJson(result, ApiResults::class.java)
                _state.value = data
                println("HERE THE SIZE OF THE DATA ${data.results.size}")

            }catch (e:Exception){
                println(e.message?:"Erreur inconnue")
            }


        }

    }
}