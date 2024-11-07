package com.cristiandev.testeempregopetz.data.api

import com.cristiandev.testeempregopetz.data.model.Carta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HearthstoneService {
    @GET("cards/sets/{set}") // card set -> Naxxramas
    suspend fun recuperarCartoes(
        @Path("set") conjunto: String
    ) : Response<List<Carta>>
}