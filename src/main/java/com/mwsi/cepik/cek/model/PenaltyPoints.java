package com.mwsi.cepik.cek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "punkty_karne")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_punktow_karnych")
    private Long id;

    @Column(name = "liczba", nullable = false)
    private int count;

    @Column(name = "data_przyznania", nullable = false)
    private java.sql.Date date;

    @ManyToOne
    @JoinColumn(name = "id_kierowcy", nullable = false)
    private Driver driver;

    public PenaltyPoints(int count, Date date, Driver driver) {
        this.count = count;
        this.date = date;
        this.driver = driver;
    }
}
