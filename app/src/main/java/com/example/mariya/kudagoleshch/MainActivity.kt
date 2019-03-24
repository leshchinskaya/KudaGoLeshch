package com.example.mariya.kudagoleshch

import android.app.Activity
import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mariya.kudagoleshch.abstracts.entity.Event
import com.example.mariya.kudagoleshch.abstracts.presenter.EventPresenterClass
import com.example.mariya.kudagoleshch.adapters.EventAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.city.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences
    lateinit var nameOfCurrentCity: String
    private val REQUEST_CODE_MESSAGE = 1000
    private lateinit var mPresenter: EventPresenterClass
    private lateinit var mAdapter: EventAdapter
    var events: ArrayList<Event> = ArrayList()

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        /*
        if (outState != null) {
            outState.clear()
            outState.putSerializable("nameOfCurrentCity", nameOfCurrentCity)
        }
        */
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_MESSAGE -> {
                    if (data != null) {
                        var cityNew = data.getStringExtra("selectedCity")
                        //nameOfCurrentCity = data.getStringExtra("selectedCity")
                        text_city.text = cityNew
                        //events = ArrayList()
                    }
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // nameOfCurrentCity = "Москва"

        if (savedInstanceState == null || !!savedInstanceState.containsKey("nameOfCurrentCity")) {
            getSavedLastSelectedCity()
        } else {
            textCity.text = savedInstanceState.getSerializable("nameOfCurrentCity").toString()
           // nameOfCurrentCity = getIntent().getStringExtra("selectedCity");
        }

        // mPresenter.addEvents()
        addEvents()
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = EventAdapter(events)


        textCity.setOnClickListener { onClickCityButton() }
        button_choiceCity.setOnClickListener { onClickCityButton() }
    }


    fun addEvents(){
        events.add(Event("МУЗЫКАЛЬНЫЙ ФЕСТИВАЛЬ LIVEFEST SUMMER", "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...", "ЦПКиО им. Горького", "10-11 августа", "1200-1500 Р"))
        events.add(Event("Рестобар «Чеширский кот»", "Из центра Москвы — прямиком в Зазеркалье! В рестобаре вас встретят улыбчивый кот и д...", "ул. Кузнецкий Мост, д. 19/1", "-", "2 500 Р"))
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
        val intentSelectCity = Intent(this, CityActivity::class.java)
        intentSelectCity.putExtra("currentCity", nameOfCurrentCity)
        startActivityForResult(intentSelectCity, REQUEST_CODE_MESSAGE)
    }
}
