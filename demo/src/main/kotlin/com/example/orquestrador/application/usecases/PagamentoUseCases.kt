package com.example.orquestrador.application.usecases

import com.example.orquestrador.domain.Pagamento

interface PagamentoUseCases {
    fun processar(request: Pagamento)
}