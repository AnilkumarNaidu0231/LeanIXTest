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
import com.leanix.leanixtest.utils.BottomSheetDialog
import com.leanix.leanixtest.view.adapter.MissionAdapter
import com.leanix.leanixtest.viewmodel.MainViewmodel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), MissionAdapter.OnClick, BottomSheetDialog.OnClick {
    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    private lateinit var mainViewModel: MainViewmodel

    private lateinit var missionAdapter: MissionAdapter
    private lateinit var binding: ActivityMainBinding

    lateinit var list: List<Launche>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewmodel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.rvMission.layoutManager = layoutManager
        binding.rvMission.itemAnimator = DefaultItemAnimator()

        binding.ivSortby.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog

            bottomSheetDialog.createBottomSheet(layoutInflater, this)
            bottomSheetDialog.onClickSort(this)
        }

        missionList()
    }


    private fun missionList() {

        mainViewModel.getDetails(resources.getString(R.string.input_query), scope)
        mainViewModel.missionDetails?.observe(this, {
            list = it.body()?.data?.launches!!
            missionAdapter = MissionAdapter(list)
            binding.rvMission.adapter = missionAdapter
            missionAdapter.setOnitemClickListener(this)

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

    override fun setOnClick(type: Int) {
        when (type) {
            1 -> {
                missionAdapter = MissionAdapter(list.sortedBy { it.mission_name })
                binding.rvMission.adapter = missionAdapter
                missionAdapter.setOnitemClickListener(this)
            }
            2 -> {
                missionAdapter = MissionAdapter(list.sortedBy { it.launch_date_local })
                binding.rvMission.adapter = missionAdapter
                missionAdapter.setOnitemClickListener(this)
            }
            else -> {
                missionAdapter = MissionAdapter(list)
                binding.rvMission.adapter = missionAdapter
                missionAdapter.setOnitemClickListener(this)
            }
        }
    }
}