package com.example.sub1moviejatpackpro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow (
    var id: String,
    var poster: Int,
    var title: String,
    var duration: String,
    var description: String,
    var score: String
):Parcelable