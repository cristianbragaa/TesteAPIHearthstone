package com.cristiandev.testeempregopetz.domain

import com.cristiandev.testeempregopetz.data.model.Carta

interface CartaRepository {
    suspend fun recuperarCartas(): List<Carta>
}