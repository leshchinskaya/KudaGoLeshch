package com.example.mariya.kudagoleshch.view.Event

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mariya.kudagoleshch.R
import com.example.mariya.kudagoleshch.model.EventModel
import com.example.mariya.kudagoleshch.presenter.Event.EventPresenter
import com.example.mariya.kudagoleshch.adapters.Event.EventPhotosAdapter
import kotlinx.android.synthetic.main.eventtoolbar.*


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
    private lateinit var mPresenter: EventPresenter

    private lateinit var mTitle: TextView
    private lateinit var mSubtitle: TextView
    private lateinit var mDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        mPresenter = EventPresenter(this)
        mViewPager = findViewById(R.id.pager)
        mViewPager.offscreenPageLimit = 3
        mPagerIndicator = findViewById(R.id.pager_indicator)

        mPhotoAdapter = EventPhotosAdapter()
        mViewPager.adapter = mPhotoAdapter
        mPagerIndicator.setViewPager(mViewPager)


        mTitle = findViewById(R.id.title_event)
        mSubtitle = findViewById(R.id.shortDescription_event)
        mDescription = findViewById(R.id.fullDescription_event)


        //image_view_back.setOnClickListener { onBackPressed() }

        val eventModelFromIntent = intent.getSerializableExtra("eventModel")
        mPresenter.showEvent(eventModelFromIntent as EventModel)
    }

    override fun showEvent(eventModel: EventModel) {
        mTitle.text = eventModel.headerText
        mSubtitle.text = eventModel.description
        mDescription.text = eventModel.body_text
        mPhotoAdapter.setPhotos(eventModel.imageURL)


    }
}