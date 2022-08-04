package com.example.bai3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_table")
data class User(var name:String, var phone:String, var avatar : Int?=null,@PrimaryKey(autoGenerate = true) val id: Int?=null):Serializable
