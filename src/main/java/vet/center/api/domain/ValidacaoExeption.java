package vet.center.api.domain;

public class ValidacaoExeption extends RuntimeException {
    public ValidacaoExeption(String mensagem) {
        super(mensagem);
    }
}
