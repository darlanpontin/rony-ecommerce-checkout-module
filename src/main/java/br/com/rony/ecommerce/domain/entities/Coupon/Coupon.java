package br.com.rony.ecommerce.domain.entities.Coupon;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidade que representa cupons de desconto disponíveis no sistema.
 */
@Entity
@Table(name = "coupons", indexes = {
    @Index(name = "idx_code", columnList = "code", unique = true),
    @Index(name = "idx_valid_dates", columnList = "valid_from,valid_until")
})
public class Coupon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String code;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discountValue;
    
    @Column(length = 500)
    private String applicableCategories;
    
    @Column(length = 500)
    private String applicableProducts;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal minimumPurchaseAmount;
    
    @Column(nullable = false)
    private LocalDateTime validFrom;
    
    @Column(nullable = false)
    private LocalDateTime validUntil;
    
    @Column(nullable = false)
    private Integer maxUsagePerCustomer;
    
    @Column(nullable = false)
    private Integer maxTotalUsage;
    
    @Column(nullable = false)
    private Integer currentUsage;
    
    @Column(nullable = false)
    private Boolean active;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public DiscountType getDiscountType() { return discountType; }
    public void setDiscountType(DiscountType discountType) { this.discountType = discountType; }
    
    public BigDecimal getDiscountValue() { return discountValue; }
    public void setDiscountValue(BigDecimal discountValue) { this.discountValue = discountValue; }
    
    public String getApplicableCategories() { return applicableCategories; }
    public void setApplicableCategories(String applicableCategories) { this.applicableCategories = applicableCategories; }
    
    public String getApplicableProducts() { return applicableProducts; }
    public void setApplicableProducts(String applicableProducts) { this.applicableProducts = applicableProducts; }
    
    public BigDecimal getMinimumPurchaseAmount() { return minimumPurchaseAmount; }
    public void setMinimumPurchaseAmount(BigDecimal minimumPurchaseAmount) { this.minimumPurchaseAmount = minimumPurchaseAmount; }
    
    public LocalDateTime getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDateTime validFrom) { this.validFrom = validFrom; }
    
    public LocalDateTime getValidUntil() { return validUntil; }
    public void setValidUntil(LocalDateTime validUntil) { this.validUntil = validUntil; }
    
    public Integer getMaxUsagePerCustomer() { return maxUsagePerCustomer; }
    public void setMaxUsagePerCustomer(Integer maxUsagePerCustomer) { this.maxUsagePerCustomer = maxUsagePerCustomer; }
    
    public Integer getMaxTotalUsage() { return maxTotalUsage; }
    public void setMaxTotalUsage(Integer maxTotalUsage) { this.maxTotalUsage = maxTotalUsage; }
    
    public Integer getCurrentUsage() { return currentUsage; }
    public void setCurrentUsage(Integer currentUsage) { this.currentUsage = currentUsage; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
