package br.com.Attornatus.CRUDAttornatus.exception;
/**
 * Classe com o objetivo de implementar a exceção caso a pessoa buscada não exista
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public class PessoaNaoExisteException extends Exception {
    public PessoaNaoExisteException(){super();}

    public PessoaNaoExisteException(String msg){super(msg);}
}
