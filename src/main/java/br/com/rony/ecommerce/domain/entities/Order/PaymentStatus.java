package br.com.rony.ecommerce.domain.entities.Order;

public enum PaymentStatus {
    PENDING("Pendente"),
    PROCESSING("Processando"),
    APPROVED("Aprovado"),
    DECLINED("Recusado"),
    CANCELLED("Cancelado"),
    REFUNDED("Reembolsado"),
    FRAUD_BLOCKED("Bloqueado por fraude");
    
    private final String description;
    
    PaymentStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
