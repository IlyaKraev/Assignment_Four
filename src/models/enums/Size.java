package models.enums;

public enum Size {
    XS(1.0f), S(1.2f), M(1.5f), L(1.8f), XL(2.0f), XXL(2.2f), XXXL(2.5f);

    private final float unitPrice;

    Size(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
