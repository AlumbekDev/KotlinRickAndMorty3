package com.example.richandmortyapi.data.network.api

import com.example.richandmortyapi.data.network.dto.CharactersDto
import com.example.richandmortyapi.data.network.dto.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiService {
    @GET("/character/")
    suspend fun fetchCharacters(): RickAndMortyResponse<CharactersDto>
}