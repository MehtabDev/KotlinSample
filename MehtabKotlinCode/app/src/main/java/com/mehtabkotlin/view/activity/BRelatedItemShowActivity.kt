package com.mehtabkotlin.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.rajeshk.recylerviewexample.adapter.BRelatedItemShowAdapter
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication
import kotlinx.android.synthetic.main.common_header.*
import kotlinx.android.synthetic.main.fragment_home_watch_sunglass.*
import kotlinx.android.synthetic.main.fragment_releated_item.*

/**
 * Created by mehtabk on 8/3/2018.
 */
class BRelatedItemShowActivity : BParentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_releated_item)
        setSupportActionBar(commonToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        commonToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        setTitle("Item")
        init()
    }

    fun init() {
        relatedItemShowRelative.layoutManager = GridLayoutManager(this, 2)
        relatedItemShowRelative.requestDisallowInterceptTouchEvent(true)
        relatedItemShowRelative.isNestedScrollingEnabled = false
        var adapter: BRelatedItemShowAdapter = BRelatedItemShowAdapter(this@BRelatedItemShowActivity, BApplication.instance, "grid")
        relatedItemShowRelative.adapter = adapter
        var flag = 0;
        listGridImage.setOnClickListener({
            if (flag == 0) {
                flag = 1
                listGridImage.setImageDrawable(resources.getDrawable(R.mipmap.list_view_icon))
                relatedItemShowRelative.layoutManager = LinearLayoutManager(this)
                relatedItemShowRelative.isNestedScrollingEnabled = false
                adapter = BRelatedItemShowAdapter(this@BRelatedItemShowActivity, BApplication.instance, "list")
                relatedItemShowRelative.adapter = adapter
            } else if (flag == 1) {
                flag = 0
                listGridImage.setImageDrawable(resources.getDrawable(R.mipmap.grid_view_icon))
                relatedItemShowRelative.layoutManager = GridLayoutManager(this, 2)
                relatedItemShowRelative.isNestedScrollingEnabled = false
                adapter = BRelatedItemShowAdapter(this@BRelatedItemShowActivity, BApplication.instance, "grid")
                relatedItemShowRelative.adapter = adapter
            }
        })
    }

    public fun showDetailSelected() {
        val loginIntent = Intent(this@BRelatedItemShowActivity, BItemDetailActivity::class.java)
        startActivity(loginIntent)
        moveHead(this@BRelatedItemShowActivity)
    }
}