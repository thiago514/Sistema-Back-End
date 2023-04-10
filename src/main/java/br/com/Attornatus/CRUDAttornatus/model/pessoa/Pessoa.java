package br.com.Attornatus.CRUDAttornatus.model.pessoa;

import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 * Classe com o objetivo de implementar a estrutura da entidade Pessoa
 *
 * @author Thiago Gogola Milagres
 * @since 05/04/2023
 */
@Entity
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoa_id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Calendar data_de_nascimento = Calendar.getInstance();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> enderecos = new ArrayList<>();

    public void adicionarEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    public Pessoa(PessoaDTO dados) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = dados.getNome();
        data_de_nascimento = dados.getData_de_nascimento();
    }
    /**
     * Metodo para atualizar as informações da pessoa
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     */

    public void atualizarInformacoes(PessoaDTO dados) throws ParseException {
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
        if(dados.getData_de_nascimento() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data_de_nascimento = dados.getData_de_nascimento();
        }
    }
    /**
     * Metodo para converter a Entidade pessoa para o PessoaDTO
     *
     * @author Thiago Gogola Milagres
     * @since 05/04/2023
     *
     * @return PessoaDTO
     */
    public PessoaDTO converterEntidadeParaDTO(){
        return new ModelMapper().map(this, PessoaDTO.class);
    }
}
