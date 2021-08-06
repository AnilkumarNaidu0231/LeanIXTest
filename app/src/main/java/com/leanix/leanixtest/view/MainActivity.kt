package com.leanix.leanixtest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.leanix.leanixtest.R
import com.leanix.leanixtest.databinding.ActivityMainBinding
import com.leanix.leanixtest.model.Launche
import com.leanix.leanixtest.view.adapter.MissionAdapter
import com.leanix.leanixtest.viewmodel.MainViewmodel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), MissionAdapter.OnClick {
    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    private lateinit var mainViewModel: MainViewmodel

    private lateinit var missionAdapter: MissionAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewmodel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.rvMission.layoutManager = layoutManager
        binding.rvMission.itemAnimator = DefaultItemAnimator()


        missionList()
    }


    private fun missionList() {

        mainViewModel.getDetails(resources.getString(R.string.input_query), scope)
        mainViewModel.missionDetails?.observe(this, {
            Log.e("response", Gson().toJson(it.body()?.data))
            val list = it.body()?.data?.launches
            missionAdapter = MissionAdapter(list)
            binding.rvMission.adapter = missionAdapter
            missionAdapter.setOnitemClickListener(this)
            missionAdapter.notifyDataSetChanged()
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun getItemPosition(launche: Launche) {

        val intent = Intent(this, MissionDetailsActivity::class.java)
        intent.putExtra("item", launche)
        startActivity(intent)
    }
}