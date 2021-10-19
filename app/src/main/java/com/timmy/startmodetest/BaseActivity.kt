package com.timmy.startmodetest

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private fun getAllList() = (this.applicationContext as App).activityList

    fun getListToShow() = getAllList().toString().replace(",", "\n").filterNoUse()

}

fun String.filterNoUse() = this.replace(BuildConfig.APPLICATION_ID, "").replace(".", "")
