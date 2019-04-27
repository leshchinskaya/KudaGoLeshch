package com.example.mariya.kudagoleshch.presenter.City

import android.content.Context
import com.example.mariya.kudagoleshch.view.City.CitiesView
import com.example.mariya.kudagoleshch.network.KudaGoBaseApiRepository

class CitiesRepository: CitiesView.Repository {
    override fun loadCities(context: Context, onSuccess: (CitiesResponse) -> Unit, onError: (Throwable) -> Unit) {
        KudaGoBaseApiRepository(context).loadCities(onSuccess = {
            onSuccess(it)
        }, onError = {
            onError(it)
        })
    }
}