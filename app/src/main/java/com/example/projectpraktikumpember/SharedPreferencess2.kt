package com.example.projectpraktikumpember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SharedPreferencess2 : AppCompatActivity() {
    // deklarasi view berdasarkan tipenya
    private lateinit var inputNama: TextInputLayout
    private lateinit var inputNamaValue: TextInputEditText
    private lateinit var inputPaket: TextInputLayout
    private lateinit var inputPaketValue: TextInputEditText
    private lateinit var inputBerat: TextInputLayout
    private lateinit var inputBeratValue: TextInputEditText
    private lateinit var inputHarga: TextInputLayout
    private lateinit var inputHargaValue: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferencess2)

        // deklarasi view berdasarkan id
        inputNama = findViewById(R.id.textInput_nama)
        inputNamaValue = findViewById(R.id.editTextNama)
        inputPaket = findViewById(R.id.textInput_paket)
        inputPaketValue = findViewById(R.id.editTextPaket)
        inputBerat= findViewById(R.id.textInput_berat)
        inputBeratValue = findViewById(R.id.editTextBerat)
        inputHarga = findViewById(R.id.textInput_harga)
        inputHargaValue = findViewById(R.id.editTextHarga)

        // Mendapatkan nilai default dari Intent
        val nama = intent.getStringExtra("nama")
        val paket = intent.getStringExtra("paket")
        val berat = intent.getStringExtra("berat")
        val alamat = intent.getStringExtra("alamat")

        // Menampilkan nilai default di inputan
        inputNamaValue.setText(nama)
        inputPaketValue.setText(paket)
        inputBeratValue.setText(berat)
        inputHargaValue.setText(alamat)


        val fab: FloatingActionButton = findViewById(R.id.fab2)
        fab.setOnClickListener {
            // Mendapatkan nilai dari input
            val nama: String = inputNamaValue.text.toString()
            val paket: String = inputPaketValue.text.toString()
            val berat = inputBeratValue.text.toString().toInt()
            val harga = inputHargaValue.text.toString().toInt()
            val total = berat * harga

            // Mengirim data kembali ke activity pertama
            val intent = Intent()
            intent.putExtra("nama", nama)
            intent.putExtra("paket", paket)
            intent.putExtra("berat", berat)
            intent.putExtra("harga", harga)
            intent.putExtra("total harga",total)
            setResult(RESULT_OK, intent)
            finish()
        }
        }

}

