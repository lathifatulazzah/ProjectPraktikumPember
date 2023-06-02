package com.example.projectpraktikumpember.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// Entitas User atau tabel user
@Entity
data class User (
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "tanggal") var tanggal: String? = null,
    @ColumnInfo(name = "nama") var nama: String? = null,
    @ColumnInfo(name = "paket") var paket: String? = null,
    @ColumnInfo(name = "berat") var berat: String? = null,
    @ColumnInfo(name = "harga") var harga: String? = null,
)

