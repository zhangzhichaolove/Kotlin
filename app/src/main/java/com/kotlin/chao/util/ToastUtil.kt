package com.kotlin.chao.util

import android.widget.Toast
import com.kotlin.chao.App

/**
 * 全局Toast工具类
 * Created by Chao on 2017/5/20.
 */
fun toast(msg: Any) {
    Toast.makeText(App.instance, msg.toString(), Toast.LENGTH_SHORT).show()
}