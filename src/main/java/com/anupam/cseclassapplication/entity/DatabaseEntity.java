package com.anupam.cseclassapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Class_Item")
public class DatabaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String din;

    @Getter
    @Setter
    private String p1;

    @Getter
    @Setter
    private String p2;

    @Getter
    @Setter
    private String tb;

    @Getter
    @Setter
    private String p3;

    @Getter
    @Setter
    private String p4;

    @Getter
    @Setter
    private String lb;

    @Getter
    @Setter
    private String p5;

    public DatabaseEntity () {

    }

    public DatabaseEntity ( String din, String p1, String p2, String tb, String p3,String p4,
    String lb, String p5 ) {
      
        this.din = din;
        this.p1= p1;
        this.p2=p2;
        this.tb = tb;
        this.p3=p3;
        this.p4= p4;
        this.lb=lb;
        this.p5=p5;
    }

    @Override
    public String toString () {
        return String.format("DatabaseEntity{ id = %d, din = '%s', p1 = '%s',p2= '%s', tb = '%s', p3 = '%s', p4 ='%s', lb = '%s', p5 = '%s'}"
        ,id,din,p1,p2,tb,p3,p4,lb,p5);
    }
}
