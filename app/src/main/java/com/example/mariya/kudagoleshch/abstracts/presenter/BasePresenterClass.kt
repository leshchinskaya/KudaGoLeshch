package com.example.mariya.kudagoleshch.abstracts.presenter

import com.example.mariya.kudagoleshch.abstracts.view.BaseView

open class BasePresenterClass<V : BaseView> : BasePresenter<V> {
    protected var view: V? = null
        private set

    override var isAttached = view != null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}