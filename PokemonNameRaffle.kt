package com.example.sorteio

class PokemonNameRaffle {

    private val pokemonNames = mutableListOf<String>();

    fun add(element: String) {
        this.pokemonNames.add(element)
    }

    fun getRandomElement(): String? {
        if(this.pokemonNames.size > 0) {
            return this.pokemonNames.random()
        }
        return null
    }
}