package com.mehtabkotlin.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mehtabkotlin.R
import kotlinx.android.synthetic.main.fragment_home.*
import android.support.v7.widget.DefaultItemAnimator
import com.mehtabkotlin.application.BApplication
import kotlinx.android.synthetic.main.fragment_home_category.*
import android.support.v7.widget.GridLayoutManager
import com.mehtabkotlin.adapter.*
import com.mehtabkotlin.view.activity.BRelatedItemShowActivity
import kotlinx.android.synthetic.main.fragment_home_decor.*
import kotlinx.android.synthetic.main.fragment_home_jeans.*
import kotlinx.android.synthetic.main.fragment_home_shirt_tshirt.*
import kotlinx.android.synthetic.main.fragment_home_today_webview.*
import kotlinx.android.synthetic.main.fragment_home_trending_webview.*
import kotlinx.android.synthetic.main.fragment_home_watch_sunglass.*


/**
 * Created by mehtabk on 7/9/2018.
 */
class BHomeFragment() : BParentFragment() {

    private var mItemAdapter: BHomeItemAdapter? = null
    private var mCategoryShopAdapter: BHomeCategoryShopAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {

        imgFirst.setOnClickListener({

            val mainIntent: Intent = Intent(activity, BRelatedItemShowActivity::class.java)
            startActivity(mainIntent)
//            activity.moveHead(activity)

        })


        itemRecycler.layoutManager = LinearLayoutManager(activity)
        mItemAdapter = BHomeItemAdapter()
        val mLayoutManager = LinearLayoutManager(BApplication.instance, LinearLayoutManager.HORIZONTAL, false)
        itemRecycler.setLayoutManager(mLayoutManager)
        itemRecycler.setItemAnimator(DefaultItemAnimator())
        itemRecycler.setAdapter(mItemAdapter)
        itemRecycler.requestDisallowInterceptTouchEvent(true)

        todayDealWebView.getSettings().setJavaScriptEnabled(true);
//        todayDealWebView.loadUrl("https://www.flipkart.com")

        trendingWebView.getSettings().setJavaScriptEnabled(true);
//        trendingWebView.loadUrl("https://www.myntra.com")


        mCategoryShopAdapter = BHomeCategoryShopAdapter()
        categoryRecycler.setNestedScrollingEnabled(false)

        categoryRecycler.setLayoutManager(GridLayoutManager(activity, 3))
        categoryRecycler.setItemAnimator(DefaultItemAnimator())
        categoryRecycler.setAdapter(mCategoryShopAdapter)
        categoryRecycler.requestDisallowInterceptTouchEvent(true)

        val ladyImagePaderAdapter = BHomeLadyPagerAdapter(BApplication.instance)
        decorImageViewPager.setAdapter(ladyImagePaderAdapter)
        decorImageViewPager.setClipToPadding(false);
        decorImageViewPager.setPadding(60, 0, 50, 0);
        decorImageViewPager.setPageMargin(20);
        decorImageViewPager.requestDisallowInterceptTouchEvent(true)


        val shirtTShirtAdapter = BHomeShirtTShirtAdapter()
        shirtTShirtRecycler.setLayoutManager(LinearLayoutManager(BApplication.instance, LinearLayoutManager.HORIZONTAL, false))
        shirtTShirtRecycler.setItemAnimator(DefaultItemAnimator())
        shirtTShirtRecycler.setAdapter(shirtTShirtAdapter)
        shirtTShirtRecycler.requestDisallowInterceptTouchEvent(true)

        val watchSunglassAdapter = BHomeWatchSunglassAdapter()
        watchSunglassRecycler.setLayoutManager(LinearLayoutManager(BApplication.instance, LinearLayoutManager.HORIZONTAL, false))
        watchSunglassRecycler.setItemAnimator(DefaultItemAnimator())
        watchSunglassRecycler.setAdapter(watchSunglassAdapter)
        watchSunglassRecycler.requestDisallowInterceptTouchEvent(true)

    }
}