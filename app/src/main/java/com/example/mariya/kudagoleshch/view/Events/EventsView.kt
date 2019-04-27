package com.example.mariya.kudagoleshch.view.Events

import android.content.Context
import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.components.SwipeToRefreshInterface

interface EventsView {
    interface View: SwipeToRefreshInterface {
        fun showLastEvents(eventsList: ArrayList<EventModel>)
    }

    interface Presenter {
        fun loadLastEvents(context: Context, city: String, pageCount: Int)
        fun onDestroy()
    }

    interface Repository {
        fun loadLastEvents(context: Context, city: String, pageCount: Int, onSuccess: (ArrayList<EventModel>) -> Unit, onError: (Throwable) -> Unit)
    }
}