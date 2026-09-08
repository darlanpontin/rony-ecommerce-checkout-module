package br.com.rony.ecommerce.domain.entities.Coupon;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Registra o uso de cupons por cliente para controle de limite.
 */
@Entity
@Table(name = "coupon_usage", indexes = {
    @Index(name = "idx_coupon_user", columnList = "coupon_id,user_id"),
    @Index(name = "idx_order_id", columnList = "order_id")
})
public class CouponUsage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime usedAt;
    
    @PrePersist
    protected void onCreate() {
        usedAt = LocalDateTime.now();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Coupon getCoupon() { return coupon; }
    public void setCoupon(Coupon coupon) { this.coupon = coupon; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    
    public LocalDateTime getUsedAt() { return usedAt; }
}
