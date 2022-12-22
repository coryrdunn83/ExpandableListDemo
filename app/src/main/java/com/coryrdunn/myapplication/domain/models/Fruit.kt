package com.coryrdunn.myapplication.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fruit(
    @PrimaryKey val name: String,
    val taste: String,
    val color: String,
)
