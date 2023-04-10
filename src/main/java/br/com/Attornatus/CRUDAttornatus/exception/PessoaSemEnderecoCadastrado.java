package br.com.Attornatus.CRUDAttornatus.exception;

/**
 * Classe com o objetivo de implementar a exceção caso a pessoa não possua nenhum endereço cadastrado no momento de buscar por endereços desse pessoa
 *
 * @author Thiago Gogola Milagres
 * @since 06/04/2023
 */
public class PessoaSemEnderecoCadastrado extends Exception {
    public PessoaSemEnderecoCadastrado(){super();}

    public PessoaSemEnderecoCadastrado(String msg){super(msg);}
}
