package com.example.projectpraktikumpember

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList

class KategoriFragment : Fragment() {


    lateinit var recycle: RecyclerView
    lateinit var recycleAdapter: Class_Adapter
    lateinit var listData: ArrayList<Isidata>

    lateinit var image : Array<Int>
    lateinit var nama : Array<String>
    lateinit var harga : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)

        val button = view.findViewById<FloatingActionButton>(R.id.fab_cart)
        button.setOnClickListener {
            val intent = Intent(activity, sharedpreferencess1::class.java)
            startActivity(intent)
        }
        return view


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recycle = view.findViewById(R.id.idRecycle)
        recycle.layoutManager = layoutManager
        recycle.setHasFixedSize(true)
        recycleAdapter = Class_Adapter(listData)
        recycle.adapter = recycleAdapter
    }
    private fun dataInitialize(){
        listData = arrayListOf<Isidata>()

        image = arrayOf(
            R.drawable.setrika,
            R.drawable.mesin,
            R.drawable.sptu,
            R.drawable.boneka,
            R.drawable.selimut,
            R.drawable.gorden1,
//            tambah
            R.drawable.setrika,
            R.drawable.mesin,
            R.drawable.sptu,
            R.drawable.boneka,
            R.drawable.selimut,
            R.drawable.gorden1,
        )
        nama = arrayOf(
            getString(R.string.nama1),
            getString(R.string.nama2),
            getString(R.string.nama3),
            getString(R.string.nama4),
            getString(R.string.nama5),
            getString(R.string.nama6),
//            tambah
            getString(R.string.nama1),
            getString(R.string.nama2),
            getString(R.string.nama3),
            getString(R.string.nama4),
            getString(R.string.nama5),
            getString(R.string.nama6),
        )
        harga = arrayOf(
            getString(R.string.Harga1),
            getString(R.string.Harga2),
            getString(R.string.Harga3),
            getString(R.string.Harga4),
            getString(R.string.Harga5),
            getString(R.string.Harga6),
//            tambah
            getString(R.string.Harga1),
            getString(R.string.Harga2),
            getString(R.string.Harga3),
            getString(R.string.Harga4),
            getString(R.string.Harga5),
            getString(R.string.Harga6),
        )
        for (i in image.indices){
            val isidata = Isidata(image[i],nama[i], harga[i])
            listData.add(isidata)
        }
    }
}