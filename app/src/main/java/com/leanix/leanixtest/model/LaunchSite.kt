package com.leanix.leanixtest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchSite(
    val site_name: String
):Parcelable