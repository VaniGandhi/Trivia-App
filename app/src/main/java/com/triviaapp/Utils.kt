package com

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.triviaapp.R
import java.text.SimpleDateFormat
import java.util.*

private const val HOURS_12 = "hh:mm a"
const val CAL_DATE_FORMAT = "dd MMM"


var TimeFormat12 = SimpleDateFormat(HOURS_12, Locale.getDefault())
var dateFormat = SimpleDateFormat(CAL_DATE_FORMAT, Locale.getDefault())


fun Context?.isInternetConnected() : Boolean{
    val mManager = (this?.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager)
    val networkInfo = mManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

fun Context?.showToast(message: String, length: Int){
    Toast.makeText(this, message, length).show()
}

fun Context.showInternetOff(){
    this.showToast(this.getString(R.string.unable_to_connect_to_internet), Toast.LENGTH_LONG)
}
fun getTime(date: Date?): String? {
    return TimeFormat12.format(date)
}

fun getDate(date: Date?): String? {
    return dateFormat.format(date)
}
