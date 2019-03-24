package com.example.mariya.kudagoleshch

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.LinearLayout
import com.example.mariya.kudagoleshch.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.eventtoolbar.*
import kotlinx.android.synthetic.main.textview_info.*

class DetailingEventActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        fillingActivity()

        image_view_back.setOnClickListener { onBackPressed() }
    }

    private fun fillingActivity() {
        val arguments = intent.extras

        if (arguments != null) {
            val images = arguments.get("images") as ArrayList<String>
            if (images.size > 0) {
                val viewPager = pager

                /*create adapter for ViewPager with received images*/
                val viewPagerAdapter = ViewPagerAdapter(this, images)
                viewPager.adapter = viewPagerAdapter

               // val circleIndicator = indicator
               // circleIndicator.setViewPager(viewPager)
            }

            title_event.text = arguments.getString("title")

            val shortDescriptionWithHtml = arguments.getString("description")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                shortDescription_event.text = Html.fromHtml(shortDescriptionWithHtml, Html.FROM_HTML_MODE_LEGACY)
            } else {
                shortDescription_event.text = Html.fromHtml(shortDescriptionWithHtml)
            }

            val fullDescriptionWithHtml = arguments.getString("fullDescription")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                fullDescription_event.text = Html.fromHtml(fullDescriptionWithHtml, Html.FROM_HTML_MODE_LEGACY)
            } else {
                fullDescription_event.text = Html.fromHtml(fullDescriptionWithHtml)
            }

            val place = arguments.getString("place")
            if (place != "") {
                description.text = place

                info.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f
                )
            }

            val date = arguments.getString("date")
            if (date != "") {
                description2.text = date
                info.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f
                )
            }

            val price = arguments.getString("price")
            if (price != "") {
                description3.text = price
                info.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f
                )
            }
        }

    }

}