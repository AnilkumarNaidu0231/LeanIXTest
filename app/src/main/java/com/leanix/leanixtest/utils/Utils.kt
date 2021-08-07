package com.leanix.leanixtest.utils

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object{
        fun missionLaunchDate(cDate:String):String{
            val inputPattern = "yyyy-MM-dd'T'HH:mm:ss"
            val outputPattern = "dd MMM yyyy"
            val inputFormat = SimpleDateFormat(inputPattern, Locale.ENGLISH)
            val outputFormat = SimpleDateFormat(outputPattern,Locale.ENGLISH)
            val date: Date?
            var str: String? = null
            try {
                date = inputFormat.parse(cDate)
                str = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str!!
        }
    }
}