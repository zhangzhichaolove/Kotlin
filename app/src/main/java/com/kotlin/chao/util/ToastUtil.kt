package com.kotlin.chao.util

import android.widget.Toast
import com.kotlin.chao.App

/**
 * 全局Toast工具类
 * Created by Chao on 2017/5/20.
 */
object ToastUtil {
    var toast = null as Toast?

    fun toast(msg: Any) {
        if (toast == null) {
            toast = Toast.makeText(App.instance, "", Toast.LENGTH_SHORT)
        }
        toast!!.setText(msg.toString())
        toast!!.show()
    }
}