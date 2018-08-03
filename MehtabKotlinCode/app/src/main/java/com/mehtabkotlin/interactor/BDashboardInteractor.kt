package com.mehtabkotlin.interactor

import com.mehtabkotlin.drawer.BDrawerAdapter

/**
 * Created by mehtabk on 7/9/2018.
 */
interface BDashboardInteractor : BViewInteractor {

    fun setDrawerListener(mDrawerAdapter: BDrawerAdapter?)
    fun setDrawerListAdapter(mDrawerAdapter: BDrawerAdapter?)
    fun onSuccessResponse()
    fun onFailureResponse(error : String)
}