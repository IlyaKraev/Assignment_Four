
package models.enums;

public enum Fabric {
    WOOL(12.5f), COTTON(15.4f), POLYESTER(10.9f), RAYON(17.9f), LINEN(20.0f), CASHMERE(34.9f), SILK(43.4f);

    private final float unitPrice;
    
    Fabric(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
