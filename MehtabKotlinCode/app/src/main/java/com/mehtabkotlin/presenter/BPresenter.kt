package com.mehtabkotlin.presenter

/**
 * Created by mehtabk on 7/9/2018.
 */
interface BPresenter<in V> {

    fun attachView(view: V)

    fun detachView()
}