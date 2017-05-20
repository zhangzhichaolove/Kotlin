package com.kotlin.chao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.chao.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by Chao on 2017/5/20.
 */
public class ListActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var datas: MutableList<String>? = null

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
    }

    public fun getData(): Unit {
        datas = ArrayList<String>()
        for (i in 1..100) {
            datas!!.add("这是模拟数据" + i.toString())
        }
    }

}