package br.com.phamtecnologia.api_produtos.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import br.com.phamtecnologia.api_produtos.dtos.ProdutoGetDto;
import br.com.phamtecnologia.api_produtos.dtos.ProdutoPostDto;
import br.com.phamtecnologia.api_produtos.dtos.ProdutoPutDto;
import br.com.phamtecnologia.api_produtos.entities.Fornecedor;
import br.com.phamtecnologia.api_produtos.entities.Produto;
import br.com.phamtecnologia.api_produtos.repositories.FornecedorRepository;
import br.com.phamtecnologia.api_produtos.repositories.ProdutoRepository;


@RestController
@RequestMapping(value = "/api/produtores")
public class ProdutosController {

      @Autowired
      private ProdutoRepository produtoRepository;

      @Autowired
      private FornecedorRepository fornecedorRepository;

     @PostMapping
     public ResponseEntity<String> post(@RequestBody ProdutoPostDto dto) {
        
         try {
            
            Optional<Fornecedor> optional = fornecedorRepository.findById(dto.getIdFornecedor());

            if (optional.isPresent()) {
               
               Fornecedor fornecedor = optional.get();

               Produto produto = new Produto();
               produto.setNome(dto.getNome());
               produto.setPreco(dto.getPreco());
               produto.setQuantidade(dto.getQuantidade());
               produto.setDescricao(dto.getDescricao());
               produto.setFornecedor(fornecedor);

               produtoRepository.save(produto);
               
               return ResponseEntity.status(201).body("Produto cadastrado com sucesso.");
            } else {
               return ResponseEntity.status(404).body("Fornecedor não encontrado, verique o ID.");
            }
         } catch (Exception e) {
            return ResponseEntity.status(500).body("Não foi possível realizar o cadastro.");
         }

     }

     @PutMapping
     public ResponseEntity<String> put(@RequestBody ProdutoPutDto dto) {
        try {

            Optional<Produto> optionalProduto = produtoRepository.findById(dto.getIdProduto());
            
            if (optionalProduto.isPresent()) {
               
               Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(dto.getIdFornecedor());
               if (optionalFornecedor.isPresent()) {
                  
                  Produto produto = optionalProduto.get();
                  Fornecedor fornecedor = optionalFornecedor.get();

                  produto.setNome(dto.getNome());
                  produto.setPreco(dto.getPreco());
                  produto.setQuantidade(dto.getQuantidade());
                  produto.setDescricao(dto.getDescricao());
                  produto.setFornecedor(fornecedor);

                  produtoRepository.save(produto);

                  return ResponseEntity.status(200).body("Produto atualizado com sucesso.");
               } else {
                  return ResponseEntity.status(404).body("Fornecedor não localizado.");
               }
            } else {
               return ResponseEntity.status(404).body("Produto não localizado.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Não foi possível atualizar o produto.");
        }
     }

     @DeleteMapping("{idProduto}")
     public ResponseEntity<String> delete(@PathVariable("idProduto") Integer idProduto) {
        try {
         Optional<Produto> optional = produtoRepository.findById(idProduto);

         if (optional.isPresent()) {
            
            Produto produto = optional.get();
            produtoRepository.delete(produto);
            return ResponseEntity.status(200).body("Produto excluído com sucesso.");
         } else {
            return ResponseEntity.status(404).body("Produto não encontrado.");
         }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Não foi possível excluir o produto.");
        }
     }

     @GetMapping
     public ResponseEntity<List<ProdutoGetDto>> getAll() {
        try {
         
         List<Produto> produtos = produtoRepository.findAll();
         List<ProdutoGetDto> lista = new ArrayList<ProdutoGetDto>();

         for (Produto produto : produtos) {
            ProdutoGetDto dto = new ProdutoGetDto();
            dto.setIdProduto(produto.getIdProduto());
            dto.setNomeProduto(produto.getNome());
            dto.setPreco(produto.getPreco());
            dto.setQuantidade(produto.getQuantidade());
            dto.setTotal(BigDecimal.valueOf(produto.getPreco())
                      .multiply(BigDecimal.valueOf(produto.getQuantidade()))
                      .setScale(2, RoundingMode.HALF_UP)
                      .doubleValue());
            dto.setDescricao(produto.getDescricao());
            dto.setIdFornecedor(produto.getFornecedor().getIdFornecedor());
            dto.setNomeFornecedor(produto.getFornecedor().getNome());
            dto.setCnpjFornecedor(produto.getFornecedor().getCnpj());
            dto.setTelefoneFornecedor(produto.getFornecedor().getTelefone());

            lista.add(dto);
         }

         return ResponseEntity.status(200).body(lista); 

        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
     }

     @GetMapping("{idProduto}")
     public ResponseEntity<ProdutoGetDto> getById(@PathVariable("idProduto") Integer idProduto) {
         try {

            Optional<Produto> optional = produtoRepository.findById(idProduto);

            if (optional.isPresent()) {
               
               Produto produto = optional.get();

               ProdutoGetDto dto = new ProdutoGetDto();
               dto.setIdProduto(produto.getIdProduto());
               dto.setNomeProduto(produto.getNome());
               dto.setPreco(produto.getPreco());
               dto.setQuantidade(produto.getQuantidade());
               dto.setTotal(BigDecimal.valueOf(produto.getPreco())
                      .multiply(BigDecimal.valueOf(produto.getQuantidade()))
                      .setScale(2, RoundingMode.HALF_UP)
                      .doubleValue());
               dto.setDescricao(produto.getDescricao());
               dto.setIdFornecedor(produto.getFornecedor().getIdFornecedor());
               dto.setNomeFornecedor(produto.getFornecedor().getNome());
               dto.setCnpjFornecedor(produto.getFornecedor().getCnpj());
               dto.setTelefoneFornecedor(produto.getFornecedor().getTelefone());


               return ResponseEntity.status(200).body(dto);
            } else {
               return ResponseEntity.status(200).body(null);
            }
            
         } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
         }
     }

     
}
