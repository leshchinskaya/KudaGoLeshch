package com.example.mariya.kudagoleshch.adapters.Event

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mariya.kudagoleshch.R
import com.squareup.picasso.Picasso

class ViewPagerAdapter: PagerAdapter() {

    private var photoList: List<String> = emptyList()

    fun setData(photoList: List<String>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        (collection as ViewPager).removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = buildPageContentView(container.context, photoList[position])
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean =
        view == obj

    override fun getCount(): Int =
        photoList.size

    private fun buildPageContentView(context: Context, photoUrl: String): View {
        val image: ImageView = ImageView(context)
        image.setImageResource(R.drawable.test_photo)
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        return image
    }
}