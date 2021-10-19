package com.timmy.startmodetest

import android.app.Activity
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class App : Application(), Application.ActivityLifecycleCallbacks {

    val activityList: MutableList<Activity> by lazy { mutableListOf() }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
        registerActivityLifecycleCallbacks(this)
        Timber.d("Timber初始化完成")

    }

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activityList.apply {
            add(0, activity)
            Timber.e("onActivityCreated,現在activity的內容有：$this")
        }

    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.e("Destroy的內容是:$activity")
        activityList.apply {
            remove(activity)
            Timber.e("onActivityDestroyed,現在activity的內容有：$this")
        }
    }

}