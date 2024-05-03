package com.example.kotlinsecond

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsecond.model.Todo
import com.squareup.picasso.Picasso

class MyAdapter(val list: ArrayList<Todo>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_recyclerview_item, parent, false)
        return MyViewholder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.text.setText(list.get(position).title)
        Picasso.get().load(list.get(position).url).placeholder(R.drawable.ic_launcher_background).into(holder.image)

        if (list.get(position).isSelected == true) {
            holder.text.setBackgroundColor(context.getColor(android.R.color.darker_gray))
        } else {
            holder.text.setBackgroundColor(context.getColor(android.R.color.holo_blue_bright))
        }

        holder.text.setOnClickListener {
            if (list.get(position).isSelected == true) {
                list.get(position).isSelected = false
            } else {
                list.get(position).isSelected = true
            }
            notifyItemChanged(position)
        }
    }

    class MyViewholder(view: View) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById(R.id.text)
        var image: ImageView = view.findViewById(R.id.img)


    }

}