package com.example.mariya.kudagoleshch.view.Event

import com.example.mariya.kudagoleshch.model.EventModel

interface EventView {
    interface View {
        fun showEvent(eventModel: EventModel)
    }

    interface Presenter {
        fun showEvent(eventModel: EventModel)
    }

    /*
    interface View {
        fun showLastEvents(eventsList: ArrayList<Event>)
    }

    interface Presenter {
        fun loadLastEvents()
        fun onDestroy()
    }

    interface Repository {
        fun loadLastEvents():ArrayList<Event>
    }
    */
}