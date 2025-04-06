package com.example.orquestrador.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class Pagamento (

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