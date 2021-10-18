package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.domain.models.ListModel
import com.example.recyclerviewexample.domain.models.Nota
import com.example.recyclerviewexample.domain.models.SecoesDiaria
import com.example.recyclerviewexample.domain.models.SecoesMensais
import com.example.recyclerviewexample.ui.adapter.NotesAdapter
import com.example.recyclerviewexample.ui.adapter.toListAdapterModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = NotesAdapter()
        adapter.notes = mockList().toListAdapterModel()
        val rv = findViewById<RecyclerView>(R.id.rv_notes)
        rv.hasFixedSize()
        rv.adapter =adapter
    }

    private fun mockList() =
        ListModel(
            secoesMensais = listOf(
                    SecoesMensais(
                        mesSolicitacao = "Janeiro",
                        secoesDiarias = listOf(
                            SecoesDiaria(
                                dataSolicitacao = 4,
                                notas = listOf(
                                    Nota(
                                        conteudo = "Comprar laranjas",
                                    ),
                                    Nota(
                                        conteudo = "Aguar as plantas"
                                    ),
                                    Nota(
                                        conteudo = "Marcar oftalmo"
                                    )
                                )
                            ),
                            SecoesDiaria(
                                dataSolicitacao = 12,
                                notas = listOf(
                                    Nota(
                                        conteudo = "Buscar bolo"
                                    )
                                )
                            )
                        )
                    ),
                    SecoesMensais(
                        mesSolicitacao = "Fevereiro",
                        secoesDiarias = listOf(
                            SecoesDiaria(
                                dataSolicitacao = 8,
                                notas = listOf(
                                    Nota(
                                        conteudo = "Comprar presente do joão"
                                    )
                                )
                            )
                        )
                    )
                )
        )
}