package org.example.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "cartridge")
public class Cartridge {

    @Id
    private int id;
    private int type_cartridge_id;
    private int subdivision_id;
    private int cartridge_id;
    private int is_upload;
    private String tableDate;

    public int getType_cartridge_id() {
        return type_cartridge_id;
    }

    public void setType_cartridge_id(int type_cartridge_id) {
        this.type_cartridge_id = type_cartridge_id;
    }

    public int getSubdivision_id() {
        return subdivision_id;
    }

    public void setSubdivision_id(int subdivision_id) {
        this.subdivision_id = subdivision_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartridge_id() {
        return cartridge_id;
    }

    public void setCartridge_id(int cartridge_id) {
        this.cartridge_id = cartridge_id;
    }

    public int getIs_upload() {
        return is_upload;
    }

    public void setIs_upload(int is_upload) {
        this.is_upload = is_upload;
    }

    public String getTableDate() {
        return tableDate;
    }

    public void setTableDate
            (String date) {
        this.tableDate = date;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cartridge cartridge = (Cartridge) o;
//        return id == cartridge.id && type_cartridge_id == cartridge.type_cartridge_id && subdivision_id == cartridge.subdivision_id && cartridge_id == cartridge.cartridge_id && is_upload == cartridge.is_upload && Objects.equals(date, cartridge.date);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type_cartridge_id, subdivision_id, cartridge_id, is_upload, date);
//    }
//
//    @Override
//    public String toString() {
//        return "Cartridge{" +
//                "id=" + id +
//                ", type_cartridge_id=" + type_cartridge_id +
//                ", subdivision_id=" + subdivision_id +
//                ", cartridge_id=" + cartridge_id +
//                ", is_upload=" + is_upload +
//                ", date=" + date +
//                '}';
//    }
}
