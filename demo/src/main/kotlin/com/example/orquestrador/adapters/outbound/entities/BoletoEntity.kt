package com.example.orquestrador.adapters.outbound.entities

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class BoletoEntity(

    @get:DynamoDbAttribute("numeroBoleto")
    var numeroBoleto: String = "",

    @get:DynamoDbAttribute("nomeTitular")
    var nomeTitular: String = ""
)