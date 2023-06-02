package com.example.projectpraktikumpember.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectpraktikumpember.data.entity.User
import com.example.projectpraktikumpember.R

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var  dialog: Dialog
    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }
    interface Dialog{
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tanggal : TextView
        var nama : TextView
        var paket : TextView
        var berat : TextView
        var harga : TextView

        init{
            tanggal = view.findViewById(R.id.tanggal)
            nama = view.findViewById(R.id.nama)
            paket = view.findViewById(R.id.paket)
            berat = view.findViewById(R.id.berat)
            harga = view.findViewById(R.id.harga)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_user,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tanggal.text = list[position].tanggal
        holder.nama.text = list[position].nama
        holder.paket.text = list[position].paket
        holder.berat.text = list[position].berat
        holder.harga.text = list[position].harga
    }
}