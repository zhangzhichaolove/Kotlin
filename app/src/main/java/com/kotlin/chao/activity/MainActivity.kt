package com.kotlin.chao.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.kotlin.chao.App
import com.kotlin.chao.R
import com.kotlin.chao.activity.GrammarActivity
import com.kotlin.chao.activity.OtherActivity
import com.kotlin.chao.java.JavaClass
import com.kotlin.chao.util.ToastUtil.toast
import com.kotlin.chao.util.ctx
import com.kotlin.chao.util.e
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val btn_kotlin_id: TextView by lazy {
        findViewById(R.id.btn_kotlin_id) as TextView
    }
// lazy是Kotlin的属性代理的一个实例，它提供了延迟加载的机制。换句话说，这里的lazy提供了初始化aTextView的方法，不过真正初始化这个动作发生的时机却是在aTextView第一次被使用时了。
// lazy默认是线程安全的，你当然也可以关掉这个配置，只需要加个参数即可：
//    private val btn_kotlin_id: TextView by lazy(LazyThreadSafetyMode.NONE){
//        findViewById(R.id.btn_kotlin_id) as TextView
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        e("程序启动...")
        e(MainActivity::class)
        setContentView(R.layout.activity_main)
        btn_kotlin_id.setText("我是红色字体")
        btn_kotlin_id.setTextColor(Color.RED)
        btn_kotlin_test.text = "控件ID测试"
        btn_kotlin_test!!.textSize = 14f
        btn_kotlin_test.setOnClickListener { toast("你点击了按钮!") }
        btn_kotlin_test.setOnClickListener { v: View -> toast("这个控件是LinearLayout吗？" + (v is LinearLayout)) }
        btn_list_test.setOnClickListener({ v: View -> startActivity(Intent(MainActivity@ this, ListActivity::class.java)) })
        val x = 10
        when (x) {
            in 1..10 -> e("x is in the range")//x是在范围之内
            !in 15..20 -> e("x is outside the range")//x是在范围之外
            else -> e("none of the above")//以上都不是
        }

        val list = arrayListOf(1, 2, 3, 4, 5)
        val doubleList = list.map {
            it * 2
        }.toList()
        e(doubleList)//doubleList = [2,4,6,8,10]
        val oddList = list.filter {
            it % 2 == 1
        }
        e(oddList) //oddList = [1,3,5]
        //将list挨个打印出来
        list.forEach {
            e(it)
        }

        //调用JAVA
        val javaClass = JavaClass()
        javaClass.anInt = 5
        e(javaClass.anInt)

        val nullable: Int? = 0
        val nonNullable: Int = 2
        //nullable.toFloat() // 编译错误
        //e(nullable?.toFloat()) // 如果null，什么都不做，否则调用toFloat
        e(nullable!!.toFloat()) // 强制转换为非空对象，并调用toFloat；如果nullable为null，抛空指针异常
        e(nonNullable.toFloat()) // 正确

        e(App.instance)
        e(btn_kotlin_id.ctx)

        btn_grammar.setOnClickListener({ v -> startActivity(Intent(MainActivity@ this, GrammarActivity::class.java)) })
        btn_other.setOnClickListener({ v -> startActivity(Intent(MainActivity@ this, OtherActivity::class.java)) })

    }


    //实际上就是创建一个ArrayList
//    val list = arrayListOf(1,2,3,4)
//    list.add(5)
//    list.remove(3)
//    for(item in list){
//        println(item)
//    }
}
