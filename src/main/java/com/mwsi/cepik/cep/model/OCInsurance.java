package com.mwsi.cepik.cep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ubezpieczenie_OC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OCInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_OC")
    private Long id;

    @Column(name = "data_przyznania", nullable = false)
    private java.sql.Date from;

    @Column(name = "data_wygasniecia", nullable = false)
    private java.sql.Date to;

    @Column(name = "numer_polisy", nullable = false)
    private String policyNumber;

    @Column(name = "PIN_polisy", nullable = false)
    private String policyPIN;

}
