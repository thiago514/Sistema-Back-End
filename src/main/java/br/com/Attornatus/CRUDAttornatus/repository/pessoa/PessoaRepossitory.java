package br.com.Attornatus.CRUDAttornatus.repository.pessoa;

import br.com.Attornatus.CRUDAttornatus.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface com o objetivo fazer requisições no BD implementando a interface JPA
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public interface PessoaRepossitory extends JpaRepository<Pessoa, Long> {
    @Query("select (count(p) > 0) from Pessoa p where p.pessoa_id = ?1")
    boolean existsByPessoa_id(Long pessoa_id);
}
