package br.com.Attornatus.CRUDAttornatus.exception;

/**
 * Classe com o objetivo de implementar a exceção caso o endereco buscado não exista
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public class EnderecoNaoExisteException extends Exception {
    public EnderecoNaoExisteException(){super();}

    public EnderecoNaoExisteException(String msg){super(msg);}
}
