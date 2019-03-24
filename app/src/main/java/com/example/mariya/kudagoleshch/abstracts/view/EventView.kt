package com.example.mariya.kudagoleshch.abstracts.view

import com.example.mariya.kudagoleshch.abstracts.entity.Event

interface EventView {
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
}