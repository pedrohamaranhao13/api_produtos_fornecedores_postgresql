package br.com.phamtecnologia.api_produtos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.phamtecnologia.api_produtos.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    @Query("select p from Produto p join p.fornecedor f order by p.nome")
    List<Produto> findAll();

    @Query("select p from Produto p join p.fornecedor where p.idProduto = :idProduto")
    Optional<Produto> findById(@Param("idProduto") Integer idProduto);

}
