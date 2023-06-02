package com.example.projectpraktikumpember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val imageView1 = view.findViewById<ImageView>(R.id.imageView2)
        imageView1.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Setrika Rp.5.000/kg", Toast.LENGTH_SHORT).show()
        }
        val imageview2 = view.findViewById<ImageView>(R.id.imageView3)
        imageview2.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Kering Rp.5.000/kg", Toast.LENGTH_SHORT).show()
        }
        val imageview3 = view.findViewById<ImageView>(R.id.imageView4)
        imageview3.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Sepatu Rp.15.000/pasang", Toast.LENGTH_SHORT).show()
        }
        val imageview4 = view.findViewById<ImageView>(R.id.imageView5)
        imageview4.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Boneka Rp.15.000/kg", Toast.LENGTH_SHORT).show()
        }
        val imageview5 = view.findViewById<ImageView>(R.id.imageView6)
        imageview5.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Selimut Rp.5.000/kg", Toast.LENGTH_SHORT).show()
        }
        val imageview6 = view.findViewById<ImageView>(R.id.imageView7)
        imageview6.setOnClickListener {
            Toast.makeText(requireContext(), "Cuci Gordean Rp.5.000/kg", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}

