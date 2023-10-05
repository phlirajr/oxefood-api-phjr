package br.com.ifpe.oxefood.api.produto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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

    private Long idCategoria;
    
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(min = 3, max = 100, message = "O Título do produto deverá ter entre {min} e {max} caracteres")
    private String titulo;
    
    @NotBlank(message = "O Código do produto é de preenchimento obrigatório")
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
