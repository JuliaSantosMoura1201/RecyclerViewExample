package com.example.recyclerviewexample.ui.adapter

import com.example.recyclerviewexample.domain.models.ListModel
import com.example.recyclerviewexample.ui.model.AdapterModel
import com.example.recyclerviewexample.ui.model.AdapterTypes

fun ListModel.toListAdapterModel(): List<AdapterModel> {
    val adapterList = mutableListOf<AdapterModel>()
    secoesMensais.forEach { monthlySection ->
        adapterList.add(
            AdapterModel(
                type = AdapterTypes.MONTH,
                content = monthlySection.mesSolicitacao
            )
        )

        monthlySection.secoesDiarias.forEach { dailySection ->
            adapterList.add(
                AdapterModel(
                    type = AdapterTypes.DAY,
                    content = dailySection.dataSolicitacao
                )
            )

            dailySection.notas.forEach { note ->
                adapterList.add(
                    AdapterModel(
                        type = AdapterTypes.NOTE,
                        content = note.conteudo
                    )
                )
            }
        }
    }

    return adapterList.toList()
}