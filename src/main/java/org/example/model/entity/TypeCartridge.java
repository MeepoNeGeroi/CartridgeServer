package org.example.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_cartridge")
public class TypeCartridge {
    @Id
    private int id;
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Cartridge> cartridges = new ArrayList<>();
    private int brand_id;

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
    //    public List<Cartridge> getCartridges() {
//        return cartridges;
//    }
//
//    public void setCartridges(List<Cartridge> cartridges) {
//        this.cartridges = cartridges;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getBrand_id() {
//        return brand_id;
//    }
//
//    public void setBrand_id(int brand_id) {
//        this.brand_id = brand_id;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Type_cartridge that = (Type_cartridge) o;
//        return id == that.id ==  Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, brand_id);
//    }
//
//    @Override
//    public String toString() {
//        return "Type_cartridge{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", brand_id=" + brand_id +
//                '}';
//    }
}
