package com.kotlin.chao.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.chao.R
import com.kotlin.chao.util.ToastUtil.toast
import com.kotlin.chao.util.e
import kotlinx.android.synthetic.main.activity_other.*
import java.io.File

class OtherActivity : AppCompatActivity() {
    val list = listOf("juicy", "apple", "c")//只读 list
    val map = mapOf("a" to 1, "key" to 2, "c" to 3)//只读 map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        setTitle("扩展语法")
        btn_default.setOnClickListener {
            foo(5, "123")
        }
        btn_list.setOnClickListener {
            //过滤掉不符合条件的数据
            //val positives = list.filter { x -> x.length > 3 }
            val positives = list.filter { it.length > 3 }
            e(positives)
        }
        btn_string.setOnClickListener {
            toast("List= $list")
        }
        btn_map.setOnClickListener {
            //遍历 map/pair型list
            for ((k, v) in map) {
                e("$k -> $v")
            }
            toast(map["key"].toString())
            //map["key"] = 2
        }
        btn_lazy.setOnClickListener {
            val p: String by lazy {
                "延迟属性"
            }
            toast(p)
        }
        btn_add.setOnClickListener {
            toast("Convert this to camelcase".spaceToCamelCase())
        }
        btn_inst.setOnClickListener {
            e(Resource)
            e(Resource)
            toast(Resource === Resource)
        }
        btn_Ifnotnull.setOnClickListener {
            //If not null 缩写
            val files = File("Test").listFiles()
            e(files?.size)
            //If not null and else 缩写
            val filess = File("Test").listFiles()
            e(filess?.size ?: "empty")
            //if null 执行一个语句
            data class User(var name: String? = "key", var age: Int? = 0)
            //fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
            val data = User("name", 10)
            val email = data.name ?: throw IllegalStateException("Email is missing!")
            data?.let {
                toast(data) // 代码会执行到此处, 假如data不为null
            }
        }
    }

    fun foo(a: Int = 0, b: String = "") {
        toast(a * b.length)
    }

    fun String.spaceToCamelCase(): String {
        return toUpperCase()
    }

    //创建单例
    object Resource {
        val name = "Name"
    }

    //返回when表达式
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    //“try/catch”表达式
    fun test() {
        val result = try {
            e("--------")
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }

        // 使用 result
    }

    //“if”表达式
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    //返回类型为 Unit 的方法的 Builder 风格用法
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    //单表达式函数与其它惯用法一起使用能简化代码，例如和 when 表达式一起使用：
    fun transforms(color: String): Int = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    //对于需要泛型信息的泛型函数的适宜形式
    //inline fun <reified T : Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)

    fun testBoolean() {
        //使用可空布尔
        val b: Boolean? = null
        if (b == true) {
            e(b)
        } else {
            // `b` 是 false 或者 null
        }
    }
}
