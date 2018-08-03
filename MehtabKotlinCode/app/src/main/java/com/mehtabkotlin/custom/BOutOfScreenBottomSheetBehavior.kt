package com.mehtabkotlin.custom

import android.content.Context
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.mehtabkotlin.R
import com.mehtabkotlin.view.activity.BItemDetailActivity


/**
 * [BottomSheetBehavior] that shows automatically when the dependency goes out of the screen
 * and hides when it comes back in.
 */
class BOutOfScreenBottomSheetBehavior(context: Context, attrs: AttributeSet) : BottomSheetBehavior<FrameLayout>(context, attrs) {


    private var statusBarHeight: Int = 0


    init {

        val resourceId = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = context.resources.getDimensionPixelSize(resourceId)
        }
    }

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: FrameLayout?, dependency: View?): Boolean {
        return dependency!!.id == R.id.behavior_dependency
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: FrameLayout?, dependency: View?): Boolean {
        val dependencyLocation = IntArray(2)

        dependency!!.getLocationInWindow(dependencyLocation)
        Log.d("BEHAVIOR", "Location: " + dependencyLocation[1])
        /* DisplayMetrics displayMetrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);*/

        if (dependencyLocation[1] == BItemDetailActivity.HEIGHT) {
            if (state != BottomSheetBehavior.STATE_EXPANDED) {
                state = BottomSheetBehavior.STATE_EXPANDED
            }
        } else {
            state = BottomSheetBehavior.STATE_HIDDEN
        }
        return false
    }

}
