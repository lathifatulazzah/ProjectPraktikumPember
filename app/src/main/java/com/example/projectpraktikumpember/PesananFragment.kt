package com.example.projectpraktikumpember

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectpraktikumpember.adapter.UserAdapter
import com.example.projectpraktikumpember.data.AppDatabase
import com.example.projectpraktikumpember.data.entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PesananFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: UserAdapter
    private var list = mutableListOf<User>()
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pesanan, container, false)

        val button = view.findViewById<FloatingActionButton>(R.id.btn_tambah)
        button.setOnClickListener {
            val intent = Intent(activity, keranjang::class.java)
            startActivity(intent)
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_user)
        recyclerView.layoutManager = layoutManager
        fab = view.findViewById(R.id.btn_tambah)

        adapter = UserAdapter(list)
        adapter.setDialog(object: UserAdapter.Dialog{
            override fun onClick(position: Int) {
                // membuat dialog view
                val dialog = AlertDialog.Builder(requireContext())
                dialog.setTitle(list[position].nama)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{dialog,which ->
                    if (which == 0){
                        // codingan untuk ubah
                        val intent = Intent(requireContext(), keranjang::class.java)
                        intent.putExtra("id", list[position].uid)
                        startActivity(intent)
                    }else if (which == 1){
                        // codingan untuk hapus
                        database.UserDao().delete(list[position])
                        getData()
                    }else{
                        // codingan untuk batal
                        dialog.dismiss()
                    }
                })
                // untuk menampilkan dialog view
                val dialogView = dialog.create()
                dialogView.show()
            }

        })
        database = AppDatabase.getInstance(requireContext())
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

        fab.setOnClickListener{
            val intent = Intent(requireContext(), keranjang::class.java)
            requireActivity().startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.UserDao().getAll())
        adapter.notifyDataSetChanged()
    }


}