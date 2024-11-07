package com.cristiandev.testeempregopetz.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carta(
    val cardId: String,
    val name: String,
    val cardSet: String,
    val attack: Int?,
    val cost: Int?,
    val health: Int?,
    val race: String?,
    val playerClass: String,
    val text: String,
    val type: String,
    val img: String
) : Parcelable