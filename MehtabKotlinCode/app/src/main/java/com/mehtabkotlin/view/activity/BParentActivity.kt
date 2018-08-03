package com.mehtabkotlin.view.activity

import android.support.v7.app.AppCompatActivity
import com.mehtabkotlin.R
import com.mehtabkotlin.constant.BConstant

/**
 * Created by mehtabk on 7/6/2018.
 */
open class BParentActivity : AppCompatActivity() {

    /**
     * user : brajeshj
     * date : 15-12-2017
     * description : To clear fragment backStack
     */
    fun clearBackStack() {
        val fm = supportFragmentManager
        for (backStack in BConstant.DEFAULT_COUNT until fm.backStackEntryCount) {
            fm.popBackStack()
        }

    }

    fun moveHead(activity: BParentActivity) {
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
    }

    fun moveBack(activity: BParentActivity) {
        activity.overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveBack(this@BParentActivity)
    }
}