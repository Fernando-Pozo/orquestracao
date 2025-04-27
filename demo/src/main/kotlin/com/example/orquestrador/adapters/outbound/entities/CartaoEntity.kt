package com.example.orquestrador.adapters.outbound.entities


import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class CartaoEntity (

    @get:DynamoDbAttribute("bandeira")
    var bandeira: String = "",

    @get:DynamoDbAttribute("numeroCartao")
    var numeroCartao: String = "",

    @get:DynamoDbAttribute("nomeTitular")
    var nomeTitular: String = ""
)
