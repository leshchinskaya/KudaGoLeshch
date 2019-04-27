package com.example.mariya.kudagoleshch.adapters.Event

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.entity.Event
import kotlinx.android.synthetic.main.activity_eventcard.view.*
import kotlinx.android.synthetic.main.textview_info.view.*

class EventAdapter (private val items: ArrayList<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.activity_eventcard, p0, false))
    }

    override fun onBindViewHolder(p0: EventViewHolder, p1: Int) {
        val item = items[p1]

        p0.eventName.text = item.titleInfo
        p0.eventDescription.text = item.descriptionInfo
        p0.eventPlace.text = item.placeInfo
        p0.eventDates.text = item.datesInfo
        p0.eventPrice.text = item.priceInfo

    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventName = view.eventTitle
        val eventDescription = view.eventDescription
        val eventPlace = view.description
        val eventDates = view.description2
        val eventPrice = view.description3

    }
}