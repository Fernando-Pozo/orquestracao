package com.example.orquestrador.service

import com.example.orquestrador.model.Pagamento
import com.example.orquestrador.repository.PagamentoRepository
import org.springframework.stereotype.Service

@Service
class PagamentoService(
    private val repository: PagamentoRepository
){

    fun processar(request: Pagamento){
        repository.save(request)
    }

}