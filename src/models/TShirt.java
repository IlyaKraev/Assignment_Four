package models;

import models.enums.Size;
import models.enums.Fabric;
import models.enums.Color;


public class TShirt {
    private String name;
    private Color color;
    private Size size;
    private Fabric fabric;

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TShirt: name= ").append(name);
        sb.append(", size= ").append(size);
        sb.append(", color= ").append(color);
        sb.append(", fabric= ").append(fabric);
        return sb.toString();
    }
    
    
    
    
}
