package com.example.kotlinrickandmorty.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.kotlinrickandmorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun fetchCharacters() = repository.fetchCharacters().asLiveData()

        }
