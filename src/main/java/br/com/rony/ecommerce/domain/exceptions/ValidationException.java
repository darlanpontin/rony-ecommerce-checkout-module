package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção genérica de validação.
 */
public class ValidationException extends RuntimeException {
    private String errorCode;
    
    public ValidationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}
