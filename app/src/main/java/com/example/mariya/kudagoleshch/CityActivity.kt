package com.example.mariya.kudagoleshch

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.mariya.kudagoleshch.abstracts.entity.City
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.adapters.CityAdapter
import kotlinx.android.synthetic.main.activity_city.*
import kotlinx.android.synthetic.main.city.*
import kotlinx.android.synthetic.main.citytoolbar.*
import kotlinx.android.synthetic.main.toolbar.*

class CityActivity: AppCompatActivity() {
    var cities: ArrayList<City> = ArrayList()
    lateinit var nameOfCurrentCity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        //String count = getIntent().getIntExtra("currentCity", nameOfCurrentCity);
        nameOfCurrentCity = getIntent().getStringExtra("currentCity");

        /*
        if (intent != null) {
            nameOfCurrentCity = intent.action
        }
        */

        addCities()
        city.layoutManager = LinearLayoutManager(this)
        city.adapter = CityAdapter(cities, onClickCity, nameOfCurrentCity)


        if (savedInstanceState != null && savedInstanceState.containsKey("cities")) {
            cities = savedInstanceState.getParcelableArrayList("cities")
        }

        ib_close.setOnClickListener { finish() }
    }

    fun addCities(){
        cities.add(City("Москва"))
        cities.add(City("Санкт-Петербург"))
        cities.add(City("Казань"))
        cities.add(City("Новосибирск"))
        cities.add(City("Екатеринбург"))
        cities.add(City("Нижний Новгород"))
        cities.add(City("Самара"))
        cities.add(City("Уфа"))
        cities.add(City("Красноярск"))
    }

    /*
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if (outState != null) {
            outState.clear()
            outState.putParcelableArrayList("cities", cities)
            //initRecyclerView()
        }
    }
    */

    fun onClickCross(v : View){
        onBackPressed()
    }

    private val onClickCity = fun(city: City) : Unit {
        val intentSelectCity = Intent()
        intentSelectCity.putExtra("selectedCity", city.nameInfo)
        setResult(Activity.RESULT_OK, intentSelectCity)
        onBackPressed()
    }
}