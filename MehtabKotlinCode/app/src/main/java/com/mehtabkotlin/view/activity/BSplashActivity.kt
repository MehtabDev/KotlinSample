package com.mehtabkotlin.view.activity

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.mehtabkotlin.BuildConfig
import com.mehtabkotlin.R
import com.mehtabkotlin.constant.BConstant
import com.mehtabkotlin.util.BUtil

/**
 * Created by mehtabk on 7/6/2018.
 */
class BSplashActivity : BParentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        BUtil.instance.allowAllPermissions(this, object : MultiplePermissionsListener {

            override fun onPermissionsChecked(report: MultiplePermissionsReport?) {

                when {
                    report!!.areAllPermissionsGranted() -> splashDelay()
                    report.isAnyPermissionPermanentlyDenied -> {
                        val onPositiveClick: DialogInterface.OnClickListener = DialogInterface.OnClickListener { dialog, which ->
                            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.parse(getString(R.string.package_name) + BuildConfig.APPLICATION_ID)))
                            finish()
                        }
                        BUtil.instance.showAlertDialog(this@BSplashActivity, getString(R.string.permission_required),
                                getString(R.string.permission_message), onPositiveClick)
                    }
                    else -> finish()
                }

            }

            override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {
                token?.continuePermissionRequest()
            }
        })

    }

    /**
     * user : mehtabk
     * date : July 6, 2018
     * description : this function is used for delay time for 3 second on splash screen
     */
    private fun splashDelay() {

        Handler().postDelayed({
            val mainIntent: Intent = Intent(this@BSplashActivity, BChooserActivity::class.java)
            startActivity(mainIntent)
            finish()
            moveHead(this@BSplashActivity)
        }, BConstant.SPLASH_DELAY_TIME)
    }

}