package com.example.orquestrador.application.service

import com.example.orquestrador.application.usecases.PagamentoUseCases
import com.example.orquestrador.domain.Pagamento
import com.example.orquestrador.domain.PagamentoRepositoryPort
import org.springframework.stereotype.Service

@Service
class PagamentoService(
    private val repository: PagamentoRepositoryPort
) : PagamentoUseCases {

    override fun processar(request: Pagamento){
        repository.save(request)
    }

}