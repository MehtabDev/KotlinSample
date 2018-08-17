package com.mehtabkotlin.view.activity

import android.annotation.TargetApi
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.mehtabkotlin.R
import com.mehtabkotlin.util.BUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.common_header.*

/**
 * Created by mehtabk on 7/14/2018.
 */
class BLoginActivity : BParentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setLayoutRef()
    }

    fun setLayoutRef() {
        loginButton.setOnClickListener(BCustomClickListener())
        forgetPasswordText.setOnClickListener(BCustomClickListener())
        registerText.setOnClickListener(BCustomClickListener())

    }

    /**
     * Created by mehtabk on 7/17/2018.
     * Description: Custom click listener handler class
     */
    inner class BCustomClickListener : View.OnClickListener {
        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.loginButton -> {
                    loginButtonClicked()
                }
                R.id.forgetPasswordText -> {
                    forgetPasswordClicked()
                }
                R.id.registerText -> {
                    registerButtonClicked()
                }
            }
        }
    }

    /**
     * Created by mehtabk on 7/17/2018.
     * Description: login button clicked, validate and call web API to verify the user.
     */
    fun loginButtonClicked() {

        when {
            emailPhoneEdit.text.toString().trim().isEmpty() -> {
                emailPhoneEdit.setError("Please enter valid value")
            }


            !BUtil.instance.isValidEmail(emailPhoneEdit.text.toString().trim()) -> {
                emailPhoneEdit.setError("Please enter valid emailId")
            }

        }

    }

    /**
     * Created by mehtabk on 7/17/2018.
     * Description: forget Password button clicked, open another view to enter email or phone for validation.
     */
    fun forgetPasswordClicked() {
        val loginIntent = Intent(this@BLoginActivity, BAddAddressActivity::class.java)
        startActivity(loginIntent)
        moveHead(this@BLoginActivity)
    }

    /**
     * Created by mehtabk on 7/17/2018.
     * Description: register Password button clicked, open another view to register new user.
     */
    fun registerButtonClicked() {
        val loginIntent = Intent(this@BLoginActivity, BRegisterActivity::class.java)
        startActivity(loginIntent)
        moveHead(this@BLoginActivity)
    }
}