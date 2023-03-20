package com.example.multipleroomdatabases.entites.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.multipleroomdatabases.entites.Student
import com.example.multipleroomdatabases.entites.Subject

data class SubjectWithStudents(

    @Embedded
    val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        // because this is a relation that contains its own table in an N to M relation
        // we need to tell Room which table specifies that relation
        // Room needs to know where to find all the subjects that belong to Students
        associateBy = Junction(StudentSubjectCrossRef::class)
    )

    val subjects: List<Student>
)
