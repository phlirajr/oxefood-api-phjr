package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String titulo;
    
    private String codigo;

    private String descricao;

    private Double valorUnitario;

    private Integer tempoEntregaMinimo;

    private Integer tempoEntregaMaximo;

    public Produto build(){
        return Produto.builder()
        .titulo(titulo)
        .codigo(codigo)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoEntregaMinimo(tempoEntregaMinimo)
        .tempoEntregaMaximo(tempoEntregaMaximo)
        .build();
        
    }

    
}
