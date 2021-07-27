package org.example.model.entity;

import java.util.Date;
import java.util.Objects;

public class JSONAddCartridge {
    private String subdivisionName;
    private String clientName;
    private String typeCartridge;
    private String brand;
    private int cartridgeNameQR;
    private String serialNumber;
    private String date;

    public JSONAddCartridge(){}

    public String getSubdivisionName() {
        return subdivisionName;
    }

    public void setSubdivisionName(String subdivisionName) {
        this.subdivisionName = subdivisionName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTypeCartridge() {
        return typeCartridge;
    }

    public void setTypeCartridge(String typeCartridge) {
        this.typeCartridge = typeCartridge;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCartridgeNameQR() {
        return cartridgeNameQR;
    }

    public void setCartridgeNameQR(int cartridgeNameQR) {
        this.cartridgeNameQR = cartridgeNameQR;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JSONAddCartridge cartridge = (JSONAddCartridge) o;
        return Objects.equals(subdivisionName, cartridge.subdivisionName) && Objects.equals(clientName, cartridge.clientName) && Objects.equals(typeCartridge, cartridge.typeCartridge) && Objects.equals(brand, cartridge.brand) && Objects.equals(cartridgeNameQR, cartridge.cartridgeNameQR) && Objects.equals(serialNumber, cartridge.serialNumber) && Objects.equals(date, cartridge.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subdivisionName, clientName, typeCartridge, brand, cartridgeNameQR, serialNumber, date);
    }

    @Override
    public String toString() {
        return "Cartridge{" +
                "subdivisionName='" + subdivisionName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", typeCartridge='" + typeCartridge + '\'' +
                ", brand='" + brand + '\'' +
                ", cartridgeNameQR='" + cartridgeNameQR + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
