package com.example.orquestrador.utils

import com.example.orquestrador.adapters.inbound.controller.request.PostBoletoRequest
import com.example.orquestrador.adapters.inbound.controller.request.PostCartaoRequest
import com.example.orquestrador.adapters.outbound.entities.BoletoEntity
import com.example.orquestrador.adapters.outbound.entities.CartaoEntity
import com.example.orquestrador.adapters.outbound.entities.PagamentoEntity
import com.example.orquestrador.domain.Boleto
import com.example.orquestrador.domain.Cartao
import com.example.orquestrador.domain.Pagamento
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

fun BoletoEntity.toDomain() = Boleto(
    numeroBoleto = this.numeroBoleto,
    nomeTitular = this.nomeTitular
)

fun Boleto.toEntity() = BoletoEntity(
    numeroBoleto = this.numeroBoleto,
    nomeTitular = this.nomeTitular
)

fun CartaoEntity.toDomain() = Cartao(
    bandeira = this.bandeira,
    numeroCartao = this.numeroCartao,
    nomeTitular = this.nomeTitular
)

fun Cartao.toEntity() = CartaoEntity(
    bandeira = this.bandeira,
    numeroCartao = this.numeroCartao,
    nomeTitular = this.nomeTitular
)

fun PagamentoEntity.toDomain() = Pagamento(
    id = this.id,
    tipo = this.tipo,
    valor = this.valor,
    dadosCartao = this.dadosCartao,
    dadosBoleto = this.dadosBoleto
)

fun Pagamento.toEntity() = PagamentoEntity(
    id = this.id,
    tipo = this.tipo,
    valor = this.valor,
    dadosCartao = this.dadosCartao,
    dadosBoleto = this.dadosBoleto
)