package com.example.mariya.kudagoleshch.view.City

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.CityModel
import com.example.mariya.kudagoleshch.presenter.City.CitiesPresenter
import com.example.mariya.kudagoleshch.adapters.City.CitiesAdapter
import com.example.mariya.kudagoleshch.components.SwipeToRefreshInterface
import kotlinx.android.synthetic.main.toolbar.*

class ChooseCityActivity : AppCompatActivity(), CitiesView.View, CitiesAdapter.OnCitiesClick, SwipeToRefreshInterface {

    private lateinit var mRvCities: RecyclerView
    private lateinit var mRvAdapter: CitiesAdapter
    lateinit var mPresenter: CitiesPresenter
    private lateinit var mCloseButton: ImageView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")

        mPresenter = CitiesPresenter(this)
        mRvAdapter = CitiesAdapter(this)
        val cityModelFromIntent = intent.getSerializableExtra("city")
        mRvAdapter.setNewSelectedCity(cityModelFromIntent as CityModel)

        mRvCities = findViewById(R.id.city)
        mRvCities.adapter = mRvAdapter
        mRvCities.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvCities.setHasFixedSize(true)

        mPresenter.loadCities(this)
        mCloseButton = findViewById(R.id.ib_close)
        mCloseButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("city", mRvAdapter.lastChoosedCityModel)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        mSwipeRefreshLayout = findViewById(R.id.city_swipe_refresh)

        mSwipeRefreshLayout.setOnRefreshListener {
            mPresenter.loadCities(this)
        }
    }


    override fun showCities(citiesArray: ArrayList<CityModel>) {
        mRvAdapter.showCities(citiesArray)
    }

    override fun onCityClicked(itemView: View, cityModel: CityModel) {
        val mark = itemView.findViewById<ImageView>(R.id.image_check)
        mRvAdapter.setNewSelectedCity(cityModel)
    }

    override fun markViewAsAdded(itemView: View) {
        val mark = itemView.findViewById<ImageView>(R.id.image_check)
        mark.visibility = View.VISIBLE
    }

    override fun markViewAsRegular(itemView: View) {
        val mark = itemView.findViewById<ImageView>(R.id.image_check)
        mark.visibility = View.INVISIBLE
    }

    //MARK: - swipe to refresh interface implementation

    override fun startLoading() {
        mRvCities.visibility = View.INVISIBLE
    }

    override fun endLoading() {
        mRvCities.visibility = View.VISIBLE
        mSwipeRefreshLayout.isRefreshing = false
    }
}
