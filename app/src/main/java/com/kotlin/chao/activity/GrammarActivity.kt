package com.kotlin.chao.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.chao.R
import com.kotlin.chao.util.ToastUtil.toast
import com.kotlin.chao.util.e
import kotlinx.android.synthetic.main.activity_grammar.*

class GrammarActivity : AppCompatActivity() {
//    val a: Int = 1  // 立即赋值
//    val b = 2   // 自动推断出 `Int` 类型
//    val c: Int  // 如果没有初始值类型不能省略
//    c = 3       // 明确赋值

//    var x = 5 // 自动推断出 `Int` 类型
//    x += 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar)
        setTitle("语法展示")
        btn_noneBack.setOnClickListener { sum(3, 5) }
        btn_noneBack.setOnLongClickListener {
            sum2(5, 6)
            true
        }
        btn_Back.setOnClickListener { toast(sum3(3, 5)) }
        btn_Back.setOnLongClickListener {
            sum5(7, 8)
            true
        }
        btn_string.setOnClickListener {
            var a = 1
            // 模板中的简单名称：
            val s1 = "a is $a"
            a = 2
            // 模板中的任意表达式：
            val s2 = "${s1.replace("is", "was")}, but now is $a"
            toast(s2)
        }
        btn_if_else.setOnClickListener {
            toast(maxOf(78, 87))
        }
        btn_if_null.setOnClickListener {
            toast(parseInt("18")!!)
        }
        btn_if_null.setOnLongClickListener {
            printProduct("15", "18")
            true
        }
//        val items = listOf("apple", "banana", "kiwi")
//        for (item in items) {
//            println(item)
//        }
        btn_if_for.setOnClickListener {
            val items = listOf("apple", "banana", "kiwi")
            for (index in items.indices) {
                e("item at $index is ${items[index]}")
            }
        }
        btn_if_while.setOnClickListener {
            val items = listOf("apple", "banana", "kiwi")
            var index = 0
            while (index < items.size) {
                e("item at $index is ${items[index]}")
                index++
            }
        }
        btn_if_when.setOnClickListener {
            toast(describe(20170818))
        }
        btn_if_range.setOnClickListener {
            val x = 10
            val y = 9
            if (x in 1..y + 1) {
                toast("fits in range")
            }
        }
        btn_if_range.setOnLongClickListener {
            //区间迭代
            for (x in 1..5) {
                e(x)
            }
            true
        }
        btn_if_step.setOnClickListener {
            for (x in 1..10 step 2) {
                e(x)
            }
            for (x in 9 downTo 0 step 3) {//倒叙遍历
                e(x)
            }
        }
        btn_if_in.setOnClickListener {
            //使用 in 运算符来判断集合内是否包含某实例
            val items = listOf("juicy", "apple", "c")
            when {
                "orange" in items -> e("juicy")
                "apple" in items -> e("apple is fine too")
            }
        }
        btn_if_lambda.setOnClickListener {
            //使用 lambda 表达式来过滤（filter）和映射（map）集合
            val items = listOf("juicy", "apple", "c")
            items
                    .filter { it.startsWith("a") }//前缀过滤
                    .sortedBy { it }
                    .map { it.toUpperCase() }//转换大写
                    .forEach { e(it) }
        }


    }

    fun sum(a: Int, b: Int) {
        toast("计算$a+$b=" + (a + b))
    }

    fun sum2(a: Int, b: Int): Unit {//Unit 返回类型可以省略
        toast("计算$a+$b=${a + b}")
    }


    fun sum3(a: Int, b: Int): Int {
        return a + b
    }


    fun sum4(a: Int, b: Int) = a + b//返回值类型自动推断的函数

    fun sum5(a: Int, b: Int) = toast("sum of $a and $b is ${a + b}")

    fun maxOf(a: Int, b: Int): Int {//条件表达式
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    //fun maxOf(a: Int, b: Int) = if (a > b) a else b

    //==”与“===”是不同的，一个是判断值是否相等，一个是判断值及类型是否完全相等

    //${'$'}9.99 //打印之后是：$9.99

    fun parseInt(str: String?): Int? {//当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。 如果 str 的内容不是数字返回 null：
        val b = str?.toInt() ?: 2//如果str为null 返回2
        val a = str?.length ?: -1//如果 ?: 左边表达式非空，elvis操作符就会返回左边的结果，否则返回右边的结果。
        val boxedA: Int? = a //?=意味着boxedA可以为空
        val m: Int? = str as? Int//当使用 as 转型的时候，可能会经常出现 ClassCastException。 所以，现在可以使as?安全转型，当转型不成功的时候，它会返回 null。
        return b
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        // 直接使用 `x * y` 可能会报错，因为他们可能为 null
        if (x != null && y != null) {
            // 在空检测后，x 和 y 会自动转换为非空值（non-nullable）
            toast(x * y)
        } else {
            toast("either '$x' or '$y' is not a number")
        }
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件分支内自动转换成 `String`
            return obj.length
        }
        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        return null
    }
//    fun getStringLength(obj: Any): Int? {
//        if (obj !is String) return null
//
//        // `obj` 在这一分支自动转换为 `String`
//        return obj.length
//    }
//fun getStringLength(obj: Any): Int? {
//    // `obj` 在 `&&` 右边自动转换成 `String` 类型
//    if (obj is String && obj.length > 0) ｛
//    return obj.length
//}
//
//    return null
//}

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

}
