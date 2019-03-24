package com.example.mariya.kudagoleshch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.abstracts.entity.City
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.city.view.*
import kotlinx.android.synthetic.main.toolbar.view.*

class CityAdapter(private val items: ArrayList<City>, val callback: (City)-> Unit, val nameCurrent: String) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    val selectedCity = City

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityAdapter.CityViewHolder {
        return CityAdapter.CityViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.city, p0, false))
    }

    override fun onBindViewHolder(p0: CityViewHolder, p1: Int) {
        val item = items[p1]

        p0.cityName.text = item.nameInfo
        if (p0.cityName.text==nameCurrent ) { p0.imageCheck.visibility = View.VISIBLE}
        p0.container.setOnClickListener { callback(item)}
    }

    class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityName = view.text_city
        val container = view
        val imageCheck = view.image_check
    }
}