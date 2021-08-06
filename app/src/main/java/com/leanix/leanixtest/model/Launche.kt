package com.leanix.leanixtest.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Launche(
    val details: String,
    val launch_date_local: String,
    val launch_site: LaunchSite,
    val launch_success: Boolean,
    val links: Links,
    val mission_name: String,
    val rocket: Rocket
) : Parcelable