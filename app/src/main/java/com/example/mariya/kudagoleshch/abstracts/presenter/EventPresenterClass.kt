package com.example.mariya.kudagoleshch.abstracts.presenter

import android.view.View
import com.example.mariya.kudagoleshch.abstracts.entity.Event
import com.example.mariya.kudagoleshch.abstracts.view.EventView

class EventPresenterClass {
    private lateinit var mView: EventView.View

    constructor(view: EventView.View) {
        this.mView = view
    }

    var events: ArrayList<Event> = ArrayList()

    fun addEvents(){
        events.add(Event("МУЗЫКАЛЬНЫЙ ФЕСТИВАЛЬ LIVEFEST SUMMER", "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...", "ЦПКиО им. Горького", "10-11 августа", "1200-1500 Р"))
        events.add(Event("Рестобар «Чеширский кот»", "Из центра Москвы — прямиком в Зазеркалье! В рестобаре вас встретят улыбчивый кот и д...", "ул. Кузнецкий Мост, д. 19/1", "-", "2 500 Р"))
    }
}