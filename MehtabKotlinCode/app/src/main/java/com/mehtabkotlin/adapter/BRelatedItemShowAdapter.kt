package com.example.rajeshk.recylerviewexample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mehtabkotlin.R

/**
 * Created by rajeshk on 03-08-2018.
 */
class BRelatedItemShowAdapter(context: Context, gridList: String) : RecyclerView.Adapter<BRelatedItemShowAdapter.GridViewHolder>() {
    private var context = context
    private var gridList = gridList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        var view: View? = null
        if (gridList.equals("list")) {
            view = LayoutInflater.from(context).inflate(R.layout.related_item_list, parent, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.related_item_grid, parent, false)
        }
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

    }

    class GridViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}