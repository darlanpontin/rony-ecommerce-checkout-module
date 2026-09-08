package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção para validações de pagamento.
 */
public class PaymentValidationException extends RuntimeException {
    private String errorCode;
    private String fieldName;
    
    public PaymentValidationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public PaymentValidationException(String message, String errorCode, String fieldName) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
    }
    
    public String getErrorCode() { return errorCode; }
    public String getFieldName() { return fieldName; }
}
