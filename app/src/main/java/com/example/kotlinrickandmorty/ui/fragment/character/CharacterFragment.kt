package com.example.kotlinrickandmorty.ui.fragment.character

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlinrickandmorty.R
import com.example.kotlinrickandmorty.common.base.BaseFragment
import com.example.kotlinrickandmorty.databinding.FragmentCharacterBinding
import com.example.kotlinrickandmorty.ui.adapter.CharacterAdapter
import com.example.kotlinrickandmorty.ui.adapter.paging.LoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel> (R.layout.fragment_character) {
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()
    override val binding by viewBinding(FragmentCharacterBinding::bind)

    override fun initialize() {
        setupCharacterRecycler()
    }

    private fun setupCharacterRecycler() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        recyclerView.adapter = characterAdapter.withLoadStateFooter(LoadStateAdapter {
            characterAdapter.retry()
        }
        )

        characterAdapter.addLoadStateListener { loadStates ->
            recyclerView.isVisible = loadStates.refresh is LoadState.NotLoading
        }
        setupRequests()
    }

    override fun setupRequests() {
        viewModel.fetchCharacters().observe(requireActivity(), {
            this.lifecycleScope.launch {
                characterAdapter.submitData(it)
            }
        })
    }
}