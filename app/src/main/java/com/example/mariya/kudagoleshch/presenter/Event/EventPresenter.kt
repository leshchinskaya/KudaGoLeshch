package com.example.mariya.kudagoleshch.presenter.Event

import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.view.Event.EventView
/*
interface EventPresenter: BasePresenter<EventView> {
    //fun addEvents()
}
        */

class EventPresenter: EventView.Presenter {
    private lateinit var mView: EventView.View

    constructor(view: EventView.View) {
        this.mView = view
    }

    override fun showEvent(eventModel: EventModel) {
        mView.showEvent(eventModel)
    }


    fun onDestroy() {

    }
}