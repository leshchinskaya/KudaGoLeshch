package com.example.mariya.kudagoleshch.abstracts.presenter

interface BaseInterface {
    interface View {
        fun showLastEvents(string: String)
    }

    interface Presenter {
        fun onButtonWasClicked()
        fun onDestroy()
    }

    interface Repository {
        fun loadLastEvents():String
    }
}