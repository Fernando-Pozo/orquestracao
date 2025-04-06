package com.example.orquestrador.extension

import com.example.orquestrador.controller.request.PostBoletoRequest
import com.example.orquestrador.controller.request.PostCartaoRequest
import com.example.orquestrador.model.Pagamento
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val mapper = jacksonObjectMapper()

fun PostBoletoRequest.toPagamentoModel(): Pagamento {
    val dadosBoletoJson = mapper.writeValueAsString(
        mapOf(
            "numeroBoleto" to this.numeroBoleto,
            "nomeTitular" to this.nomeTitular
        )
    )

    return Pagamento(
       id = this.id,
       tipo = "BOLETO",
       valor = this.valor,
        dadosBoleto =dadosBoletoJson,
        dadosCartao = null
    )
}

fun PostCartaoRequest.toPagamentoModel(): Pagamento {
    val dadosCartaoJson = mapper.writeValueAsString(
        mapOf(
            "bandeira" to this.bandeira,
            "numeroCartao" to this.numeroCartao,
            "nomeTitular" to this.nomeTitular
        )
    )

    return Pagamento(
        id = this.id,
        tipo = "CARTAO",
        valor = this.valor,
        dadosCartao = dadosCartaoJson,
        dadosBoleto = null
    )
}