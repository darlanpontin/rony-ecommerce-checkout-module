package br.com.rony.ecommerce.domain.entities.Idempotency;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Registra chaves de idempotência para evitar duplicação de requisições.
 */
@Entity
@Table(name = "idempotency_keys", indexes = {
    @Index(name = "idx_key_hash", columnList = "key_hash", unique = true),
    @Index(name = "idx_expires_at", columnList = "expires_at")
})
public class IdempotencyKey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String keyHash;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String responseBody;
    
    @Column(nullable = false)
    private Integer responseHttpStatus;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getKeyHash() { return keyHash; }
    public void setKeyHash(String keyHash) { this.keyHash = keyHash; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getResponseBody() { return responseBody; }
    public void setResponseBody(String responseBody) { this.responseBody = responseBody; }
    
    public Integer getResponseHttpStatus() { return responseHttpStatus; }
    public void setResponseHttpStatus(Integer responseHttpStatus) { this.responseHttpStatus = responseHttpStatus; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
}
