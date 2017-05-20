package com.kotlin.chao.util

import android.content.Context
import android.view.View

/**
 * 所有 View 及其子类内直接访问 ctx 属性来取代调用 getContext()
 * Created by Chao on 2017/5/20.
 */
public val View.ctx: Context
    get() = getContext()
