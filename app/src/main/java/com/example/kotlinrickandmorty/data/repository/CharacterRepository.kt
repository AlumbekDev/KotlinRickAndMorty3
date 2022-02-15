package com.example.kotlinrickandmorty.data.repository

import com.example.kotlinrickandmorty.common.BaseRepository
import com.example.richandmortyapi.data.network.api.CharacterApiService
import com.example.richandmortyapi.data.network.dto.CharactersDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) : BaseRepository() {
    fun fetchCharacters() = doRequest {
         service.fetchCharacters()
    }
}