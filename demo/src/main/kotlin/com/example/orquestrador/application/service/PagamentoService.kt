package com.example.orquestrador.application.service

import com.example.orquestrador.domain.Pagamento
import com.example.orquestrador.adapters.outbound.repository.PagamentoRepository
import org.springframework.stereotype.Service

@Service
class PagamentoService(
    private val repository: PagamentoRepository
){

    fun processar(request: Pagamento){
        repository.save(request)
    }

}