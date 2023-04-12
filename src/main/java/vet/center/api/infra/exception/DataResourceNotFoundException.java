package vet.center.api.infra.exception;

public class DataResourceNotFoundException extends RuntimeException {
    public DataResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
