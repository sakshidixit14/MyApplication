package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey
    val empId: Int,
    val name: String,
    val email: String,
    val phone: String
)
