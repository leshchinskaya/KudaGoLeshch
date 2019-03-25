package com.example.mariya.kudagoleshch.abstracts.presenter

import android.view.View
import com.example.mariya.kudagoleshch.abstracts.entity.Event
import com.example.mariya.kudagoleshch.abstracts.view.EventRepository
import com.example.mariya.kudagoleshch.abstracts.view.EventView

class EventPresenterClass {
    private lateinit var mView: EventView.View
    private lateinit var mRepository: EventView.Repository

    constructor(view: EventView.View) {
        this.mView = view
        this.mRepository = EventRepository()
    }
}