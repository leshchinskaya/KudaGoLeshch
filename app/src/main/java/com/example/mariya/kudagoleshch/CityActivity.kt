package com.example.mariya.kudagoleshch

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.mariya.kudagoleshch.abstracts.entity.City
import android.support.v7.widget.LinearLayoutManager
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.adapters.CityAdapter
import kotlinx.android.synthetic.main.activity_city.*
import kotlinx.android.synthetic.main.city.*
import kotlinx.android.synthetic.main.citytoolbar.*
import kotlinx.android.synthetic.main.toolbar.*

class CityActivity: AppCompatActivity() {
    var cities: ArrayList<City> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        addCities()
        city.layoutManager = LinearLayoutManager(this)
        city.adapter = CityAdapter(cities)


        if (savedInstanceState != null && savedInstanceState.containsKey("cities")) {
            cities = savedInstanceState.getParcelableArrayList("cities")
        }

        ib_close.setOnClickListener { finish() }
        tv_select.setOnClickListener { onClickCity() }
        city.setOnClickListener { onClickCity() }
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if (outState != null) {
            outState.clear()
            outState.putParcelableArrayList("cities", cities)
            //initRecyclerView()
        }
    }

    fun onClickCross(v : View){
        onBackPressed()
    }

    fun onClickCityS () {
        onBackPressed()
    }

    private fun onClickCity () {
        //val intentSelectCity = Intent(this, MainActivity::class.java)
        //intentSelectCity.putExtra("currentCity", "Воронеж")
        //startActivityForResult(intentSelectCity, 100)
        //onBackPressed()
    }
}