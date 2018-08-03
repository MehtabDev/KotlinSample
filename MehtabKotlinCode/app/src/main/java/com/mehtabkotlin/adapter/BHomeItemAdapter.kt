package com.mehtabkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mehtabkotlin.R

/**
 * Created by mehtabk on 7/9/2018.
 */
class BHomeItemAdapter: RecyclerView.Adapter<BHomeItemAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 8

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        var mItemImage = itemView!!.findViewById<ImageView>(R.id.itemImage)!!
        var mItemName = itemView!!.findViewById<TextView>(R.id.itemName)!!

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}