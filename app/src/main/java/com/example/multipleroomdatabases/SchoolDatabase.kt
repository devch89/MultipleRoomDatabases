package com.example.multipleroomdatabases

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.multipleroomdatabases.entites.Director
import com.example.multipleroomdatabases.entites.School
import com.example.multipleroomdatabases.entites.Student
import com.example.multipleroomdatabases.entites.Subject
import com.example.multipleroomdatabases.entites.relations.StudentSubjectCrossRef


@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase: RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {

        //when we change the value of the INSTANCE the change is immediately visible to other threads
        // help us prevent race conditions
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}