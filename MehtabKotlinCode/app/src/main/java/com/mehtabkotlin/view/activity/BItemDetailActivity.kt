package com.mehtabkotlin.view.activity

import android.graphics.Paint
import android.util.DisplayMetrics
import android.support.design.widget.BottomSheetBehavior
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.mehtabkotlin.R
import android.widget.LinearLayout.LayoutParams;
import com.mehtabkotlin.adapter.BItemAvailColorAdapter
import com.mehtabkotlin.adapter.BItemDetailsPagerAdapter
import com.mehtabkotlin.application.BApplication
import kotlinx.android.synthetic.main.activity_item_details.*
import kotlinx.android.synthetic.main.common_header.*
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG




/**
 * Created by mehtabk on 7/14/2018.
 */
class BItemDetailActivity : BParentActivity() {

    private var button: View? = null
    private var bottomButton: View? = null
    private var bottomSheetBehavior: BottomSheetBehavior<View>? = null
    var linLayoutParams: LayoutParams? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        setSupportActionBar(commonToolbar)
        setTitle("Item Details")
        button = findViewById(R.id.got_it)
        bottomButton = findViewById(R.id.bottom_button)
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet))
        bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_HIDDEN)
        bottomButton!!.setOnClickListener(({ this.exit(it) }))
        button!!.setOnClickListener(({ this.exit(it) }))
        val displayMetrics = DisplayMetrics()
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        HEIGHT = height
        val oneThirdView = (height / 2) + 100

        val itemDetailsPagerAdapter = BItemDetailsPagerAdapter(BApplication.instance)
        itemDetailsRecycler.setAdapter(itemDetailsPagerAdapter)
        indicator.setViewPager(itemDetailsRecycler)
        itemDetailsRecycler.clipToPadding = false
        itemDetailsRecycler.layoutParams.height = oneThirdView;
        itemDetailsRecycler.requestDisallowInterceptTouchEvent(true)


        differentColorRecycler.layoutManager = LinearLayoutManager(this)
        val mItemAvailColorAdapter = BItemAvailColorAdapter()
        val mLayoutManager = LinearLayoutManager(BApplication.instance, LinearLayoutManager.HORIZONTAL, false)
        differentColorRecycler.setLayoutManager(mLayoutManager)
        differentColorRecycler.setItemAnimator(DefaultItemAnimator())
        differentColorRecycler.setAdapter(mItemAvailColorAdapter)
        differentColorRecycler.requestDisallowInterceptTouchEvent(true)

        actualPriceText.setPaintFlags(actualPriceText.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
    }

    private fun exit(view: View) {
        finish()
    }

    companion object {
        var HEIGHT = 0
    }
}