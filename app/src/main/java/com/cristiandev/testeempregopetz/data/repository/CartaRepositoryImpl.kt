package com.cristiandev.testeempregopetz.data.repository

import android.util.Log
import com.cristiandev.testeempregopetz.data.api.HearthstoneService
import com.cristiandev.testeempregopetz.data.model.Carta
import com.cristiandev.testeempregopetz.domain.CartaRepository
import javax.inject.Inject

class CartaRepositoryImpl @Inject constructor(
    private val hearthstoneService: HearthstoneService
): CartaRepository {
    override suspend fun recuperarCartas(): List<Carta> {
        try {
            val response = hearthstoneService.recuperarCartoes("Showdown in the Badlands")
            if (response.isSuccessful) {
                val listaCartas = response.body()
                if (listaCartas != null) {
                    return listaCartas
                }
            } else {
                Log.i("mensagem_api_cartas", response.message())
            }
        } catch (exception: Exception) {
            Log.i("mensagem_api_cartas", exception.message.toString())
        }
        return emptyList()
    }
}