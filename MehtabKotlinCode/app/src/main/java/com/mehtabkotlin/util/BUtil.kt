package com.mehtabkotlin.util

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AlertDialog
import android.view.Gravity
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.mehtabkotlin.R
import java.lang.IllegalStateException

/**
 * Created by mehtabk on 7/6/2018.
 */
class BUtil private constructor(){

    /**
     * @return the boolean
     * @author : mehtabk
     * @created : July 6, 2018
     * @description : to check the internet connectivity
     */

    fun isInternetAvailable(_context: Context?): Boolean {
      /*  val connectivity = _context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return try {
            val mNetworkInfo: NetworkInfo = connectivity.activeNetworkInfo
            mNetworkInfo.isConnected
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            false
        }*/
        return false


    }

    companion object {
        private var bUtil: BUtil? = null
        private var bDialog: Dialog? = null

        /**
         * @author : mehtabk
         * @created : July 6, 2018
         * @method name : getInstance
         * @description : used to create single object of Util class to access their methods.
         */
        val instance: BUtil
            get() {
                if (bUtil == null) {
                    bUtil = BUtil()
                }
                return bUtil!!
            }

    }

    /**
     * user : mehtabk
     * @created : July 6, 2018
     * description : This function is used to allow permission in the app which is required
     */
    fun allowAllPermissions(activity: Activity, multiplePermissionsListener: MultiplePermissionsListener) {

        Dexter.withActivity(activity)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.WRITE_CALENDAR
                ).withListener(multiplePermissionsListener).check()

    }
    /**
     * user : mehtabk
     * @created : July 6, 2018
     * @param activity
     * @param title
     * @param message
     * @param onPostiveClick
     * description : Show alert dialog
     */
    fun showAlertDialog(activity: Activity, title: String?, message: String,
                        onPostiveClick: DialogInterface.OnClickListener) {
        val alertDialog = AlertDialog.Builder(activity)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(activity.getString(R.string.yes), onPostiveClick)
        alertDialog.setNegativeButton(activity.getString(R.string.no), { dialog, _ ->
            dialog.dismiss()
            dismissDialog()
        })

        val alert = alertDialog.create()
        alert.show()
    }
    /**
     * user : brajeshj
     * date : 14-11-2017
     * description : Custom alert dialog for showing message
     */
    fun showAlert(message: String, context: Activity) {

        try {
            bDialog = Dialog(context, R.style.DialogSlideAnim)

            bDialog!!.window!!.setGravity(Gravity.CENTER)
            bDialog!!.setContentView(R.layout.dialog_layout)
            bDialog!!.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            bDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            bDialog!!.setCancelable(true)
            val mOKButton = bDialog!!.findViewById<Button>(R.id.okButton)
            val mMessageText = bDialog!!.findViewById<TextView>(R.id.messageText)
            mMessageText.text = message

            mOKButton.setOnClickListener { bDialog!!.dismiss() }
            bDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * user : mehtabk
     * @created : July 6, 2018
     * description : Dismiss alert dialog
     */
    fun dismissDialog() {
        if (bDialog != null) {
            bDialog!!.dismiss()
            bDialog = null
        }
    }

    /***
     * @author : mehtabk
     * @created : July 30, 2018
     * @method name : isValidEmail
     * @Description : check for valid email.
     */
    fun isValidEmail(target: CharSequence?): Boolean {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    /***
     * @author : mehtabk
     * @created : July 30, 2018
     * @method name : hideKeyboard
     * @Description : used to hide the soft keyboard.
     */
    fun hideKeyboard(activity: Activity) {
        try {
            val view = activity.currentFocus
            if (view != null) {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}