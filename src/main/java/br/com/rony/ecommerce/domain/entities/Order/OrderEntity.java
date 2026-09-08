package br.com.rony.ecommerce.domain.entities.Order;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Entidade que representa um pedido no sistema.
 * Armazena informações do pedido, cliente, endereço de entrega e valores.
 */
@Entity
@Table(name = "orders")
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String orderNumber;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal automaticDiscount;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal couponDiscount;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal shippingCost;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    @Column(length = 50)
    private String appliedCoupon;
    
    @Column(length = 50)
    private String shippingType;
    
    @Column(length = 3)
    private String shippingDays;
    
    @Column(length = 8)
    private String shippingCep;
    
    @Column(nullable = false)
    private String deliveryAddress;
    
    @Column(length = 20)
    private String customerName;
    
    @Column(length = 100)
    private String customerEmail;
    
    @Column(length = 20)
    private String customerPhone;
    
    @Column(length = 14)
    private String customerCpf;
    
    @Column(length = 50)
    private String gatewayTransactionId;
    
    @Column(length = 50)
    private String maskCardNumber;
    
    @Column(length = 20)
    private String cardBrand;
    
    @Column
    private Integer cardInstallments;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal installmentValue;
    
    @Column(length = 500)
    private String pixQrCode;
    
    @Column(length = 500)
    private String pixCopyCola;
    
    @Column(length = 100)
    private String pixKey;
    
    @Column
    private LocalDateTime pixExpirationTime;
    
    @Column
    private Integer fraudRiskScore;
    
    @Column(columnDefinition = "TEXT")
    private String fraudMotives;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> items = new ArrayList<>();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PaymentTransaction> transactions = new ArrayList<>();
    
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
    
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
    
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    
    public BigDecimal getAutomaticDiscount() { return automaticDiscount; }
    public void setAutomaticDiscount(BigDecimal automaticDiscount) { this.automaticDiscount = automaticDiscount; }
    
    public BigDecimal getCouponDiscount() { return couponDiscount; }
    public void setCouponDiscount(BigDecimal couponDiscount) { this.couponDiscount = couponDiscount; }
    
    public BigDecimal getShippingCost() { return shippingCost; }
    public void setShippingCost(BigDecimal shippingCost) { this.shippingCost = shippingCost; }
    
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    
    public String getAppliedCoupon() { return appliedCoupon; }
    public void setAppliedCoupon(String appliedCoupon) { this.appliedCoupon = appliedCoupon; }
    
    public String getShippingType() { return shippingType; }
    public void setShippingType(String shippingType) { this.shippingType = shippingType; }
    
    public String getShippingDays() { return shippingDays; }
    public void setShippingDays(String shippingDays) { this.shippingDays = shippingDays; }
    
    public String getShippingCep() { return shippingCep; }
    public void setShippingCep(String shippingCep) { this.shippingCep = shippingCep; }
    
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    
    public String getCustomerCpf() { return customerCpf; }
    public void setCustomerCpf(String customerCpf) { this.customerCpf = customerCpf; }
    
    public String getGatewayTransactionId() { return gatewayTransactionId; }
    public void setGatewayTransactionId(String gatewayTransactionId) { this.gatewayTransactionId = gatewayTransactionId; }
    
    public String getMaskCardNumber() { return maskCardNumber; }
    public void setMaskCardNumber(String maskCardNumber) { this.maskCardNumber = maskCardNumber; }
    
    public String getCardBrand() { return cardBrand; }
    public void setCardBrand(String cardBrand) { this.cardBrand = cardBrand; }
    
    public Integer getCardInstallments() { return cardInstallments; }
    public void setCardInstallments(Integer cardInstallments) { this.cardInstallments = cardInstallments; }
    
    public BigDecimal getInstallmentValue() { return installmentValue; }
    public void setInstallmentValue(BigDecimal installmentValue) { this.installmentValue = installmentValue; }
    
    public String getPixQrCode() { return pixQrCode; }
    public void setPixQrCode(String pixQrCode) { this.pixQrCode = pixQrCode; }
    
    public String getPixCopyCola() { return pixCopyCola; }
    public void setPixCopyCola(String pixCopyCola) { this.pixCopyCola = pixCopyCola; }
    
    public String getPixKey() { return pixKey; }
    public void setPixKey(String pixKey) { this.pixKey = pixKey; }
    
    public LocalDateTime getPixExpirationTime() { return pixExpirationTime; }
    public void setPixExpirationTime(LocalDateTime pixExpirationTime) { this.pixExpirationTime = pixExpirationTime; }
    
    public Integer getFraudRiskScore() { return fraudRiskScore; }
    public void setFraudRiskScore(Integer fraudRiskScore) { this.fraudRiskScore = fraudRiskScore; }
    
    public String getFraudMotives() { return fraudMotives; }
    public void setFraudMotives(String fraudMotives) { this.fraudMotives = fraudMotives; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    
    public List<PaymentTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<PaymentTransaction> transactions) { this.transactions = transactions; }
}
