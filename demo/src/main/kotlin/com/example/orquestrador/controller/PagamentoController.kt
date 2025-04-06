package com.example.orquestrador.controller

import com.example.orquestrador.controller.request.PostBoletoRequest
import com.example.orquestrador.controller.request.PostCartaoRequest
import com.example.orquestrador.extension.toPagamentoModel
import com.example.orquestrador.service.PagamentoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
class PagamentoController(private val pagamentoService: PagamentoService) {
    @PostMapping("/boleto")
    @ResponseStatus(HttpStatus.CREATED)
    fun pagamentoBoleto(@RequestBody request: PostBoletoRequest){
        pagamentoService.processar(request.toPagamentoModel())
    }

    @PostMapping("/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    fun pagamentoCartao(@RequestBody request: PostCartaoRequest){
        pagamentoService.processar(request.toPagamentoModel())
    }
}