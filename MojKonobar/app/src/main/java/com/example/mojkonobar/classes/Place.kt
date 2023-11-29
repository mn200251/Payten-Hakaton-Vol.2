package com.example.mojkonobar.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Place(
    val id: Int = 0,
    val ownerEmail: String = "",
    val ownerPassword: String = "",
    val imageLink: String = "",
    val location: String = "",
    val description: String = "",
    val loyalityPoints: Int = 0,
) : Parcelable {
}