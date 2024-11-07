package com.cristiandev.testeempregopetz.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiandev.testeempregopetz.data.model.Carta
import com.cristiandev.testeempregopetz.domain.CartaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartaViewModel @Inject constructor(
    private val cartaRepository: CartaRepository
): ViewModel() {

    private val _listaCartas = MutableLiveData<List<Carta>>()
    val listaCartas: LiveData<List<Carta>> = _listaCartas

    fun recuperarCartas() {
        viewModelScope.launch(Dispatchers.IO) {
            val lista = cartaRepository.recuperarCartas()
            _listaCartas.postValue(lista)
        }
    }
}