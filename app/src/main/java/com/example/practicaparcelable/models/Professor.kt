package com.example.practicaparcelable.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Professor (
    val name: String,
    val lastName: String,
): Parcelable