package com.timmy.startmodetest

import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.lang.Exception

fun getActivityByIndex(index: Int) = when (index) {
    1 -> FirstActivity::class.java
    2 -> SecondActivity::class.java
    3 -> ThirdActivity::class.java
    else -> null
}

fun getCharByIndex(index: Int) = when (index) {
    0 -> "零"
    1 -> "一"
    2 -> "二"
    3 -> "三"
    4 -> "四"
    5 -> "五"
    6 -> "六"
    7 -> "七"
    8 -> "八"
    9 -> "九"
    else -> null
}

/**
 * 本App預設有三個頁面，供使用者設定：
 * 1 -> FirstActivity
 * 2 -> SecondActivity
 * 3 -> ThirdActivity
 * */
fun Button.setButtonTextAndAction(gotoIndex: Int) {
    text = "到第${getCharByIndex(gotoIndex)}頁"
    setOnClickListener {
        try {
            startActivity(this.context, Intent(this.context, getActivityByIndex(gotoIndex)), null)
        } catch (e: NullPointerException) {
            Toast.makeText(context, "跳到第${gotoIndex}頁失敗!，因為未設定對應的Activity。", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } catch (e:Exception){
            Toast.makeText(context, "跳到第${gotoIndex}頁失敗!，發生未知的錯誤，詳情請看Log。", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}