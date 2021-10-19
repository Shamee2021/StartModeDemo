package com.timmy.startmodetest

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.timmy.startmodetest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = (DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding).apply {
            title = "第一頁"

            btn1.setButtonTextAndAction(2)

            btn2.isVisible = false

            tvNowList.text = getListToShow()
        }
    }
}