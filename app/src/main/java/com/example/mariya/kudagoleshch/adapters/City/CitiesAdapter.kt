package com.example.mariya.kudagoleshch.adapters.City

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.CityModel

class CitiesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var mCitiesSourceList: ArrayList<CityModel> = ArrayList()
    lateinit var lastChoosedCityModel: CityModel
    private var mListener: OnCitiesClick? = null

    constructor(listener: OnCitiesClick):super() {
        this.mListener = listener
        mCitiesSourceList.clear()
    }

    fun showCities(cities: ArrayList<CityModel>) {
        mCitiesSourceList.clear()
        mCitiesSourceList.addAll(cities)
        notifyDataSetChanged()
    }

    fun setNewSelectedCity(cityModel: CityModel) {
        lastChoosedCityModel = cityModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.city, p0, false)
        return CitiesViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mCitiesSourceList.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is CitiesViewHolder) {
            p0.bind(mCitiesSourceList[p1])
            if (mCitiesSourceList[p1].name == lastChoosedCityModel.name) {
                mListener?.let {
                    it.markViewAsAdded(p0.itemView)
                }
            } else {
                mListener?.let {
                    it.markViewAsRegular(p0.itemView)
                }
            }
            p0.itemView.setOnClickListener {
                mListener?.let { listener ->
                    listener.onCityClicked(it, mCitiesSourceList[p1])
                }
            }
        }
    }

    interface OnCitiesClick {
        fun onCityClicked(itemView: View, cityModel: CityModel)
        fun markViewAsAdded(itemView: View)
        fun markViewAsRegular(itemView: View)
    }

    class CitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var mName: TextView = itemView.findViewById(R.id.text_city)
        private var mMark: ImageView = itemView.findViewById(R.id.image_check)

        fun bind(cityModel: CityModel) {
            mName.text = cityModel.name
        }
    }

}