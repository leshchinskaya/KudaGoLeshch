package com.example.mariya.kudagoleshch.abstracts.entity

import android.media.Image
import java.io.Serializable
import java.time.LocalDate

class Event(
        private val title: String,
        private val description: String,
        private val place: String,
        private val dates: String,
        private val price: String
        //private val imageURL: String
): Serializable {

    val titleInfo: String
        get() = title

    val descriptionInfo: String
        get() = description

    val placeInfo: String
        get() = place

    val datesInfo: String
        get() = dates

    val priceInfo: String
        get() = price

    /*
    val imageURLInfo: String
        get() = imageURL
        */
}