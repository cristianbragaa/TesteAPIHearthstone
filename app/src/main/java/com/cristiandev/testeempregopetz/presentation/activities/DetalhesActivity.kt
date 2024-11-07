package com.cristiandev.testeempregopetz.presentation.activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cristiandev.testeempregopetz.data.model.Carta
import com.cristiandev.testeempregopetz.databinding.ActivityDetalhesBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetalhesBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBunbleDetalhesCarta()
    }

    private fun configuraBunbleDetalhesCarta() {
        val bundle = intent.extras
        if (bundle != null) {
            val carta = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("carta", Carta::class.java)
            } else {
                bundle.getParcelable("carta")
            }

            if (carta != null) {
                with(binding) {
                    Picasso.get().load(carta.img).into(imageDetalheCarta)
                    textNome.text = carta.name
                    textID.text = carta.cardId
                    textSet.text = "Set = ${carta.cardSet}"
                    textAtaack.text = "Attack = ${carta.attack?.toString() ?: "0"}"
                    textHealth.text = "Health = ${carta.health?.toString() ?: "0"}"
                    textCost.text = "Cost = ${carta.cost?.toString() ?: "0"}"
                    textRace.text = "Race = ${carta.race ?: "Não encontrado"}"
                    textClass.text = "Class = ${carta?.playerClass ?: "--"}"
                    textType.text = "Type = ${carta?.type ?: "--"}"
                    textDescription.text = "Description = ${carta?.text ?: "--"}"
                }
            }
        }
    }
}