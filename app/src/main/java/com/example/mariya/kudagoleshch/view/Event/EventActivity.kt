package com.example.mariya.kudagoleshch.view.Event

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mariya.kudagoleshch.view.DetailingEvent.PagerIndicator
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.presenter.Event.EventPresenter
import com.example.mariya.kudagoleshch.adapters.Event.EventPhotosAdapter


class EventActivity : AppCompatActivity(), EventView.View {

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

    }

    fun onClickArrow(v: View) {
        onBackPressed()
    }
    */


    private lateinit var mPhotoAdapter: EventPhotosAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerIndicator: PagerIndicator
    private lateinit var mCloseButton: ImageView
    private lateinit var mPresenter: EventPresenter

    private lateinit var mTitle: TextView
    private lateinit var mSubtitle: TextView
    private lateinit var mDescription: TextView
    private lateinit var mContentPlace: TextView
    private lateinit var mLinearPlace: LinearLayout
    private lateinit var mContentDate: TextView
    private lateinit var mLinearDate: LinearLayout
    private lateinit var mContentPrice: TextView
    private lateinit var mLinearPrice: LinearLayout
    private lateinit var mDatePlacePriceLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        mPresenter = EventPresenter(this)
       // mViewPager = findViewById(R.id.event_description_view_pager)
        mViewPager.offscreenPageLimit = 3
        mPagerIndicator = findViewById(R.id.pager_indicator)

        mPhotoAdapter = EventPhotosAdapter()
        mViewPager.adapter = mPhotoAdapter
        mPagerIndicator.setViewPager(mViewPager)

       // mCloseButton = findViewById(R.id.event_close_button)
        mCloseButton.setOnClickListener {
            finish()
        }

        mTitle = findViewById(R.id.title_event)
        mSubtitle = findViewById(R.id.shortDescription_event)
        mDescription = findViewById(R.id.fullDescription_event)
        mContentPlace = findViewById(R.id.description)
        mLinearPlace = findViewById(R.id.icon)
        mContentDate = findViewById(R.id.description2)
        mLinearDate = findViewById(R.id.icon2)
        mContentPrice = findViewById(R.id.description3)
        mLinearPrice = findViewById(R.id.icon3)
        mDatePlacePriceLinearLayout = findViewById(R.id.info)


        val eventModelFromIntent = intent.getSerializableExtra("eventModel")
        mPresenter.showEvent(eventModelFromIntent as EventModel)
    }

    override fun showEvent(eventModel: EventModel) {
        mTitle.text = eventModel.headerText
        mSubtitle.text = eventModel.description
        mDescription.text = eventModel.body_text
        mPhotoAdapter.setPhotos(eventModel.imageURL)


        if (eventModel.place != null) {
            mContentPlace.text = eventModel.place
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearPlace)
        }
        if (eventModel.date != null) {
            mContentDate.text = eventModel.date
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearDate)
        }
        if (eventModel.price != null && eventModel.price!!.count() > 0) {
            mContentPrice.text = eventModel.price
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearPrice)
        }

    }
}