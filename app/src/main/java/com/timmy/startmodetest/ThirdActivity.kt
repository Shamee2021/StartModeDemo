package com.timmy.startmodetest

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.timmy.startmodetest.databinding.ActivityMainBinding

class ThirdActivity : BaseActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = (DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding).apply {
            title = "第三頁"

            btn1.setButtonTextAndAction(2)

            btn2.setButtonTextAndAction(1)

            tvNowList.text = getListToShow()
        }
    }


}