package com.mehtabkotlin.drawer

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.mehtabkotlin.R


/**
 * user : brajeshj
 * date : 13-11-2017
 * description : This class is use for recycler view adapter on Drawer adapter class using drawer item abstract class
 */
class BSimpleItem
/**
 * user : brajeshj
 * date : 18-11-2017
 * description : Class constructor
 */
(private val mContext: Context, private val icon: Drawable, private val title: String) : BDrawerItem<BSimpleItem.ViewHolder>() {

    private var selectedItemIconTint: Int = 0
    private var selectedItemTextTint: Int = 0

    private var normalItemIconTint: Int = 0
    private var normalItemTextTint: Int = 0

    override fun createViewHolder(parent: ViewGroup,viewType:Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_option, parent, false)

        return ViewHolder(v)
    }

    override fun bindViewHolder(holder: ViewHolder) {
        holder.title.text = title
        holder.icon.setImageDrawable(icon)

        holder.title.setTextColor(if (isChecked) selectedItemTextTint else normalItemTextTint)
        holder.icon.setColorFilter(if (isChecked) selectedItemIconTint else normalItemIconTint)
        /*  holder.mLayout.background = if (isChecked)
              ContextCompat.getDrawable(mContext, R.drawable.unselected)
          else
              ContextCompat.getDrawable(mContext, R.drawable.selected)*/
    }

    /**
     * user : brajeshj
     * date : 18-11-2017
     * description : set selected_curv_top icon tint color for drawer item
     */
    fun withSelectedIconTint(selectedItemIconTint: Int): BSimpleItem {
        this.selectedItemIconTint = selectedItemIconTint
        return this
    }

    /**
     * user : brajeshj
     * date : 18-11-2017
     * description : set selected_curv_top text tint color for drawer item
     */
    fun withSelectedTextTint(selectedItemTextTint: Int): BSimpleItem {
        this.selectedItemTextTint = selectedItemTextTint
        return this
    }

    /**
     * user : brajeshj
     * date : 18-11-2017
     * description : set normal icon tint color for drawer item
     */
    fun withIconTint(normalItemIconTint: Int): BSimpleItem {
        this.normalItemIconTint = normalItemIconTint
        return this
    }

    /**
     * user : brajeshj
     * date : 18-11-2017
     * description : set normal text tint color for drawer item
     */
    fun withTextTint(normalItemTextTint: Int): BSimpleItem {
        this.normalItemTextTint = normalItemTextTint
        return this
    }

     class ViewHolder(itemView: View) : BDrawerAdapter.ViewHolder(itemView) {

        val icon: ImageView = itemView.findViewById(R.id.icon)
        val title: TextView = itemView.findViewById(R.id.title)
         val mLayout: LinearLayout = itemView.findViewById(R.id.layout)

     }
}
