package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_profile")
data class EmployeeProfile(
    @PrimaryKey(autoGenerate = true)
    val empId: Int = 0,
    val name: String,
    val email: String,

    val phone: String
)
