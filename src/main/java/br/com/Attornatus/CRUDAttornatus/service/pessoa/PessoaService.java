package br.com.Attornatus.CRUDAttornatus.service.pessoa;

import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.model.pessoa.Pessoa;

import java.text.ParseException;
import java.util.List;

/**
 * Interface para a implementação das regras de negócio referente ao gerenciamento de pessoas
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public interface PessoaService {
    /**
     * função que recebe uma pessoa e faz o cadastramento no BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param pessoa
     * @return Pessoa
     */
    Pessoa cadastrar(Pessoa pessoa);

    /**
     * função que deleta uma pessoa do BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param pessoa_id
     * @return Pessoa
     */
    void deletarPessoa(Long pessoa_id) throws PessoaNaoExisteException;

    /**
     * função para achar uma pessoa pelo id
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param pessoa_id
     * @return Pessoa
     * @throws PessoaNaoExisteException
     */
    Pessoa findById(Long pessoa_id) throws PessoaNaoExisteException;

    /**
     * função para achar todas as pessoa cadastrados no BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @return Pessoa
     * @throws PessoaNaoExisteException
     */
    List<Pessoa> listarPessoas();

    /**
     * função para alterar dados de uma pessoa
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param dados
     *
     * @return Pessoa
     * @throws PessoaNaoExisteException
     * @throws ParseException
     */
    Pessoa alterarPessoa(PessoaDTO dados) throws PessoaNaoExisteException, ParseException;


}
