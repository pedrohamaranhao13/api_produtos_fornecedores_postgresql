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
public class FornecedorGetDto {

    private Integer idFornecedor;
    private String nome;
    private String cnpj;
    private String telefone;
}
