package br.com.rony.ecommerce.domain.entities.Order;

public enum OrderStatus {
    PENDING("Pendente"),
    CONFIRMED("Confirmado"),
    PROCESSING("Processando"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELLED("Cancelado"),
    REFUNDED("Reembolsado");
    
    private final String description;
    
    OrderStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
