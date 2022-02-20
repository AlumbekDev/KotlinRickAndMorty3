package com.example.kotlinrickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlinrickandmorty.common.base.BaseRepository
import com.example.kotlinrickandmorty.data.network.api.CharacterApiService
import com.example.kotlinrickandmorty.data.network.dto.character.CharacterDto
import com.example.kotlinrickandmorty.data.network.paginsources.CharacterPagingSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService,
) : BaseRepository() {

    fun fetchCharacters(): LiveData<PagingData<CharacterDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).liveData
    }
}