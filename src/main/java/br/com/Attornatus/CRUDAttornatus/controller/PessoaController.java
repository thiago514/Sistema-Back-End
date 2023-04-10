package br.com.Attornatus.CRUDAttornatus.controller;

import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.model.pessoa.Pessoa;
import br.com.Attornatus.CRUDAttornatus.service.pessoa.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoa")

public class PessoaController{
    @Autowired
    private PessoaService service;



    @PostMapping({"", "/"})
    @Transactional
    public ResponseEntity cadastrarPessoa(@RequestBody @Valid PessoaDTO dados, UriComponentsBuilder uriBuilder) throws ParseException {
        var pessoa = service.cadastrar(dados.converterParaEntidade()).converterEntidadeParaDTO();
        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getPessoa_id()).toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }


    @GetMapping({"", "/{id}", "/"} )
    public ResponseEntity detalharPessoa(@PathVariable Optional<Long> id) throws PessoaNaoExisteException {
        var listaDTO = new ArrayList<PessoaDTO>();
        if (id.isPresent()) {
            var pessoa = service.findById(id.get());
            listaDTO.add(pessoa.converterEntidadeParaDTO());
        } else {

            List<Pessoa> listEntidade = new ArrayList<>();

            listEntidade.addAll(service.listarPessoas());
            listaDTO.addAll(listEntidade.stream().map(Pessoa::converterEntidadeParaDTO).toList());
        }
        return ResponseEntity.ok(listaDTO);
    }

    @PutMapping({"", "/"})
    @Transactional
    public ResponseEntity atualizarPessoa(@RequestBody @Valid PessoaDTO dados) throws ParseException, PessoaNaoExisteException {
        var pessoa = service.alterarPessoa(dados);
        return ResponseEntity.ok(pessoa.converterEntidadeParaDTO());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPessoa(@PathVariable Long id) throws PessoaNaoExisteException {
        service.deletarPessoa(id);
        return ResponseEntity.ok().build();
    }

}
