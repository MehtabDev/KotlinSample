package com.example.rajeshk.recylerviewexample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.mehtabkotlin.R
import com.mehtabkotlin.view.activity.BRelatedItemShowActivity

/**
 * Created by rajeshk on 03-08-2018.
 */
class BRelatedItemShowAdapter(relatedItemShowActivity: BRelatedItemShowActivity, context: Context, gridList: String) : RecyclerView.Adapter<BRelatedItemShowAdapter.ItemsViewHolder>() {
    private var context = context
    private var gridList = gridList
    private var mBRelatedItemShowActivity: BRelatedItemShowActivity = relatedItemShowActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        var view: View? = null
        if (gridList.equals("list")) {
            view = LayoutInflater.from(context).inflate(R.layout.related_item_list, parent, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.related_item_grid, parent, false)
        }
        return ItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

    }

    inner class ItemsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mSelectedItemLinear: LinearLayout? = null
        var mItemImage: ImageView? = null
        var mItemNameText: TextView? = null
        var mMoneyIconText: TextView? = null
        var mCurrentAmountText: TextView? = null
        var mActualAmountText: TextView? = null
        var mPercentDiscountText: TextView? = null
        var mRatingStarButton: Button? = null
        var mReviewRatingText: TextView? = null


        init {
            mSelectedItemLinear = itemView!!.findViewById(R.id.selectRelatedItemLinear)
            mItemImage = itemView!!.findViewById(R.id.itemImage)
            mItemNameText = itemView!!.findViewById(R.id.itemNameText)
            mMoneyIconText = itemView!!.findViewById(R.id.priceSymbolText)
            mCurrentAmountText = itemView!!.findViewById(R.id.discountedPriceText)
            mActualAmountText = itemView!!.findViewById(R.id.actualPriceText);
            mPercentDiscountText = itemView!!.findViewById(R.id.discountPerText)
            mRatingStarButton = itemView!!.findViewById(R.id.ratingStarButton)
            mReviewRatingText = itemView!!.findViewById(R.id.ratingReviewText)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            mBRelatedItemShowActivity.showDetailSelected()


        }
    }
}