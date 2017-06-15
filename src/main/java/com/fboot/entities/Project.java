package com.fboot.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author RipPer
 */
@Entity
@Table(name = "project")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "pathP")
    String pathP;

    public Project() {
    }

    public Project(String name, String pathP) {
        this.name = name;
        this.pathP = pathP;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPathP() {
        return pathP;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPathP(String pathP) {
        this.pathP = pathP;
    }
    
}
