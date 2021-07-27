package org.example.model.entity;

public class JSONCreateQrCode {
    private String clientName;
    private String subdivision;
    private String brand;
    private String typeCartridgeId;
    private String cartridgeId;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeCartridgeId() {
        return typeCartridgeId;
    }

    public void setTypeCartridgeId(String typeCartridgeId) {
        this.typeCartridgeId = typeCartridgeId;
    }

    public String getCartridgeId() {
        return cartridgeId;
    }

    public void setCartridgeId(String cartridgeId) {
        this.cartridgeId = cartridgeId;
    }

    public JSONCreateQrCode(String clientName, String subdivision, String brand, String typeCartridgeId, String cartridgeId) {
        this.clientName = clientName;
        this.subdivision = subdivision;
        this.brand = brand;
        this.typeCartridgeId = typeCartridgeId;
        this.cartridgeId = cartridgeId;
    }
}
