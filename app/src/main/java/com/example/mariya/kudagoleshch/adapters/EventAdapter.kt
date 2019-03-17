package com.example.mariya.kudagoleshch.adapters

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.abstracts.entity.Event

class EventAdapter (private val items: ArrayList<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventAdapter.EventViewHolder {
        return EventAdapter.EventViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.activity_eventcard, p0, false))
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
        var eventName: AppCompatTextView
        var eventDescription: AppCompatTextView
        var eventPlace: AppCompatTextView
        var eventDates: AppCompatTextView
        var eventPrice: AppCompatTextView

        init {
            super.itemView
            eventName = itemView.findViewById(R.id.eventTitle) as AppCompatTextView
            eventDescription = itemView.findViewById(R.id.eventDescription) as AppCompatTextView
            eventPlace = itemView.findViewById(R.id.description) as AppCompatTextView
            eventDates = itemView.findViewById(R.id.description2) as AppCompatTextView
            eventPrice = itemView.findViewById(R.id.description3) as AppCompatTextView

        }
    }
}