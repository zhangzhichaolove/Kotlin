package com.kotlin.chao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.chao.adapter.RecyclerAdapter
import com.kotlin.chao.util.Preference
import com.kotlin.chao.util.ToastUtil.toast
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by Chao on 2017/5/20.
 */
public class ListActivity : AppCompatActivity() {
    //Kotlin的空安全设计，主要是在类型后面加？表示可空，否则就不能为null。
    private var mRecyclerView: RecyclerView? = null
    private var datas: MutableList<String>? = null
    var aInt: Int by Preference("aInt", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        getData()

        setTitle("Hello Kotlin")
        textView.setText("Hello Kotlin")

        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.addItemDecoration(DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL))
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        var adapter: RecyclerAdapter = RecyclerAdapter(datas)
        mRecyclerView!!.setAdapter(adapter)

        whatever()
    }

    public fun getData(): Unit {
        datas = ArrayList<String>()
        for (i in 1..100) {
            datas!!.add("这是模拟数据" + i.toString())
        }
    }

    fun whatever() {
        toast(aInt)//会从SharedPreference取这个数据
        aInt = 9 //会将这个数据写入SharedPreference
    }

}