package com.example.mariya.kudagoleshch.view

import android.os.Bundle
import com.example.mariya.kudagoleshch.presenter.BasePresenter

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