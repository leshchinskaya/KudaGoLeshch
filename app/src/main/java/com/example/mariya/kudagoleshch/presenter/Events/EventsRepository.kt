package com.example.mariya.kudagoleshch.presenter.Events

import android.content.Context
import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.network.KudaGoBaseApiRepository
import com.example.mariya.kudagoleshch.view.Events.EventsView

class EventsRepository: EventsView.Repository {

    override fun loadLastEvents(context: Context, city: String, pageCount: Int, onSuccess: (ArrayList<EventModel>) -> Unit, onError: (Throwable) -> Unit) {
        KudaGoBaseApiRepository(context).loadEvents(city, pageCount,
                onSuccess = {
                    var events: ArrayList<EventModel> = ArrayList()
                    it.results.forEach { eventResult ->
                        var date: String
                        eventResult.dates?.first()?.start_date.let {
                            date = it
                        }
                        var place: String
                        eventResult.place?.address.let {
                            place = it
                        }
                        var price: String
                        eventResult.price.let {
                            price = it
                        }
                        var images: ArrayList<String> = ArrayList()
                        eventResult.images.forEach { imageSource ->
                            images.add(imageSource.image)
                        }
                        var eventModel: EventModel = EventModel(
                                images,
                                eventResult.title,
                                eventResult.description,
                                eventResult.body_text,
                                date,
                                place,
                                price,
                                ""
                        )
                        events.add(eventModel)
                    }
                    onSuccess(events)
                },
                onError = {
                    onError(it)
                })
    }
}