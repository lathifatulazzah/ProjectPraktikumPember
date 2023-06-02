package com.example.projectpraktikumpember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectpraktikumpember.data.AppDatabase
import com.example.projectpraktikumpember.data.entity.User
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class keranjang : AppCompatActivity() {
    private var formatTgl = "dd/MM/yyyy"

    private lateinit var tanggal: EditText
    private lateinit var nama: EditText
    private lateinit var paket: EditText
    private lateinit var berat: EditText
    private lateinit var harga: EditText
    private lateinit var btnSave: Button

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)
        // identifikasi view berdasarkan id
        tanggal = findViewById(R.id.tanggal)
        nama = findViewById(R.id.nama)
        paket = findViewById(R.id.paket)
        berat = findViewById(R.id.berat)
        harga = findViewById(R.id.harga)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            // menambah dat abaru
            val id = intent.getInt("id", 0)
            val user = database.UserDao().get(id)

            tanggal.setText(user.tanggal)
            nama.setText(user.nama)
            paket.setText(user.paket)
            berat.setText(user.berat)
            harga.setText(user.harga)
        }

        //btnsave klik
        btnSave.setOnClickListener {
            if (tanggal.text.isNotEmpty() && nama.text.isNotEmpty() && paket.text.isNotEmpty()
                && berat.text.isNotEmpty() && harga.text.isNotEmpty()) {
                if(intent!=null){
                    // coding edit data
                    database.UserDao().update(
                            User(
                                intent.getInt("id",0),
                                tanggal.text.toString(),
                                nama.text.toString(),
                                paket.text.toString(),
                                berat.text.toString(),
                                harga.text.toString()
                            )
                    )
                }else{
                    // coding untuk menambah data
                    database.UserDao().insertAll(
                        User(
                            null,
                            tanggal.text.toString(),
                            nama.text.toString(),
                            paket.text.toString(),
                            berat.text.toString(),
                            harga.text.toString()
                        )
                    )
                }
                finish()

            } else {
                Toast.makeText(applicationContext, "Silahkan isi semua data", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    // Click Input Date kalender
    fun InputDate(view: View) {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Masukkan Tanggal Lahir Kamu")
                .build()
        datePicker.show(supportFragmentManager, "DatePicker")

        datePicker.addOnPositiveButtonClickListener {
            val date = Date(it)
            val dateText = SimpleDateFormat(formatTgl, Locale.getDefault()).format(date).toString()
            tanggal.setText(dateText)

        }
    }
}