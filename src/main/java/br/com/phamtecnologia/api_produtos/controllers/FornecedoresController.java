package br.com.phamtecnologia.api_produtos.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.api_produtos.dtos.FornecedorPostDto;
import br.com.phamtecnologia.api_produtos.dtos.FornecedorPutDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/fornecedores")
public class FornecedoresController {

    @PostMapping
    public void post(@RequestBody FornecedorPostDto dto) {
        //TODO
    }

    @PutMapping
    public void put(@RequestBody FornecedorPutDto dto) {
        //TODO
    }

    @DeleteMapping("{idFornecedor}")
    public void delete(@PathVariable("idFornecedor") Integer idFornecedor) {
        //TODO
    }

    @GetMapping
    public void getAll() {
        //TODO
    }

    @GetMapping("{idFornecedor}")
    public void getById(@PathVariable("idFornecedor") Integer idFornecedor) {
        //TODO
    }

}
