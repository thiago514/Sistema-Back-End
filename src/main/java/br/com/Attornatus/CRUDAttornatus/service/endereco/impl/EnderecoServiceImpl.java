package br.com.Attornatus.CRUDAttornatus.service.endereco.impl;

import br.com.Attornatus.CRUDAttornatus.dto.endereco.EnderecoDTO;
import br.com.Attornatus.CRUDAttornatus.exception.EnderecoNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaJaPossuiEnderecoPrincipal;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaSemEnderecoCadastrado;
import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import br.com.Attornatus.CRUDAttornatus.repository.endereco.EnderecoRepository;
import br.com.Attornatus.CRUDAttornatus.service.endereco.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * classe que implementa as regras de negocio de EnderecoService
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
@AllArgsConstructor
@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private final EnderecoRepository repository;

    /**
     * @see EnderecoService#cadastrarEndereco(Endereco)
     */
    @Override
    public Endereco cadastrarEndereco(Endereco endereco) throws PessoaJaPossuiEnderecoPrincipal {

        if(endereco.getPrincipal()){
            var existeEnderecoPrincipalPessoa = repository.existsByPessoa_id(endereco.getPessoa_id());
            if(existeEnderecoPrincipalPessoa){
                throw new PessoaJaPossuiEnderecoPrincipal();
            }
        }
        return repository.save(endereco);
    }

    /**
     * @see EnderecoService#deletarEndereco(Long)
     */
    @Override
    public void deletarEndereco(Long endereco_id) {
        repository.deleteById(endereco_id);
    }

    /**
     * @see EnderecoService#findByEndereco_id(Long)
     */
    @Override
    public Endereco findByEndereco_id(Long endereco_id) throws EnderecoNaoExisteException {
        return repository.findById(endereco_id).orElseThrow(() -> new EnderecoNaoExisteException("Não existe nenhum endereço com este id"));
    }

    /**
     * @see EnderecoService#listarEnderecos()
     */
    @Override
    public List<Endereco> listarEnderecos(){
        return repository.findAll();
    }

    /**
     * @see EnderecoService#listarEnderecosDaPessoa(Long)
     */
    @Override
    public List<Endereco> listarEnderecosDaPessoa(Long pessoa_id) throws PessoaSemEnderecoCadastrado {
        var enderecos = repository.findAllPessoa_id(pessoa_id);
        if(enderecos.isEmpty()){
            throw new PessoaSemEnderecoCadastrado("Esse id de pessoa não tem nenhum endereco cadastrado");
        }
        return enderecos;
    }

    /**
     * @see EnderecoService#alterarEndereco(EnderecoDTO)
     */
    @Override
    public Endereco alterarEndereco(EnderecoDTO dados) throws EnderecoNaoExisteException {

        if(repository.existsById(dados.getEndereco_id())){
            var endereco = repository.getReferenceById(dados.getEndereco_id());
            endereco.atualizarInformacoes(dados);
            return endereco;
        }else{
            throw new EnderecoNaoExisteException();
        }


    }
}
