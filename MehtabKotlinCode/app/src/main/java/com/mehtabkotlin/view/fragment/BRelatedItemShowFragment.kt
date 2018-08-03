package com.mehtabkotlin.view.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rajeshk.recylerviewexample.adapter.BRelatedItemShowAdapter
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication
import kotlinx.android.synthetic.main.fragment_releated_item.*

/**
 * Created by mehtabk on 8/3/2018.
 */
class BRelatedItemShowFragment:BParentFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_releated_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        init()
    }


}