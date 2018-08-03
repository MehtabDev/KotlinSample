package com.mehtabkotlin.view.activity

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.mehtabkotlin.drawer.BDrawerAdapter
import com.mehtabkotlin.drawer.BSlidingRootNavBuilder
import com.mehtabkotlin.interactor.BDashboardInteractor
import com.mehtabkotlin.presenter.BDashboardPresenter
import com.mehtabkotlin.view.fragment.BHomeFragment
import com.yarolegovich.slidingrootnav.SlidingRootNav
import kotlinx.android.synthetic.main.activity_dashboard_shop.*
import android.content.Intent
import com.mehtabkotlin.R


class BDashboardShopActivity : BParentActivity(), BDrawerAdapter.OnItemSelectedListener, BDashboardInteractor {

    private var mSlidingRootNav: SlidingRootNav? = null
    private var mDrawerList: RecyclerView? = null
    private var mDrawerAdapter: BDrawerAdapter? = null
    private var mScreenIcons: Array<Drawable?>? = null
    private var mScreenTitles: Array<String>? = null
    private val mDashboardPresenter = BDashboardPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_shop)
        showFragment(BHomeFragment(), false)
        setSupportActionBar(toolbar)
        setTitle("Mehtab")
        mDashboardPresenter.attachView(this)
        initSlidingRootNav(savedInstanceState)
        mScreenIcons = mDashboardPresenter.loadScreenIcons() // load drawer icons
        mScreenTitles = loadScreenTitles() // load drawer titles
        mDashboardPresenter.initDrawerAdapter() // Initialize drawer adapter

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_notification ->
                return true
            R.id.action_shop_cart ->

                return true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * user : mehtabk
     * date : July 9, 2018
     * description : Initialize sliding root navigation for drawer menu
     */
    private fun initSlidingRootNav(savedInstanceState: Bundle?) {

        mSlidingRootNav = BSlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject()
//        SUtil.instance.setImage(applicationContext,SUtil.instance.getLoginDetails()?.profileImage!!,user_img)

    }

    override fun onItemSelected(position: Int) {
        mSlidingRootNav!!.closeMenu()
        when (position) {
            MEN_CAT -> {
                val loginIntent = Intent(this@BDashboardShopActivity, BLoginActivity::class.java)
                startActivity(loginIntent)

/*
                showFragment(SHomeFragment(), false)
                mBottomNavigation?.selectTab(POS_HOME)
                SUtil.instance.hideKeyboard(this)
                clearBackStack()*/

            }

        }
    }

    /**
     * user : mehtabk
     * date : July 9, 2018
     * description : for showing fragment
     */
    fun showFragment(fragment: Fragment, backStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .add(R.id.viewContainer, fragment)
        if (backStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
                    .commit()


        } else {
            fragmentTransaction.commit()
        }


    }

    companion object {

        const val MEN_CAT = 0
        const val WOMEN_CAT = 1
        const val KIDS = 2
        const val BEAUTY = 3
        const val SPORT_BOOK = 4
        const val OFFER = 5
        const val MY_REWARDS = 6

        const val MY_CART = 7
        const val MY_WISHLIST = 8
        const val MY_ORDERS = 9
        const val MY_ACCOUNT = 10
        const val MY_SETTING = 11


    }

    override fun getContext(): Context {
        return applicationContext
    }

    override fun setDrawerListener(mDrawerAdapter: BDrawerAdapter?) {
        mDrawerAdapter!!.setListener(this)
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun setDrawerListAdapter(mDrawerAdapter: BDrawerAdapter?) {
        mDrawerList = findViewById(R.id.list)

        mDrawerList!!.isNestedScrollingEnabled = false
        mDrawerList!!.layoutManager = LinearLayoutManager(this)
        mDrawerList!!.adapter = mDrawerAdapter
        this.mDrawerAdapter = mDrawerAdapter
    }

    override fun onSuccessResponse() {

    }

    override fun onFailureResponse(error: String) {

    }

    private fun loadScreenTitles(): Array<String> {
        return resources.getStringArray(R.array.ld_activityScreenTitles)
    }
}
