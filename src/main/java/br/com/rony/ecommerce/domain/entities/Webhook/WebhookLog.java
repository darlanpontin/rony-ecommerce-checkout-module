package br.com.rony.ecommerce.domain.entities.Webhook;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Registra todos os webhooks recebidos do gateway de pagamento para auditoria.
 */
@Entity
@Table(name = "webhook_logs", indexes = {
    @Index(name = "idx_order_id", columnList = "order_id"),
    @Index(name = "idx_event_type", columnList = "event_type")
})
public class WebhookLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_id")
    private Long orderId;
    
    @Column(nullable = false, length = 50)
    private String eventType;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String payload;
    
    @Column(nullable = false)
    private Boolean signatureValid;
    
    @Column(nullable = false)
    private Boolean processed;
    
    @Column(columnDefinition = "TEXT")
    private String processingError;
    
    @Column
    private Integer retryCount;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column
    private LocalDateTime processedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        retryCount = 0;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    
    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
    
    public Boolean getSignatureValid() { return signatureValid; }
    public void setSignatureValid(Boolean signatureValid) { this.signatureValid = signatureValid; }
    
    public Boolean getProcessed() { return processed; }
    public void setProcessed(Boolean processed) { this.processed = processed; }
    
    public String getProcessingError() { return processingError; }
    public void setProcessingError(String processingError) { this.processingError = processingError; }
    
    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getProcessedAt() { return processedAt; }
    public void setProcessedAt(LocalDateTime processedAt) { this.processedAt = processedAt; }
}
