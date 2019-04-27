package com.example.mariya.kudagoleshch.presenter

class BaseRepository: BaseInterface.Repository {
    override fun loadLastEvents(): String {
        return "Hello to mvp from repository"
    }
}