package com.example.sub1moviejatpackpro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id: String? = "",
    var poster: Int = 0,
    var title: String? = "",
    var score: String? = "",
    var release: String? = "",
    var duration: String? = "",
    var description: String? = ""
): Parcelable