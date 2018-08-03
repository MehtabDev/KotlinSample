package com.mehtabkotlin.application

import android.app.Application
import android.graphics.Typeface
import android.os.Handler
import com.mehtabkotlin.constant.BConstant
import com.mehtabkotlin.custom.BTypeFactory
import com.mehtabkotlin.model.BRestServiceModel

/**
 * Created by mehtabk on 7/6/2018.
 */
class BApplication : Application() {


    private var mRestService: BRestServiceModel? = null
    private var mFontFactory: BTypeFactory? = null
    /* private var mWorkerThread: WorkerThread? = null
     private var m_agoraAPI: AgoraAPIOnlySignal? = null
     private val mHandler = Handler()
     private var mDatabase : SMyDatabase? = null

     override fun onCreate() {
         super.onCreate()
         instance = this
         Hawk.init(applicationContext).build()

         mDatabase = Room.databaseBuilder(applicationContext, SMyDatabase::class.java, SConstant.DATABASE_NAME2)
                 .fallbackToDestructiveMigration()
                 .build()

     }*/
    override fun onCreate() {
        super.onCreate()
        instance = this
        /* Hawk.init(applicationContext).build()

         mDatabase = Room.databaseBuilder(applicationContext, SMyDatabase::class.java, SConstant.DATABASE_NAME2)
                 .fallbackToDestructiveMigration()
                 .build()*/

    }

    /**
     * user : mehtabk
     * date : july 06, 2018
     * description : get type face to use font family in the application.
     */
    fun getTypeFace(type: Int): Typeface {
        if (mFontFactory == null)
            mFontFactory = BTypeFactory(this)

        when (type) {
            BConstant.NORMAL -> return mFontFactory?.normal!!
            BConstant.BOLD -> return mFontFactory?.bold!!
//            BConstant.ITALIC -> return mFontFactory?.italic!!
//            BConstant.ITALIC_BOLD -> return mFontFactory?.italicBold!!
        }

        return mFontFactory?.normal!!

    }

    /**
     * @author : mehtabk
     * @created : July 6, 2018
     * @method name : getRestService()
     * @description : This method is used to create the global object for RestFactory
     */
    fun getRestService(): BRestServiceModel? {
        if (mRestService == null) {
            mRestService = BRestServiceModel.create()
        }
        return mRestService
    }

    companion object {
        val TAG: String = BApplication::class.java.simpleName
        lateinit var instance: BApplication


    }
}