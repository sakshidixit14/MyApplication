package com.example.myapplication

import androidx.room.Entity

@Entity(tableName = "employee")
data class Employee(
    val empId: Int,
    val name: String,
    val email: String,
    val phone: String
)
