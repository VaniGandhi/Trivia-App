package com.triviaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.triviaapp.model.ColorModel
import com.triviaapp.R

class ColorsAdapter  (val context: Context, val list:ArrayList<ColorModel>):
    RecyclerView.Adapter<ColorsAdapter.Viewholder>() {

    private  var onClick:ColorsAdapter.onItemClick?=null

    private  var selectedlist=ArrayList<String>()
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

        holder.textView.text=list[position].string
        holder.itemView.setOnClickListener(View.OnClickListener { v ->
            if(!list[position].boolean)
            {
                holder.textView.background= ContextCompat.getDrawable(context, R.drawable.yellow_bg)
                selectedlist.add(list[position].string)
                list[position].boolean=true
                onClick!!.onItemClickListener(selectedlist)

            }
            else
            {
                holder.textView.background= ContextCompat.getDrawable(context, R.drawable.stroke_bg)
                selectedlist.remove(list[position].string)
                list[position].boolean=false
                onClick!!.onItemClickListener(selectedlist)

            }




        })


    }

    override fun getItemCount(): Int {
        return  list.size

    }

    interface  onItemClick{
        fun onItemClickListener(list: ArrayList<String>)
    }
}