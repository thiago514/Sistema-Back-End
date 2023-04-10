package br.com.Attornatus.CRUDAttornatus.service.endereco;

import br.com.Attornatus.CRUDAttornatus.dto.endereco.EnderecoDTO;
import br.com.Attornatus.CRUDAttornatus.exception.EnderecoNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaJaPossuiEnderecoPrincipal;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaSemEnderecoCadastrado;
import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;

import java.util.List;

/**
 * Interface para a implementação das regras de negócio referente ao gerenciamento de endereços
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public interface EnderecoService {

    /**
     * função que recebe um endereço e faz o cadastramento no BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param endereco
     * @return Endereco
     * @throws PessoaJaPossuiEnderecoPrincipal
     */
    Endereco cadastrarEndereco(Endereco endereco) throws PessoaJaPossuiEnderecoPrincipal;

    /**
     * função que recebe o id de um endereço e deleta ele do BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param endereco_id
     */
    void deletarEndereco(Long endereco_id);

    /**
     * função que recebe o id de um endereço e retorna os seus dados
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param endereco_id
     * @return Endereco
     * @throws EnderecoNaoExisteException
     */
    Endereco findByEndereco_id(Long endereco_id) throws EnderecoNaoExisteException;

    /**
     * função que retorna todos os endereços cadastrados no BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @return List<Endereco>
     */
    List<Endereco> listarEnderecos();

    /**
     * função que recebe o id de uma pessoa e retorna todos os endereços da pessoa
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param pessoa_id
     * @return List<Endereco>
     * @throws PessoaSemEnderecoCadastrado
     */
    List<Endereco> listarEnderecosDaPessoa(Long pessoa_id) throws PessoaSemEnderecoCadastrado;

    /**
     * função que recebe os dados de uma pessoa e altera ele no BD
     *
     * @author Thiago Gogola Milagres
     * @since 06/04/2023
     *
     * @param dados
     * @return Endereco
     * @throws EnderecoNaoExisteException
     */
    Endereco alterarEndereco(EnderecoDTO dados) throws EnderecoNaoExisteException;
}
