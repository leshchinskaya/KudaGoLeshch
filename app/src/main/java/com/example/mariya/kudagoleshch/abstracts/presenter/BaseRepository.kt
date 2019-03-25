package com.example.mariya.kudagoleshch.abstracts.presenter

class BaseRepository: BaseInterface.Repository {
    override fun loadLastEvents(): String {
        return "Hello to mvp from repository"
    }
}