package com.kotlin.chao

import android.app.Application

/**
 * Application
 * Created by Chao on 2017/5/20.
 */
public class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instanceTmp = this
    }

    companion object {
        private var instanceTmp: App? = null
        //通过 lazy delegate 来对 instane 进行懒赋值（直到首次调用再进行赋值）
        public val instance: App by lazy {
            instanceTmp!!
        }
    }
}