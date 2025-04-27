package com.example.orquestrador.domain

interface PagamentoRepositoryPort {
    fun save(pagamento: Pagamento)
}