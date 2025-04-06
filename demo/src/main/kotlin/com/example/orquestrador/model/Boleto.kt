package com.example.orquestrador.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class Boleto (

    @get:DynamoDbAttribute("numeroBoleto")
    var numeroBoleto: String = "",

    @get:DynamoDbAttribute("nomeTitular")
    var nomeTitular: String = ""
)