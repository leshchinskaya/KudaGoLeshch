package com.example.mariya.kudagoleshch.view.City

import android.content.Context
import com.example.mariya.kudagoleshch.model.CityModel
import com.example.mariya.kudagoleshch.presenter.City.CitiesResponse
import com.example.mariya.kudagoleshch.components.SwipeToRefreshInterface

class CitiesView {
    interface View: SwipeToRefreshInterface {
        fun showCities(citiesArray: ArrayList<CityModel>)
    }

    interface Presenter {
        fun loadCities(context: Context)
        fun onDestroy()
    }

    interface Repository {
        fun loadCities(context: Context, onSuccess: (CitiesResponse) -> Unit, onError: (Throwable) -> Unit)
    }
}