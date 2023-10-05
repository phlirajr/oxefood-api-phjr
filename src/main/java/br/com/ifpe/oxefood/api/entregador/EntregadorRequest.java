package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.model.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(min = 3, max = 100, message = "O Nome deverá ter entre {min} e {max} caracteres")
    private String nome;
    
    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    private String rg;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    private String foneCelular;

    private String foneFixo;
    
    private Integer qtdEntregasRealizadas;
    
    private Double valorFrete;

    private String enderecoRua;
    
    private String enderecoNumero;
    
    private String enderecoBairro;
    
    private String enderecoCidade;
    
    private String enderecoCep;
    
    private String enderecoUf;
    
    private String enderecoComplemento;
    
    private Boolean ativo;

    public Entregador build(){
        return Entregador.builder()
        .nome(nome)
        .cpf(cpf)
        .rg(rg)
        .dataNascimento(dataNascimento)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .qtdEntregasRealizadas(qtdEntregasRealizadas)
        .valorFrete(valorFrete)
        .enderecoRua(enderecoRua)
        .enderecoNumero(enderecoNumero)
        .enderecoBairro(enderecoBairro)
        .enderecoCidade(enderecoCidade)
        .enderecoCep(enderecoCep)
        .enderecoUf(enderecoUf)
        .enderecoComplemento(enderecoComplemento)
        .ativo(ativo)
        .build();
    }
    
}
