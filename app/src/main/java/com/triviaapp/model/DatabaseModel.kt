package com.triviaapp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.util.*

class DatabaseModel() :Serializable {

    var name:String?=null
    var answer1:String?=null
    var answer2:String?=null
    var date: String?=null
    var time:String?=null



}