package com.mwsi.cepik.cek.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prawo_jazdy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrivingLicence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prawa_jazdy")
    private Long id;

    @Column(name = "data_wydania", nullable = false)
    private java.sql.Date from;

    @Column(name = "data_wygasniecia", nullable = false)
    private java.sql.Date to;

    @Column(name = "seria", length = 50, nullable = false)
    private String sequence;

    @ManyToOne
    @JoinColumn(name = "id_kierowcy", nullable = false)
    private Driver driver;

    public DrivingLicence(Date from, Date to, String sequence, Driver driver) {
        this.from = from;
        this.to = to;
        this.sequence = sequence;
        this.driver = driver;
    }
}
