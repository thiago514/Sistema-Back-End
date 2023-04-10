package br.com.Attornatus.CRUDAttornatus.dto.pessoa;

import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import br.com.Attornatus.CRUDAttornatus.model.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Classe feita para ser um Objeto de Transferencia de Dados da entidade Pessoa
 *
 * @author Thiago Gogola Milagres
 * @since 05/04/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")
public class PessoaDTO {
    private Long pessoa_id;

    private String nome;


    @JsonSerialize(using = CalendarSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar data_de_nascimento;

    private List<Endereco> enderecos = new ArrayList<>();

    /**
     * Classe feita para transformar o PessoaDTO em uma entidade Pessoa
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     *
     * @return Pessoa
     */
    public Pessoa converterParaEntidade() {
        return new ModelMapper().map(this, Pessoa.class);
    }

}
