package com.mehtabkotlin.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.ViewPager
import android.R.attr.country
import android.content.Context
import android.widget.TextView
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v7.widget.CardView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.mehtabkotlin.R


/**
 * Created by mehtabk on 7/13/2018.
 */
class BItemDetailsPagerAdapter(mContext: Context) : PagerAdapter() {

    private val images = intArrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)
    private val ctx: Context = mContext
    private var inflater: LayoutInflater? = null

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater!!.inflate(R.layout.adapter_item_detail_pager, container, false)
        val img = v.findViewById(R.id.pagerViewImage) as ImageView
        container.addView(v)
        return v
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        container.refreshDrawableState()
    }
}