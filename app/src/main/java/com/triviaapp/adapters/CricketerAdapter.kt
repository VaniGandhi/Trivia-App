package com.triviaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.triviaapp.R

class CricketerAdapter (val context: Context, val list:ArrayList<String>):
    RecyclerView.Adapter<CricketerAdapter.Viewholder>() {

    private  var onClick:onItemClick?=null
    private var row_index: Int=0
    private var isSelected:Boolean=false
    fun setOnClickListener(onItemClick: onItemClick)
    {
        this.onClick=onItemClick
    }

    inner  class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView=itemView.findViewById<TextView>(R.id.textView1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(context).inflate(
                R.layout.item_cricketer,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.textView.text=list[position]
        holder.itemView.setOnClickListener(View.OnClickListener { v ->
            isSelected = true
            row_index = position
            notifyDataSetChanged()
            onClick!!.onItemClickListener(list[position])



        })
        if (isSelected) {
            if (row_index == position) {

                holder.textView.background=ContextCompat.getDrawable(context, R.drawable.yellow_bg)

            } else {
                holder.textView.background=ContextCompat.getDrawable(context, R.drawable.stroke_bg)
            }
        }


    }

    override fun getItemCount(): Int {
        return  list.size

    }

    interface  onItemClick{
        fun onItemClickListener(string: String)
    }
}