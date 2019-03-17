package com.example.mariya.kudagoleshch

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ArrayAdapter
import com.example.mariya.kudagoleshch.abstracts.entity.Event
import com.example.mariya.kudagoleshch.adapters.EventAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences
    lateinit var nameOfCurrentCity: String
    var events: ArrayList<Event> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameOfCurrentCity = "Москва"

        if (savedInstanceState == null || !!savedInstanceState.containsKey("nameOfCurrentCity")) {
            getSavedLastSelectedCity()
        } else {
            textCity.text = savedInstanceState.getSerializable("nameOfCurrentCity").toString()
        }

        addEvents()
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = EventAdapter(events)


        textCity.setOnClickListener { onClickCityButton() }
        button_choiceCity.setOnClickListener { onClickCityButton() }
    }

    fun addEvents(){
        events.add(Event("МУЗЫКАЛЬНЫЙ ФЕСТИВАЛЬ LIVEFEST SUMMER", "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...", "ЦПКиО им. Горького", "10-11 августа", "1200-1500"))
        events.add(Event("Cобытие2", "Описание2", "Место2", "Даты2", "Цена2"))
    }

    private fun getSavedLastSelectedCity() {
        pref = getSharedPreferences("settings", Context.MODE_PRIVATE)

        if (pref.contains("nameOfCurrentCity")) {
                nameOfCurrentCity = pref.getString("nameOfCurrentCity", "Москва")
                } else {
                        nameOfCurrentCity = "Москва"
        }
        
        textCity.text = nameOfCurrentCity
    }
    

    private fun onClickCityButton() {
        //val intentSelectCity = Intent(this, CityActivity::class.java)
        //startActivity(intentSelectCity)
        val intentSelectCity = Intent(this, CityActivity::class.java)
        intentSelectCity.putExtra("currentCity", nameOfCurrentCity)
    }
}
