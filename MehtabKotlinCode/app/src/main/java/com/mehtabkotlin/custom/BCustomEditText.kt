package com.mehtabkotlin.custom

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import com.mehtabkotlin.R
import com.mehtabkotlin.application.BApplication



/**
 * Created by mehtabk on Aug 06, 2018.
 */

class BCustomEditText : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0)
        val mTypeFace: Int
        mTypeFace = try {
            typedArray.getInteger(R.styleable.CustomTextView_font_name, 0)
        } finally {
            typedArray.recycle()
        }
        if (!isInEditMode) {
            typeface = BApplication.instance.getTypeFace(mTypeFace) //get typeface from application class
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}
