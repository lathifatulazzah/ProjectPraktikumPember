package com.example.projectpraktikumpember.data.dao

import androidx.room.*
import com.example.projectpraktikumpember.data.entity.User

// untuk membuat query nya
@Dao
interface UserDao {
    //mengambil semua data pada user
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    // mengambil data berdasarkan user id
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    // menambah data
    @Insert
    fun insertAll(vararg users: User)

    // menghapus data
    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE uid = :uid")
    fun get(uid: Int) : User

    @Update
    fun update(user: User)
}