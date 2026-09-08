package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção para erros de gateway de pagamento.
 */
public class PaymentGatewayException extends RuntimeException {
    private String errorCode;
    
    public PaymentGatewayException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}
