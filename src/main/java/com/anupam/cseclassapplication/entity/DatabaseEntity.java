package com.anupam.cseclassapplication.entity;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import java.sql.Time;

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

    //@CreationTimestamp
    @Getter
    @Setter
    private String p1Time;

    //@CreationTimestamp
    @Getter
    @Setter
    private String p2Time;

    //@CreationTimestamp
    @Getter
    @Setter
    private String p3Time;

    //@CreationTimestamp
    @Getter
    @Setter
    private String p4Time;

    //@CreationTimestamp
    @Getter
    @Setter
    private String p5Time;

    public DatabaseEntity() {

    }

    public DatabaseEntity(String din, String p1,String p1Time, String p2,String p2Time, String tb, String p3, String p3Time, String p4, String p4Time,
            String lb, String p5, String p5Time ) {

        this.din = din;
        this.p1 = p1;
        this.p1Time = p1Time;
        this.p2 = p2;
        this.p2Time = p2Time;
        this.tb = tb;
        this.p3 = p3;
        this.p3Time = p3Time;
        this.p4 = p4;
        this.p4Time = p4Time;
        this.lb = lb;
        this.p5 = p5;
        this.p5Time = p5Time;
    }

    // Getter and setter methods for Time fields

    // public Time getP1Time() {
    //     return p1Time;
    // }

    // public void setP1Time(Time p1Time) {
    //     this.p1Time = p1Time;
    // }

    // public Time getP2Time() {
    //     return p2Time;
    // }

    // public void setP2Time(Time p2Time) {
    //     this.p2Time = p2Time;
    // }

    // public Time getP3Time() {
    //     return p3Time;
    // }

    // public void setP3Time(Time p3Time) {
    //     this.p3Time = p3Time;
    // }

    // public Time getP4Time() {
    //     return p4Time;
    // }

    // public void setP4Time(Time p4Time) {
    //     this.p4Time = p4Time;
    // }

    // public Time getP5Time() {
    //     return p1Time;
    // }

    // public void setP5Time(Time p5Time) {
    //     this.p5Time = p5Time;
    // }

    @Override
    public String toString() {
        return String.format(
                "DatabaseEntity{ id = %d, din = '%s', p1 = '%s' (time: %s), p2 = '%s' (time: %s), tb = (time: %s), p3 = '%s' (time: %s), p4 = '%s' (time: %s), lb = (time: %s), p5 = '%s' (time: %s)}",
                id, din, p1, p1Time, p2, p2Time, tb, p3, p3Time, p4, p4Time, lb, p5, p5Time);
    }
}
