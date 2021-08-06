package com.leanix.leanixtest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rocket(
    val rocket_name: String
):Parcelable