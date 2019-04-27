package com.example.mariya.kudagoleshch.view.Events

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.mariya.kudagoleshch.view.City.ChooseCityActivity
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.CityModel
import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.presenter.Events.EventsPresenter
import com.example.mariya.kudagoleshch.adapters.Event.EventsAdapter
import com.example.mariya.kudagoleshch.view.Event.EventActivity
import kotlinx.android.synthetic.main.toolbar.*

class EventsActivity : AppCompatActivity(), EventsView.View, EventsAdapter.OnEventClick {
    private lateinit var mRvEvents: RecyclerView
    private lateinit var mRvAdapter: EventsAdapter
    lateinit var mPresenter: EventsPresenter
    private var choosenCity: CityModel = CityModel("msk", "Москва")
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPresenter = EventsPresenter(this)
        mRvAdapter = EventsAdapter(listener = this)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")
        val mChooseCityBtn: TextView = findViewById(R.id.textCity)
        mChooseCityBtn.setOnClickListener {
            val intent = Intent(this, ChooseCityActivity::class.java)
            intent.putExtra("city", choosenCity)
            startActivityForResult(intent, 1)
        }
        mRvEvents = findViewById(R.id.eventsRecyclerView)

        mRvEvents.adapter = mRvAdapter
        mRvEvents.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvEvents.setHasFixedSize(true)
        mSwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        mPresenter.loadLastEvents(this, choosenCity.slug, 1)

        mSwipeRefreshLayout.setOnRefreshListener {
            mPresenter.loadLastEvents(this, choosenCity.slug, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val newCity = data!!.getSerializableExtra("city")
                if (choosenCity.slug != (newCity as CityModel).slug) {
                    mPresenter.loadLastEvents(this, newCity.slug, 1)
                }
                choosenCity = newCity as CityModel
                val btn: TextView = findViewById(R.id.textCity)
                btn.text = choosenCity.name
            }
        }
    }

    override fun showLastEvents(eventsList: ArrayList<EventModel>) {
        mRvAdapter.showLastEvents(eventsList)
    }


    override fun onEventClicked(eventModel: EventModel) {
        val intent = Intent(this, EventActivity::class.java)
        intent.putExtra("eventModel", eventModel)
        startActivityForResult(intent, 1)
    }


    override fun startLoading() {
        mSwipeRefreshLayout.isRefreshing = true
        mRvEvents.visibility = View.INVISIBLE
    }

    override fun endLoading() {
        mSwipeRefreshLayout.isRefreshing = false
        mRvEvents.visibility = View.VISIBLE
    }
}