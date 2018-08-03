package com.mehtabkotlin.custom

import android.content.Context
import android.graphics.Typeface

/**
 * Created by mehtabk on 7/6/2018.
 */
class BTypeFactory(context: Context) {

    // private val TIMES_NORMAL = "fonts/FRAMDCN.TTF"
    private val TIMES_NORMAL = "fonts/Roboto-Regular.ttf"
    private val TIMES_BOLD = "fonts/Roboto-Bold.ttf"
//    private val TIMES_ITALIC = "fonts/TimesNewRomanItalic.ttf"
//    private val TIMES_ITALIC_BOLD = "fonts/TimesNewRomanBoldItalic.ttf"

    var normal: Typeface
        internal set
    var bold: Typeface
        internal set
//    var italic: Typeface
//        internal set
//    var italicBold: Typeface
//        internal set

    init {
        normal = Typeface.createFromAsset(context.assets, TIMES_NORMAL)
        bold = Typeface.createFromAsset(context.assets, TIMES_BOLD)
//        italic = Typeface.createFromAsset(context.assets, TIMES_ITALIC)
//        italicBold = Typeface.createFromAsset(context.assets, TIMES_ITALIC_BOLD)
    }
}