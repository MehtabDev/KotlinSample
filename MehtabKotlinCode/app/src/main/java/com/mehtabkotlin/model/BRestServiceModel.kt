package com.mehtabkotlin.model

import com.google.gson.GsonBuilder
import com.mehtabkotlin.BuildConfig
import com.mehtabkotlin.constant.BConstant
import com.mehtabkotlin.logger.BLogger
import com.mehtabkotlin.util.BUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mehtabk on 7/6/2018.
 */
interface BRestServiceModel {
    companion object RestFactory {
        fun create(): BRestServiceModel {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder().readTimeout(BConstant.TIME_OUT, TimeUnit.SECONDS)
                    .connectTimeout(BConstant.TIME_OUT, TimeUnit.SECONDS)

            val retrofit = Retrofit.Builder()
                    .baseUrl(BConstant.URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                    //                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient.build())
                    // .client(getHttpClient())
                    .build()
            return retrofit.create(BRestServiceModel::class.java)
        }

    }
}