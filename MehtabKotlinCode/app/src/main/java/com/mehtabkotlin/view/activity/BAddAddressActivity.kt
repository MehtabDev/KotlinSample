package com.mehtabkotlin.view.activity

import android.os.Bundle
import com.mehtabkotlin.R
import android.widget.TextView
import android.view.Gravity
import android.widget.LinearLayout
import android.view.Window.FEATURE_NO_TITLE
import android.app.Activity
import android.app.Dialog
import android.view.Window


/**
 * Created by mehtabk on 7/14/2018.
 */
class BAddAddressActivity : BParentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)
        showAvailableDialog()

    }


    /**
     * Name:mehtabk
     * Descr: Method to show slots chooser dialog.
     */
    fun showAvailableDialog() {
        val dialog = Dialog(this, R.style.DialogSlideAnim)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(R.layout.dialog_available)
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.BOTTOM)
        dialog.show()

    }
}