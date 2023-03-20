package com.example.multipleroomdatabases.entites.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipleroomdatabases.entites.Director
import com.example.multipleroomdatabases.entites.School

/**
 * Defines the relationship between the one to one b/t School and Director.
 * Only one Director per school
 */


data class SchoolAndDirector(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
