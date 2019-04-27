package com.example.mariya.kudagoleshch.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.example.mariya.kudagoleshch.model.entity.eventEntity.Events
import com.example.mariya.kudagoleshch.presenter.City.CitiesResponse
import com.example.mariya.kudagoleshch.network.KudaGoApi.getCitiesURL
import com.example.mariya.kudagoleshch.network.KudaGoApi.getEventsURL

class KudaGoBaseApiRepository(private val context: Context) {

    private val loadCitiesTag = "$TAG:LOAD_CITIES"
    private val loadEventsTag = "$TAG:LOAD_EVENTS"

    private val tags = arrayOf(loadCitiesTag, loadEventsTag)

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun loadCities(onSuccess: (CitiesResponse) -> Unit, onError: (Throwable) -> Unit) {
        addToRequestQueue(
                GsonRequest(
                        getCitiesURL(),
                        CitiesResponse::class.java,
                        emptyMap(),
                        Response.Listener { CitiesResponse ->
                            onSuccess(CitiesResponse)
                        },
                        Response.ErrorListener { error ->
                            onError(error)
                        }
                ).apply { tag = loadCitiesTag }
        )
    }

    fun loadEvents(city: String, pageCount: Int, onSuccess: (Events) -> Unit, onError: (Throwable) -> Unit) {
        addToRequestQueue(
                GsonRequest(
                        getEventsURL(city, pageCount),
                        Events::class.java,
                        emptyMap(),
                        Response.Listener { events ->
                            onSuccess(events)
                        },
                        Response.ErrorListener { error ->
                            onError(error)
                        }
                ).apply { tag = loadEventsTag }
        )
    }

    fun onDestroy() {
        tags.forEach(requestQueue::cancelAll)
    }

    private fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }

    companion object {
        private val TAG = KudaGoBaseApiRepository::class.java.name
    }
}