package com.example.orquestrador.adapters.outbound.repository

import com.example.orquestrador.domain.Pagamento
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Repository

@Repository
class PagamentoRepository(private val dynamoDbTemplate: DynamoDbTemplate) {

    fun save(pagamento: Pagamento) {
        dynamoDbTemplate.save(pagamento)
    }

}