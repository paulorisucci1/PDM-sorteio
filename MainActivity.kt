package com.example.sorteio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var pokemonNameTextEdit: EditText
    lateinit var addButton: Button
    lateinit var raffleButton: Button
    lateinit var raffleResultTextView: TextView
    lateinit var pokemonNameRaffle: PokemonNameRaffle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViewReferences()
        startRaffle()
    }

    private fun initializeViewReferences() {
        this.pokemonNameTextEdit = findViewById(R.id.pokemonNameTextEdit)
        this.addButton = findViewById(R.id.addButton)
        this.raffleButton = findViewById(R.id.raffleButton)
        this.raffleResultTextView = findViewById(R.id.raffleResultTextView)
    }

    private fun startRaffle() {
        this.pokemonNameRaffle = PokemonNameRaffle()
        this.addButton.setOnClickListener(AddPokemon())
        this.raffleButton.setOnClickListener(RafflePokemon())
        Log.i("SORTEIO_APP","Jogo inicializado com sucesso")
    }

    inner class RafflePokemon : View.OnClickListener {
        override fun onClick(p0: View?) {
            val pokemon = this@MainActivity.pokemonNameRaffle.getRandomElement()
            this@MainActivity.raffleResultTextView.text = pokemon
            Log.i("SORTEIO_APP","Raffled pokemon: $pokemon")
        }
    }

    inner class AddPokemon : View.OnClickListener {
        override fun onClick(p0: View?) {
            val addedPokemon = pokemonNameTextEdit.text.toString()
            this@MainActivity.pokemonNameRaffle.add(addedPokemon)
            pokemonNameTextEdit.text.clear()
            Log.i("SORTEIO_APP","added pokemon: $addedPokemon")
        }
    }

}
