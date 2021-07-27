package org.example.model.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "works")
public class Works {
    @Id
    private int id;
    private int worker_id;
    private int jobs_id;
    private int cartridge_id;
    private Date date;
    private int is_upload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getJobs_id() {
        return jobs_id;
    }

    public void setJobs_id(int jobs_id) {
        this.jobs_id = jobs_id;
    }

    public int getCartridge_id() {
        return cartridge_id;
    }

    public void setCartridge_id(int cartridge_id) {
        this.cartridge_id = cartridge_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIs_upload() {
        return is_upload;
    }

    public void setIs_upload(int is_upload) {
        this.is_upload = is_upload;
    }
}
