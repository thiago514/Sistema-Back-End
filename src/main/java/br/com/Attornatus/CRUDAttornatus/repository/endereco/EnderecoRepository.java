package br.com.Attornatus.CRUDAttornatus.repository.endereco;

import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interface com o objetivo fazer requisições no BD implementando a interface JPA
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
    @Query("select e from Endereco e where e.endereco_id = ?1")
    Endereco findByEndereco_id(Long endereco_id);

    /**
     * Metodo para verificar se uma pessoa tem endereço cadastrado no BD
     *
     * @param pessoa_id
     * @return boolean
     */
    @Query("select (count(e) > 0) from Endereco e where e.pessoa_id = ?1")
    boolean existsByPessoa_id(Long pessoa_id);

    /**
     * Metodo para achar todos os endereços de uma pessoa
     *
     * @param pessoa_id
     * @return List<Endereco>
     */
    @Query("select e from Endereco e where e.pessoa_id = ?1")
    List<Endereco> findAllPessoa_id(Long pessoa_id);

}
