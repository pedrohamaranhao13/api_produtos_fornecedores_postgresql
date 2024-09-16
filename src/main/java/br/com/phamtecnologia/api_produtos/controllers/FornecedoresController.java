package br.com.phamtecnologia.api_produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.api_produtos.dtos.FornecedorPostDto;
import br.com.phamtecnologia.api_produtos.dtos.FornecedorPutDto;
import br.com.phamtecnologia.api_produtos.entities.Fornecedor;
import br.com.phamtecnologia.api_produtos.repositories.FornecedorRepository;




@RestController
@RequestMapping(value = "/api/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody FornecedorPostDto dto) {
        try {

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(dto.getNome());
            fornecedor.setCnpj(dto.getCnpj());
            fornecedor.setTelefone(dto.getTelefone());

            fornecedorRepository.save(fornecedor);

            return ResponseEntity.status(201).body("Fornecedor cadastrado com sucesso.");

        } catch (Exception e) {

            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
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
