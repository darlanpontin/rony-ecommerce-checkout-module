package br.com.rony.ecommerce.domain.entities.Coupon;

/**
 * Tipos de desconto suportados pelos cupons.
 */
public enum DiscountType {
    PERCENTAGE("Percentual"),
    FIXED_VALUE("Valor Fixo");
    
    private final String description;
    
    DiscountType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
