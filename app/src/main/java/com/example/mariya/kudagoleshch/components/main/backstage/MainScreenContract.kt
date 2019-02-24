package com.example.mariya.kudagoleshch.components.main.backstage

import com.example.mariya.kudagoleshch.abstracts.presenter.BasePresenter
import com.example.mariya.kudagoleshch.abstracts.view.BaseView

interface MainScreenContract {
    interface Presenter: BasePresenter<View>
    interface View: BaseView
}