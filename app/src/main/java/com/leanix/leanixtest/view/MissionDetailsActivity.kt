package com.leanix.leanixtest.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.leanix.leanixtest.R
import com.leanix.leanixtest.databinding.ActivityMissiondetailsBinding
import com.leanix.leanixtest.model.Launche
import com.leanix.leanixtest.utils.Utils

class MissionDetailsActivity : AppCompatActivity() {

    private lateinit var missionDetailsBinding: ActivityMissiondetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        missionDetailsBinding = ActivityMissiondetailsBinding.inflate(layoutInflater)
        setContentView(missionDetailsBinding.root)

        val data = intent.getParcelableExtra("item") as? Launche

        data?.let { getData(it) }
    }

    @SuppressLint("SetTextI18n")
    private fun getData(data: Launche) {
        missionDetailsBinding.tvMission.text = data.mission_name
        missionDetailsBinding.ivImage.let {
            Glide.with(this)
                .load(data.links.mission_patch)
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .into(it)
        }

        when (data.launch_success) {
            true -> {
                missionDetailsBinding.tvMissionSuccess.text = resources.getString(R.string.success)
                missionDetailsBinding.tvMissionSuccess.setTextColor(resources.getColor(R.color.green))
            }
            else -> {
                missionDetailsBinding.tvMissionSuccess.text = resources.getString(R.string.fail)
                missionDetailsBinding.tvMissionSuccess.setTextColor(resources.getColor(R.color.red))
            }
        }
        missionDetailsBinding.tvRocketname.text =  resources.getString(R.string.rocketname) +" : "+data.rocket.rocket_name
        missionDetailsBinding.tvLaunchsitename.text = data.launch_site.site_name
        missionDetailsBinding.tvLaunchdate.text = resources.getString(R.string.launchDate)+" : "+Utils.missionLaunchDate(data.launch_date_local)
        missionDetailsBinding.tvLaunchdescription.text = data.details
    }
}