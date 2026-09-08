package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção para validações de frete.
 */
public class ShippingException extends RuntimeException {
    private String errorCode;
    
    public ShippingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}
