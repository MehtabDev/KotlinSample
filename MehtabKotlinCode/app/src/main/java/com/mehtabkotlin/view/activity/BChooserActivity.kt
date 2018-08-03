package com.mehtabkotlin.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.mehtabkotlin.R
import com.mehtabkotlin.logger.BLogger
import kotlinx.android.synthetic.main.activity_main_app.*

/**
 * Created by mehtabk on 7/17/2018.
 */
class BChooserActivity : BParentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        onlineShopImage.setOnClickListener(BCustomClickListener())

    }

    /**
     * Created by mehtabk on 7/17/2018.
     * Description: Custom click listener handler class
     */
    inner class BCustomClickListener : View.OnClickListener {
        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.onlineShopImage -> {
                    onlineShoppingClicked()
                }
            }

        }
    }

    fun onlineShoppingClicked() {
        val mainIntent = Intent(this@BChooserActivity, BDashboardShopActivity::class.java)
        startActivity(mainIntent)
        moveHead(this@BChooserActivity)
        BLogger.e("onlineShopping", "Clicked")

    }

}