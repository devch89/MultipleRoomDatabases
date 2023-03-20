package com.example.multipleroomdatabases.entites.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipleroomdatabases.entites.School
import com.example.multipleroomdatabases.entites.Student

data class SchoolWithStudents(

    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
