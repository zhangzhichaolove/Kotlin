package com.kotlin.chao.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.chao.R
import com.kotlin.chao.util.ToastUtil.toast

public class RecyclerAdapter(val datas: MutableList<String>?) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(recyclerViewHolder: RecyclerViewHolder, i: Int) {
        recyclerViewHolder.mTextView.setText(datas!!.get(i))
    }

    override fun getItemCount(): Int {
        return datas!!.size
    }

    public class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var mTextView: TextView

        init {
            mTextView = itemView.findViewById(R.id.mTextView) as TextView
            itemView.setOnClickListener({ v -> toast(mTextView.text) })
        }
    }

//    public interface onItemClick{
//         onclick();
//    }
}