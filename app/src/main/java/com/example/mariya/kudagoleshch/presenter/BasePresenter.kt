package com.example.mariya.kudagoleshch.presenter

import com.example.mariya.kudagoleshch.view.BaseView

interface BasePresenter<V: BaseView> {
    var isAttached: Boolean
    fun attach(view: V)
    fun detach()
}