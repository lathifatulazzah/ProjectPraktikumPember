package com.example.projectpraktikumpember

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val button =view?.findViewById<Button>(R.id.wa)
        button?.setOnClickListener {
            val phoneNumber = "62881026446395" // nomor telepon penerima
            val message = "Selamat Datang di Aplikasi Laundry. " +
                    " " +
                    "Silahkan isi from berikut ini, agar prosesnya lebih mudah. " +
                    " " +
                    "NAMA  :  " +
                    " " +
                    "ALAMAT: " +
                    " " +
                    "Email : " +
                    " " // pesan yang akan dikirim
            val url =
                "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}" // URL untuk membuka aplikasi WhatsApp
            try { // coba membuka aplikasi WhatsApp
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                // tampilkan pesan error jika aplikasi WhatsApp tidak ditemukan
                showToast("Aplikasi WhatsApp tidak ditemukan!")

            }
        }

        return view
    }

    private fun showToast (message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()
    }


}