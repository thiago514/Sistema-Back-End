package br.com.Attornatus.CRUDAttornatus.controller;

import br.com.Attornatus.CRUDAttornatus.dto.endereco.EnderecoDTO;
import br.com.Attornatus.CRUDAttornatus.exception.EnderecoNaoExisteException;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaJaPossuiEnderecoPrincipal;
import br.com.Attornatus.CRUDAttornatus.exception.PessoaSemEnderecoCadastrado;
import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import br.com.Attornatus.CRUDAttornatus.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping({"/",""})
    @Transactional
    public ResponseEntity cadastrarEndereco(@RequestBody EnderecoDTO dados, UriComponentsBuilder uriBuilder) throws PessoaJaPossuiEnderecoPrincipal {
        var endereco = service.cadastrarEndereco(dados.converterParaEntidade()).converterEntidadeParaDTO();
        var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getEndereco_id()).toUri();

        return ResponseEntity.created(uri).body(endereco);
    }

    @GetMapping({"/", "/{id}", ""})
    public ResponseEntity listagemDeEndereco(@PathVariable Optional<Long> id) throws EnderecoNaoExisteException {
        var listDTO = new ArrayList<EnderecoDTO>();
        if(id.isPresent()){
            listDTO.add(service.findByEndereco_id(id.get()).converterEntidadeParaDTO());
        }else{
            listDTO.addAll(service.listarEnderecos().stream().map(Endereco::converterEntidadeParaDTO).toList());
        }
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity listarEnderecosDaPessoa(@PathVariable Long id) throws PessoaSemEnderecoCadastrado {
        var enderecos = service.listarEnderecosDaPessoa(id);
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping({"","/"})
    @Transactional
    public ResponseEntity alterarEndereco(@RequestBody EnderecoDTO dados) throws EnderecoNaoExisteException {
        var endereco = service.alterarEndereco(dados).converterEntidadeParaDTO();
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEndereco(@PathVariable Long id){
        service.deletarEndereco(id);
        return ResponseEntity.ok().build();
    }
}
