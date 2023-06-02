package com.example.projectpraktikumpember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textview.MaterialTextView

class sharedpreferencess1 : AppCompatActivity() {
    private lateinit var textViewNama: MaterialTextView
    private lateinit var textViewPaket: MaterialTextView
    private lateinit var textViewBerat: MaterialTextView
    private lateinit var textViewHarga: MaterialTextView
    private lateinit var textViewTotalHarga: MaterialTextView


    private val REQUEST_CODE_ACTIVITY2 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreferencess1)


        // Inisialisasi komponen UI
        textViewNama = findViewById(R.id.nama2)
        textViewPaket = findViewById(R.id.paket2)
        textViewBerat = findViewById(R.id.berat2)
        textViewHarga = findViewById(R.id.harga2)
        textViewTotalHarga = findViewById(R.id.totalharga2)

        val pensil: FloatingActionButton = findViewById(R.id.pensil)
        pensil.setOnClickListener {
            val intent = Intent(this, SharedPreferencess2::class.java)

            // Mengirimkan data ke MainActivity2
            intent.putExtra("nama", textViewNama.text.toString())
            intent.putExtra("paket", textViewPaket.text.toString())
            intent.putExtra("berat", textViewBerat.text.toString())
            intent.putExtra("alamat", textViewHarga.text.toString())


            startActivityForResult(intent, REQUEST_CODE_ACTIVITY2)
        }
        val btnMainActivity2: Button = findViewById(R.id.btnkembali)
        btnMainActivity2.setOnClickListener {
            val intent = Intent(this@sharedpreferencess1, MainActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ACTIVITY2 && resultCode == RESULT_OK) {
            // Menerima data yang dikirimkan kembali dari MainActivity2
            val nama = data?.getStringExtra("nama")
            val paket = data?.getStringExtra("paket")
            val berat = data?.getIntExtra("berat",0)
            val harga = data?.getIntExtra("harga",0)
            val total = data?.getIntExtra("total harga",0)

            // Mengupdate nilai-nilai sharepreference
            textViewNama.text = nama
            textViewPaket.text = paket
            textViewBerat.text = berat.toString()
            textViewHarga.text = harga.toString()
            textViewTotalHarga.text = total.toString()
        }
    }
}