package com.example.orquestrador.domain


data class Pagamento (

    var id: String = "",

    var tipo: String? = null,

    var valor: Double? = 0.0,

    var dadosCartao: String? = null,

    var dadosBoleto: String? = null
)