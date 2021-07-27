package org.example.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs_for_worker")
public class JobsAndWorkers {
    @Id
    private int id;
    private String name;
    private String sound_name;
    private String jobs_name_qr;

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

    public String getSound_name() {
        return sound_name;
    }

    public void setSound_name(String sound_name) {
        this.sound_name = sound_name;
    }

    public String getJobs_name_qr() {
        return jobs_name_qr;
    }

    public void setJobs_name_qr(String jobs_name_qr) {
        this.jobs_name_qr = jobs_name_qr;
    }
}
