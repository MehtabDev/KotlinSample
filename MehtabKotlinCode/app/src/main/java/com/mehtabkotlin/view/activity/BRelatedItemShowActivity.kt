package com.mehtabkotlin.view.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.rajeshk.recylerviewexample.adapter.BRelatedItemShowAdapter
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication
import kotlinx.android.synthetic.main.fragment_home_watch_sunglass.*
import kotlinx.android.synthetic.main.fragment_releated_item.*

/**
 * Created by mehtabk on 8/3/2018.
 */
class BRelatedItemShowActivity : BParentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_releated_item)
        init()
    }

    fun init() {
        relatedItemShowRelative.layoutManager = GridLayoutManager(this, 2)
        relatedItemShowRelative.requestDisallowInterceptTouchEvent(true)
        relatedItemShowRelative.isNestedScrollingEnabled = false
        var adapter: BRelatedItemShowAdapter = BRelatedItemShowAdapter(BApplication.instance, "grid")
        relatedItemShowRelative.adapter = adapter
        var flag = 0;
        btnChange.setOnClickListener({
            if (flag == 0) {
                flag = 1
                btnChange.text = "List"
                relatedItemShowRelative.layoutManager = LinearLayoutManager(this)
                relatedItemShowRelative.isNestedScrollingEnabled = false
                adapter = BRelatedItemShowAdapter(BApplication.instance, "list")
                relatedItemShowRelative.adapter = adapter
            } else if (flag == 1) {
                flag = 0
                btnChange.text = "Grid"
                relatedItemShowRelative.layoutManager = GridLayoutManager(this, 2)
                relatedItemShowRelative.isNestedScrollingEnabled = false
                adapter = BRelatedItemShowAdapter(BApplication.instance, "grid")
                relatedItemShowRelative.adapter = adapter
            }
        })
    }
}