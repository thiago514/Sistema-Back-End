package br.com.Attornatus.CRUDAttornatus.exception;

/**
 * Classe com o objetivo de implementar a exceção caso o usuario tente cadastrar dois endereços como principal para uma unica pessoa
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public class PessoaJaPossuiEnderecoPrincipal extends Exception {
    public PessoaJaPossuiEnderecoPrincipal(){super();}

    public PessoaJaPossuiEnderecoPrincipal(String msg){super(msg);}
}
