package com.example.mariya.kudagoleshch.presenter.Events

import android.content.Context
import com.example.mariya.kudagoleshch.view.Events.EventsView

class EventsPresenter: EventsView.Presenter {

    private lateinit var mView: EventsView.View
    private lateinit var mRepository: EventsView.Repository

    constructor(view: EventsView.View) {
        this.mView = view
        this.mRepository = EventsRepository()
    }

    override fun loadLastEvents(context: Context, city: String, pageCount: Int) {
        mView.startLoading()
        mRepository.loadLastEvents(context, city, pageCount,
                onSuccess = {
                    mView.showLastEvents(it)
                    mView.endLoading()
                },
                onError = {
                    //Todo add error message
                    mView.endLoading()
                })
    }


    override fun onDestroy() {

    }
}