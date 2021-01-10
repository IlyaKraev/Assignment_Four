package models.enums;

public enum Color {
    RED(1.0f), ORANGE(1.5f), YELLOW(2.0f), GREEN(2.3f), BLUE(1.9f), INDIGO(2.1f), VIOLET(1.6f);

    private final float unitPrice;

    Color(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
