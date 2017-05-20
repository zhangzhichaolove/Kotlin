package com.kotlin.chao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_kotlin_test.setText("控件ID测试")
        btn_kotlin_test.setOnClickListener { toast("你点击了按钮!") }
        btn_kotlin_test.setOnClickListener { v: View -> toast("这个控件是：" + (v is LinearLayout)) }
    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
