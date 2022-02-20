package com.example.kotlinrickandmorty.data.network.api

import com.example.kotlinrickandmorty.data.network.dto.RickAndMortyResponse
import com.example.kotlinrickandmorty.data.network.dto.character.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("/api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<CharacterDto>
}