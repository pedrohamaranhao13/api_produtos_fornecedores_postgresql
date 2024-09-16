package br.com.phamtecnologia.api_produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoPutDto {

    private Integer idProduto;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String descricao;
    private Integer idFornecedor;
}
