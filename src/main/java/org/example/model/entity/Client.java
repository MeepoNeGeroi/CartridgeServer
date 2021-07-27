package org.example.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private int id;
    private String name;
    private String ynp;
    private String adress;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name) && Objects.equals(ynp, client.ynp) && Objects.equals(adress, client.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ynp, adress);
    }


}