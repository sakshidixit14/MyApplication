package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val empId: Int = 0,
    val name: String,
    val email: String,
    val phone: String
)
