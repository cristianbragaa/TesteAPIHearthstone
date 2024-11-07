package com.cristiandev.testeempregopetz.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristiandev.testeempregopetz.databinding.ActivityMainBinding
import com.cristiandev.testeempregopetz.data.model.Carta
import com.cristiandev.testeempregopetz.presentation.adapter.CartaAdapter
import com.cristiandev.testeempregopetz.presentation.viewmodels.CartaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val cartaViewModel: CartaViewModel by viewModels()
    private lateinit var cartaAdapter: CartaAdapter

    override fun onStart() {
        super.onStart()
        cartaViewModel.recuperarCartas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        inicializarRecyclerView()
        inicializaObservers()
    }

    private fun inicializarRecyclerView() {
        cartaAdapter = CartaAdapter { carta ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("carta", carta)
            startActivity(intent)
        }
        binding.rvCartas.adapter = cartaAdapter
        binding.rvCartas.layoutManager = GridLayoutManager(
            this, 3, RecyclerView.VERTICAL, false
        )
    }

    private fun inicializaObservers() {
        cartaViewModel.listaCartas.observe(this) { listaCartas ->
            val listaCartasNovas = mutableListOf<Carta>()
            for (carta in listaCartas) {
                if (carta.img != null) {
                    listaCartasNovas.add(carta)
                }
            }
            if (listaCartasNovas.isNotEmpty()) {
                cartaAdapter.atualizarLista(listaCartasNovas)
            }
        }
    }
}