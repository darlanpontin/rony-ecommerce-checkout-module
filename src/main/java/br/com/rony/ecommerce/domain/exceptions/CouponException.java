package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção para validações de cupom.
 */
public class CouponException extends RuntimeException {
    private String errorCode;
    
    public CouponException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}
