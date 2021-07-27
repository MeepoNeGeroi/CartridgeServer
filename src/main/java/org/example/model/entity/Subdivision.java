package org.example.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subdivision")
public class Subdivision {

    @Id
    private int id;
    private String name;
    private String ynp;
    private String adress;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Cartridge> cartridges = new ArrayList<>();
    private int client_id;

//    public List<Cartridge> getCartridges() {
//        return cartridges;
//    }
//
//    public void setCartridges(List<Cartridge> cartridges) {
//        this.cartridges = cartridges;
//    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

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

    public String getYnp() {
        return ynp;
    }

    public void setYnp(String ynp) {
        this.ynp = ynp;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subdivision that = (Subdivision) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(ynp, that.ynp) && Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ynp, adress);
    }

    @Override
    public String toString() {
        return name;
    }
}
