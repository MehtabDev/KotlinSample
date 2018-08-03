package com.mehtabkotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View

/**
 * Created by mehtabk on 7/9/2018.
 */
class BHomePagerAdapter:PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPageWidth(position: Int): Float {
        return 0.93f;
    }

}