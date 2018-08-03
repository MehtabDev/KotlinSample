package com.mehtabkotlin.presenter

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication
import com.mehtabkotlin.constant.BConstant
import com.mehtabkotlin.drawer.BDrawerAdapter
import com.mehtabkotlin.drawer.BDrawerItem
import com.mehtabkotlin.drawer.BSimpleItem
import com.mehtabkotlin.interactor.BDashboardInteractor
import com.mehtabkotlin.view.activity.BDashboardShopActivity

/**
 * Created by mehtabk on 7/9/2018.
 */
class BDashboardPresenter :BPresenter<BDashboardInteractor>  {

    private var mDashboardInteractor: BDashboardInteractor? = null
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private var mDrawerAdapter: BDrawerAdapter? = null
    private val mApplication = BApplication.instance

    override fun attachView(view: BDashboardInteractor) {
        mDashboardInteractor = view
        mContext = mDashboardInteractor!!.getContext()
        mActivity = mDashboardInteractor!!.getActivity()
    }

    override fun detachView() {
        mDashboardInteractor = null
    }

    fun loadScreenIcons(): Array<Drawable?> {
        val ta = mContext.resources.obtainTypedArray(R.array.ld_activityScreenIcons)
        val icons = arrayOfNulls<Drawable>(ta.length())
        for (index in 0 until ta.length()) {
            val id = ta.getResourceId(index, BConstant.DEFAULT_COUNT)
            if (id != 0) {
                icons[index] = ContextCompat.getDrawable(mContext, id)
            }
        }
        ta.recycle()
        return icons
    }

    /**
     * user : brajeshj
     * date : 13-11-2017
     * description : Initialize drawer adapter
     */
    fun initDrawerAdapter() {

        val list = mutableListOf(
                createItemFor(BDashboardShopActivity.MEN_CAT).setChecked(true),
                createItemFor(BDashboardShopActivity.WOMEN_CAT),
                createItemFor(BDashboardShopActivity.KIDS),
                createItemFor(BDashboardShopActivity.BEAUTY),
                createItemFor(BDashboardShopActivity.SPORT_BOOK),
                createItemFor(BDashboardShopActivity.OFFER),
                createItemFor(BDashboardShopActivity.MY_REWARDS),

                createItemFor(BDashboardShopActivity.MY_CART),
                createItemFor(BDashboardShopActivity.MY_WISHLIST),
                createItemFor(BDashboardShopActivity.MY_ORDERS),
                createItemFor(BDashboardShopActivity.MY_ACCOUNT),
                createItemFor(BDashboardShopActivity.MY_SETTING))

        @Suppress("UNCHECKED_CAST")
        mDrawerAdapter = BDrawerAdapter(list as List<BDrawerItem<Any>>)
        mDashboardInteractor!!.setDrawerListener(mDrawerAdapter)
        mDashboardInteractor!!.setDrawerListAdapter(mDrawerAdapter)
    }

    /**
     * user : brajeshj
     * date : 13-11-2017
     * description : This function will create different item for different position with icons, titles and setup
     * different color for titles and icons.
     */
    private fun createItemFor(position: Int): BDrawerItem<*> {
        return BSimpleItem(mContext, loadScreenIcons()[position]!!, loadScreenTitles()[position])
                .withIconTint(color(R.color.white))
                .withTextTint(color(R.color.white))
                .withSelectedIconTint(color(R.color.white))
                .withSelectedTextTint(color(R.color.white))
    }

    @ColorInt
    private fun color(@ColorRes res: Int): Int {
        return ContextCompat.getColor(mContext, res)
    }
    /**
     * user : brajeshj
     * date : 13-11-2017
     * description : get all the titles for drawer menu list
     */
    private fun loadScreenTitles(): Array<String> {
        return mContext.resources.getStringArray(R.array.ld_activityScreenTitles)
    }

}