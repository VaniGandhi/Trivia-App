package com.triviaapp.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Data")

class Model(
    val name: String,
    val answer1: String,
    val answer2: String,
    val date:String,
    val time:String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}