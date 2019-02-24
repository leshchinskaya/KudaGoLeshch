package com.example.mariya.kudagoleshch.abstracts.presenter

import com.example.mariya.kudagoleshch.abstracts.view.BaseView

interface BasePresenter<V: BaseView> {
    var isAttached: Boolean
    fun attach(view: V)
    fun detach()
}