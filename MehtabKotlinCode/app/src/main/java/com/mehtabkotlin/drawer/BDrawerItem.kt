package com.mehtabkotlin.drawer

import android.view.ViewGroup

/**
 * user : brajeshj
 * date : 13-11-2017
 * description : This is abstract class which will use for setting up drawer adapter
 */

abstract class BDrawerItem<T : Any> {

    var isChecked: Boolean = false

    val isSelectable: Boolean
        get() = true

    abstract fun createViewHolder(parent: ViewGroup, viewType: Int): T

    abstract fun bindViewHolder(holder: T)

    fun setChecked(isChecked: Boolean): BDrawerItem<*> {
        this.isChecked = isChecked
        return this
    }

    internal fun isChecked(): Boolean {
        return isChecked
    }

}
