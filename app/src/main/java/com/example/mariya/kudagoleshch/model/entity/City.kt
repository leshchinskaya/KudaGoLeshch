package com.example.mariya.kudagoleshch.model.entity

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class City(private var cityName : String): Parcelable, Serializable {

    constructor(parcel: Parcel) : this(
            parcel.readString()
    ) {
        cityName = parcel.readString()
    }

    val nameInfo: String
        get() = cityName

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        if (dest != null) {
            dest.writeValue(cityName)
        }
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }

}