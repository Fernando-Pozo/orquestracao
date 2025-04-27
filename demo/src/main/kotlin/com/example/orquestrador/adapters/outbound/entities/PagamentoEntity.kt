package com.example.orquestrador.adapters.outbound.entities

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class PagamentoEntity (

    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("ID")
    var id: String = "",

    @get:DynamoDbAttribute("tipo")
    var tipo: String? = null,

    @get:DynamoDbAttribute("valor")
    var valor: Double? = 0.0,

    @get:DynamoDbAttribute("dadosCartao")
    var dadosCartao: String? = null,

    @get:DynamoDbAttribute("dadosBoleto")
    var dadosBoleto: String? = null
)