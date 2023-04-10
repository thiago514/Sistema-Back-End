package br.com.Attornatus.CRUDAttornatus.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe com o objetivo de orientar o Spring na devolução de erros
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({EnderecoNaoExisteException.class, PessoaJaPossuiEnderecoPrincipal.class, PessoaNaoExisteException.class, PessoaSemEnderecoCadastrado.class})
    public ResponseEntity tratarErro400(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
