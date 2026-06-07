package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Employee::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {

        @Volatile
        private var roomDbInstance: AppDb? = null

        fun getDatabase(context: Context): RoomDatabase {
            return roomDbInstance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDb::class.java,
                    name = "sakshi_database"
                ).build()
            }
        }
    }
}