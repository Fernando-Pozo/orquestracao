package com.example.orquestrador.adapters.outbound.repository

import com.example.orquestrador.domain.Pagamento
import com.example.orquestrador.domain.PagamentoRepositoryPort
import com.example.orquestrador.utils.toEntity
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Repository

@Repository
class PagamentoRepository(private val dynamoDbTemplate: DynamoDbTemplate) : PagamentoRepositoryPort {

    override fun save(pagamento: Pagamento) {
        val entity = pagamento.toEntity()
        dynamoDbTemplate.save(entity)
    }

}