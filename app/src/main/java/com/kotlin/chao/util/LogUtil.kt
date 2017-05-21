package com.kotlin.chao.util

/**
 * Created by Chao on 2017/5/20.
 */
import android.util.Log

inline fun <reified T> T.d(log: Any?) {
    Log.d(T::class.simpleName, log.toString())
}

inline fun <reified T> T.e(log: Any?) {
    Log.e(T::class.simpleName, log.toString())
}