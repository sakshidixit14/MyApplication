package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employee: Employee)

    @Query("select * from employee")
    suspend fun getEmployee(): Employee
}