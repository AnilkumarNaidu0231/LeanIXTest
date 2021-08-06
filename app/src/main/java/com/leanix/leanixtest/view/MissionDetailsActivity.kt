package com.leanix.leanixtest.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.leanix.leanixtest.databinding.ActivityMissiondetailsBinding
import com.leanix.leanixtest.model.Launche
import com.leanix.leanixtest.viewmodel.MainViewmodel

class MissionDetailsActivity : AppCompatActivity() {

    lateinit var missionDetailsBinding: ActivityMissiondetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        missionDetailsBinding = ActivityMissiondetailsBinding.inflate(layoutInflater)
        setContentView(missionDetailsBinding.root)

       val data= intent.getSerializableExtra("item") as? Launche

        data?.let { getData(it) }
    }

    fun getData(data:Launche) {
      Log.d("DATA",""+Gson().toJson(data))
    }
}