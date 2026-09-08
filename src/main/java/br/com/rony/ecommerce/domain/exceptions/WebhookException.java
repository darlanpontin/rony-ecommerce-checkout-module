package br.com.rony.ecommerce.domain.exceptions;

/**
 * Exceção para erros de webhook.
 */
public class WebhookException extends RuntimeException {
    private String errorCode;
    
    public WebhookException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}
