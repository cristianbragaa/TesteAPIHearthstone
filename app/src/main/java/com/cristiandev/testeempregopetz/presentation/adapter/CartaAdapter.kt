package com.cristiandev.testeempregopetz.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristiandev.testeempregopetz.data.model.Carta
import com.cristiandev.testeempregopetz.databinding.ItemRvCartaBinding
import com.squareup.picasso.Picasso

class CartaAdapter(
    private val onClickCarta: (Carta) -> Unit
): RecyclerView.Adapter<CartaAdapter.CartaoViewHolder>() {
    private var listaCartas = emptyList<Carta>()

    fun atualizarLista(lista: List<Carta>) {
        this.listaCartas = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartaoViewHolder {
        val binding = ItemRvCartaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartaoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartaoViewHolder, position: Int) {
        val carta = listaCartas[position]
        holder.bind(carta)
    }

    override fun getItemCount(): Int {
        val totalItens = listaCartas.size
        return totalItens / 4
    }

    inner class CartaoViewHolder(private val binding: ItemRvCartaBinding): RecyclerView.ViewHolder(binding.root) {
        private val imagemCarta = binding.imagemCarta
        private val textNomeCarta = binding.textNomeCarta

        fun bind(carta: Carta) {
            textNomeCarta.text = carta.name
            Picasso.get().load(carta.img).into(imagemCarta)

            itemView.setOnClickListener {
                onClickCarta.invoke(carta)
            }
        }
    }
}