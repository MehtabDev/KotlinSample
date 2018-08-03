package com.mehtabkotlin.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication

/**
 * Created by mehtabk on 7/9/2018.
 */
class BItemAvailColorAdapter : RecyclerView.Adapter<BItemAvailColorAdapter.ViewHolder>() {
    var mClickPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_item_color_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (mClickPosition == 0) {
            // Here highlighting the background
            holder.mBackgroundLinear.setBackground(ContextCompat.getDrawable(BApplication.instance, R.drawable.selected_item))
        } else {
            holder.mBackgroundLinear.setBackground(ContextCompat.getDrawable(BApplication.instance, R.drawable.un_selected_item))
        }


    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        var mItemColorImage = itemView!!.findViewById<ImageView>(R.id.itemColorImage)!!
        var mBackgroundLinear = itemView!!.findViewById<LinearLayout>(R.id.backgroundLinear)!!

        init {
            mItemColorImage?.setOnClickListener(this)
            itemView?.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.itemColorImage -> {
                    if (mClickPosition!= adapterPosition){
                        notifyItemChanged(mClickPosition)
                        mClickPosition = adapterPosition
                        mBackgroundLinear.setBackground(ContextCompat.getDrawable(BApplication.instance, R.drawable.selected_item))
                    }
                }
            }

        }
    }
}