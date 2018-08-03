package com.mehtabkotlin.logger

import android.util.Log
import com.mehtabkotlin.BuildConfig

/**
 * Created by mehtabk on 7/6/2018.
 */
class BLogger {

    companion object {

        /**
         * @param tag
         * @param msg
         * @Despription: Create log i method showing log info
         */
        fun i(tag: String, msg: String?) {
            Log.i(tag, msg)
        }

        /**
         * @param tag
         * @param msg
         * @Despription: Create log method to showing log error
         */
        fun e(tag: String, msg: String?) {
            if(BuildConfig.DEBUG) {
                Log.e(tag, msg)
            }
        }

        /**
         * @param tag
         * @param msg
         * @Despription: Create log method to showing log debug point
         */
        fun d(tag: String, msg: String?) {
            if(BuildConfig.DEBUG) {
                Log.d(tag, msg)
            }
        }
    }
}