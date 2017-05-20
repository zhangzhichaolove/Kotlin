package com.kotlin.chao.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.kotlin.chao.R

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
            itemView.setOnClickListener({ v -> Toast.makeText(itemView.context, mTextView.text, Toast.LENGTH_SHORT).show() })
        }
    }

//    public interface onItemClick{
//         onclick();
//    }
}