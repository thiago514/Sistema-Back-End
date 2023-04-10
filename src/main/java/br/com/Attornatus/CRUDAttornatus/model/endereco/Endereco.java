package br.com.Attornatus.CRUDAttornatus.model.endereco;

import br.com.Attornatus.CRUDAttornatus.dto.endereco.EnderecoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

/**
 * Classe com o objetivo de implementar a estrutura da entidade Endereco
 *
 * @author Thiago Gogola Milagres
 * @since 05/04/2023
 */
@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "endereco_id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endereco_id;

    @Column(nullable = false)
    private String logradouro;


    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private Boolean principal;

    @Column(nullable = false)
    private Long pessoa_id;


    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.getLogradouro();
        this.cep = dados.getCep();
        this.numero = dados.getNumero();
        this.cidade = dados.getCidade();
        this.principal = dados.getPrincipal();
        this.pessoa_id = dados.getPessoa_id();
    }

    /**
     * Metodo para atualizar as informações do endereco
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     */

    public void atualizarInformacoes(EnderecoDTO dados) {
        if(dados.getLogradouro() != null){
            this.logradouro = dados.getLogradouro();
        }
        if(dados.getCep() != null){
            this.cep = dados.getCep();
        }
        if(dados.getNumero() != null){
            this.numero = dados.getNumero();
        }
        if(dados.getCidade() != null){
            this.cidade = dados.getCidade();
        }
        if(dados.getPrincipal() != null){
            this.principal = dados.getPrincipal();
        }
    }
    /**
     * Metodo para transformar a entidade Endereco em um EnderecoDTO
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     *
     * @return EnderecoDTO
     */

    public EnderecoDTO converterEntidadeParaDTO(){
        return new ModelMapper().map(this, EnderecoDTO.class);
    }

}
