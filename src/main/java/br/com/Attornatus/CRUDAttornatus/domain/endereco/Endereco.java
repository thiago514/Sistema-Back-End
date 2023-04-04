package br.com.Attornatus.CRUDAttornatus.domain.endereco;

import br.com.Attornatus.CRUDAttornatus.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ldogradouro;


    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String cidade;
}
