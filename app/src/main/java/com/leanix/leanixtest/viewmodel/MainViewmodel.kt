package com.leanix.leanixtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leanix.leanixtest.model.Launche
import com.leanix.leanixtest.model.OutputResponse
import com.leanix.leanixtest.network.RetrofitInstance
import kotlinx.coroutines.*
import org.json.JSONObject
import retrofit2.Response
import java.io.Serializable

class MainViewmodel : ViewModel() {

    val retrofit = RetrofitInstance.connectionApi


    var missionDetails: MutableLiveData<Response<OutputResponse>>? = null


    init {
        missionDetails = MutableLiveData();
    }

    fun  getDetails(input:String,scope: CoroutineScope){
        val paramObject = JSONObject()
        paramObject.put(
            "query",input
        )
        scope.launch  {
            try {
                withContext(Dispatchers.IO){
                     missionDetails?.postValue(retrofit.getMissionList(paramObject.toString()))
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }


}