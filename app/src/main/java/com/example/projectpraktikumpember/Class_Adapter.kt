package com.example.projectpraktikumpember

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Class_Adapter (
    private val Datadata: ArrayList<Isidata>
): RecyclerView.Adapter<Class_Adapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Class_Adapter.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view,
            parent, false
        )
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Class_Adapter.CourseViewHolder, position: Int) {
        holder.nama.text = Datadata.get(position).nama
        holder.harga.text = Datadata.get(position).harga
        holder.foto.setImageResource(Datadata.get(position).foto)
    }

    override fun getItemCount(): Int {
        return Datadata.size
    }
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto: ImageView = itemView.findViewById(R.id.IVfoto)
        val nama: TextView = itemView.findViewById(R.id.TVnama)
        val harga: TextView = itemView.findViewById(R.id.TVharga)
    }
}