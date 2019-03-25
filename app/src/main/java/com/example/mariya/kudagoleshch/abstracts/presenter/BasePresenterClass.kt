package com.example.mariya.kudagoleshch.abstracts.presenter

import com.example.mariya.kudagoleshch.abstracts.view.BaseView

open class BasePresenterClass: BaseInterface.Presenter {
    private lateinit var mView: BaseInterface.View
    private lateinit var mRepository: BaseInterface.Repository

    constructor(view: BaseInterface.View) {
        this.mView = view
        this.mRepository = BaseRepository()
    }

    override fun onButtonWasClicked() {
        val message: String = mRepository.loadLastEvents()
        mView.showLastEvents(message)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}