package com.example.kotlinrickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlinrickandmorty.databinding.ItemCharacterBinding
import com.example.richandmortyapi.data.network.dto.CharactersDto

class CharacterAdapter :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder?>() {

    private var characters: List<CharactersDto> = ArrayList()

    fun setCharacters(characters: List<CharactersDto>) {
        this.characters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(characters.get(position))
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun onBind(item: CharactersDto) = with(binding) {
            titleIm.load(item.image)
            characterName.text = item.name
        }
    }
}
