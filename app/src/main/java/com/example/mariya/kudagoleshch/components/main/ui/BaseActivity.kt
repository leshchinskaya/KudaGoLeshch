package com.example.mariya.kudagoleshch.components.main.ui

import android.os.Bundle
import com.example.mariya.kudagoleshch.abstracts.presenter.BasePresenter
import com.example.mariya.kudagoleshch.abstracts.view.BaseCompatActivity
import com.example.mariya.kudagoleshch.abstracts.view.BaseView

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : BaseCompatActivity() {
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attach(this as V)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}