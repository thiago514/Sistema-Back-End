package br.com.Attornatus.CRUDAttornatus.service.pessoa.impl;

import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.model.pessoa.Pessoa;
import br.com.Attornatus.CRUDAttornatus.repository.pessoa.PessoaRepossitory;
import br.com.Attornatus.CRUDAttornatus.service.pessoa.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * classe que implementa as regras de negocio de PessoaService
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
@AllArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepossitory repository;

    /**
     * @see PessoaService#cadastrar(Pessoa)
     * */
    @Override
    public Pessoa cadastrar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    /**
     * @see PessoaService#deletarPessoa(Long)
     * */
    public void deletarPessoa(Long pessoa_id) throws PessoaNaoExisteException {
        if(repository.existsByPessoa_id(pessoa_id)){
            repository.deleteById(pessoa_id);
        }else{
            throw new PessoaNaoExisteException();
        }

    }

    /**
     * @see PessoaService#findById(Long)
     * */
    @Override
    public Pessoa findById(Long pessoa_id) throws PessoaNaoExisteException {
        return repository.findById(pessoa_id).orElseThrow(() -> new PessoaNaoExisteException("Pessoa com o id= " + pessoa_id + " não existe"));
    }

    /**
     * @see PessoaService#listarPessoas()
     * */
    @Override
    public List<Pessoa> listarPessoas() {
        return repository.findAll();
    }


    /**
     * @see PessoaService#alterarPessoa(PessoaDTO)
     * */
    @Override
    public Pessoa alterarPessoa(PessoaDTO dados) throws PessoaNaoExisteException, ParseException {
        if(repository.existsByPessoa_id(dados.getPessoa_id())){
            var pessoa = repository.getReferenceById(dados.getPessoa_id());
            pessoa.atualizarInformacoes(dados);
            return pessoa;
        }else{
            throw new PessoaNaoExisteException();
        }

    }
}
