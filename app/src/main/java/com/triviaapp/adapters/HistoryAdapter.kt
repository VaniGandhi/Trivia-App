package com.triviaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triviaapp.R
import com.triviaapp.model.DatabaseModel

class HistoryAdapter (val context: Context, val list:ArrayList<DatabaseModel>):
    RecyclerView.Adapter<HistoryAdapter.Viewholder>() {



    inner  class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvGameNo=itemView.findViewById<TextView>(R.id.tvGameNo)
        var tvName=itemView.findViewById<TextView>(R.id.tvName)
        var tvAns1=itemView.findViewById<TextView>(R.id.tvAns1)
        var tvAns2=itemView.findViewById<TextView>(R.id.tvAns2)
        var tvDateAndTime=itemView.findViewById<TextView>(R.id.tvDateAndTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(context).inflate(
                R.layout.item_summary,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.tvGameNo.text= "Game ${position.plus(1)} :"
        holder.tvName.text=list[position].name
        holder.tvAns1.text=list[position].answer1
        holder.tvAns2.text=list[position].answer2
        holder.tvDateAndTime.text="${list[position].date} ${list[position].time}"


    }

    override fun getItemCount(): Int {
        return  list.size

    }


}