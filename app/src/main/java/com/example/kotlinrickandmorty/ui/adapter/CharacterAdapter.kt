package com.example.kotlinrickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlinrickandmorty.common.base.BaseComparator
import com.example.kotlinrickandmorty.data.network.dto.character.CharacterDto
import com.example.kotlinrickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter : PagingDataAdapter<CharacterDto, CharacterAdapter.CharacterViewHolder>(
    BaseComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CharacterDto) = with(binding) {
            titleIm.load(item.image)
            characterName.text = item.name
        }
    }
}