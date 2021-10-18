package com.example.recyclerviewexample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.ui.model.AdapterModel
import com.example.recyclerviewexample.ui.model.AdapterTypes

class NotesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var notes = emptyList<AdapterModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
       when(viewType){
           AdapterTypes.MONTH.ordinal -> MonthViewHolder(
               LayoutInflater.from(parent.context).inflate(R.layout.rv_month, parent, false)
           )
           AdapterTypes.DAY.ordinal -> DayViewHolder(
               LayoutInflater.from(parent.context).inflate(R.layout.rv_day, parent, false)
           )
           else -> NoteViewHolder(
               LayoutInflater.from(parent.context).inflate(R.layout.rv_note, parent, false)
           )
       }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            AdapterTypes.MONTH.ordinal ->
                (holder as MonthViewHolder).bind(notes[position].content as String)
            AdapterTypes.DAY.ordinal ->
                (holder as DayViewHolder).bind(notes[position].content as Int)
            AdapterTypes.NOTE.ordinal ->
                (holder as NoteViewHolder).bind(notes[position].content as String)
        }
    }

    override fun getItemCount(): Int = notes.size

    override fun getItemViewType(position: Int): Int = notes[position].type.ordinal

    class MonthViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind( month: String ){
            itemView.findViewById<TextView>(R.id.month).text = month
        }
    }

    class DayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind( day: Int ){
            itemView.findViewById<TextView>(R.id.day).text =
                itemView.context.getString(R.string.label_day, day)
        }
    }

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind( content: String ){
            itemView.findViewById<TextView>(R.id.content).text = content
        }
    }
}