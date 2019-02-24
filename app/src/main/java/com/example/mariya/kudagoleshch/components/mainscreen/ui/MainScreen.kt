package com.example.mariya.kudagoleshch.components.mainscreen.ui

import android.os.Bundle
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.components.mainscreen.backstage.MainScreenContract
import com.example.mariya.kudagoleshch.abstracts.presenter.MainScreenPresenter
import com.example.mariya.kudagoleshch.abstracts.view.BaseCompatActivity

class MainScreen : BaseCompatActivity(), MainScreenContract.View {
    val presenter: MainScreenPresenter? = MainScreenPresenter()
    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        presenter?.attach(this)
    }
}