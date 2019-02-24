package com.example.mariya.kudagoleshch.components.main.ui

import android.os.Bundle
import com.example.mariya.kudagoleshch.abstracts.presenter.BasePresenter
import com.example.mariya.kudagoleshch.abstracts.view.BaseCompatActivity
import com.example.mariya.kudagoleshch.abstracts.view.BaseView

annotation class Inject
abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : BaseCompatActivity() {
    @Inject
    lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpPresenter.attach(this as V)
    }

    override fun onDestroy() {
        mvpPresenter.detach()
        super.onDestroy()
    }
}