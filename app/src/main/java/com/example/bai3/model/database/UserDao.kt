package com.example.bai3.model.database

import androidx.room.*
import com.example.bai3.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

   @Query("UPDATE user_table SET name = :name, phone =:phone WHERE id = :id")
    fun update(id:Int,name : String,phone:String)

    @Delete
    fun delete(user: User)

    @Query("delete from user_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM user_table")
    fun getAll(): MutableList<User>?

    @Query("SELECT * FROM user_table WHERE name = :keySearch")
    fun findByKeySearch(keySearch: String): MutableList<User>?
}