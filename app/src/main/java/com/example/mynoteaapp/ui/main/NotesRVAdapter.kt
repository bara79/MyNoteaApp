package com.example.mynoteaapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mynoteaapp.R
import kotlinx.android.synthetic.main.item_note.view.*
import com.example.mynoteaapp.data.entity.Note
import java.lang.reflect.Array.set


class NotesRVAdapter(val onItemClick: ((Note) -> Unit)? = null) :
    RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {


    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView) {
            tv_title.text = note.title
            tv_text.text = note.text

            val color = when (note.color) {
                Note.Color.WHITE -> R.color.color_white
                Note.Color.VIOLET -> R.color.color_violet
                Note.Color.YELLOW -> R.color.color_yellow
                Note.Color.RED -> R.color.color_red
                Note.Color.PINK -> R.color.color_pink
                Note.Color.GREEN -> R.color.color_green

            }
            setBackgroundColor(ContextCompat.getColor(itemView.context, color))

            itemView.setOnClickListener {
                onItemClick?.invoke(note)
            }
        }
    }
}