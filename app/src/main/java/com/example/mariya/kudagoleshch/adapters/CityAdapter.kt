package com.example.mariya.kudagoleshch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.abstracts.entity.City
import kotlinx.android.synthetic.main.activity_main.*

class CityAdapter(private val items: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityAdapter.CityViewHolder {
        return CityAdapter.CityViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.city, p0, false))
    }

    override fun onBindViewHolder(p0: CityViewHolder, p1: Int) {
        val item = items[p1]

        p0.cityName.text = item.nameInfo
    }

    class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cityName: TextView

        init {
            super.itemView
            cityName = itemView.findViewById(R.id.text_city) as TextView
        }
    }
}