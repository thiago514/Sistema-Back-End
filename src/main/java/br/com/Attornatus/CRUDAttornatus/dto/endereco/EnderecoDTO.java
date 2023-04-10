package br.com.Attornatus.CRUDAttornatus.dto.endereco;

import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.modelmapper.ModelMapper;
/**
 * Classe feita para ser um Objeto de Transferencia de Dados da entidade endereco
 *
 * @author Thiago Gogola Milagres
 * @since 05/04/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "endereco_id")
public class EnderecoDTO {
    private Long endereco_id;

    private String logradouro;
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "A estrutura do cep está incorreta (00000-000)")
    private String cep;

    private Integer numero;

    private String cidade;
    private Boolean principal;
    private Long pessoa_id;

    /**
     * Metodo para transformar o EnderecoDTO em entidade Endereco
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     *
     * @return Endereco
     */
    public Endereco converterParaEntidade(){
        return new ModelMapper().map(this, Endereco.class);
    }
}
