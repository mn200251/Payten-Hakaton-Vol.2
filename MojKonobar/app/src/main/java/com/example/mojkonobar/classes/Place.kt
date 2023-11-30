package com.example.mojkonobar.classes

import android.os.Parcelable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mojkonobar.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


class Place(
    val id: Int = 0,
    val ownerEmail: String = "",
    val ownerPassword: String = "",
    val imageLink: Int = 0,
    val location: String = "",
    val description: String = "",
    val currLoyalityPoints: Int = 0,
    val requiredLoyalityPoints: Int = 0,
    val icon: ImageVector = Icons.Rounded.ShoppingCart,
) {
}