package com.mehtabkotlin.drawer

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * user : brajeshj
 * date : 13-11-2017
 * description : This is adapter class for showing list in drawer menu
 */

class BDrawerAdapter(private val items: List<BDrawerItem<Any>>) : RecyclerView.Adapter<BDrawerAdapter.ViewHolder>() {
    private val viewTypes: MutableMap<Class<out BDrawerItem<*>>, Int>
    private val holderFactories: SparseArray<BDrawerItem<*>>

    private var listener: OnItemSelectedListener? = null

    init {
        this.viewTypes = HashMap()
        this.holderFactories = SparseArray()

        processViewTypes()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = holderFactories.get(viewType).createViewHolder(parent, viewType)
        holder as ViewHolder
        holder.adapter = this
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].bindViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypes[items[position].javaClass]!!
    }

    /**
     * user : brajeshj
     * date : 13-11-2017
     * description : To get item type from drawer items
     */
    private fun processViewTypes() {
        var type = 0
        for (item in items) {
            if (!viewTypes.containsKey(item.javaClass)) {
                viewTypes[item.javaClass] = type
                holderFactories.put(type, item)
                type++
            }
        }
    }

    /**
     * user : brajeshj
     * date : 13-11-2017
     * description : set selected_curv_top background tint color using setchecked function and get selected_curv_top position using
     * onItemSelected callback on SDashboard class
     */
    fun setSelected(position: Int) {
        val newChecked = items[position]
        if (!newChecked.isSelectable) {
            return
        }

        for (i in items.indices) {
            val item = items[i]
            if (item.isChecked) {
                item.isChecked = false
                notifyItemChanged(i)
                break
            }
        }

        newChecked.isChecked = true
        notifyItemChanged(position)

        if (listener != null) {
            listener!!.onItemSelected(position)
        }
    }

    fun setListener(listener: OnItemSelectedListener) {
        this.listener = listener
    }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var adapter: BDrawerAdapter? = null

        init {
            @Suppress("LeakingThis")
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            adapter!!.setSelected(adapterPosition)
        }
    }

    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
    }
}
