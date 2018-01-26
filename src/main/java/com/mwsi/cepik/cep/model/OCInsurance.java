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

    @Column(name = "numer_i_PIN_polisy", nullable = false, unique = true)
    private String policyNumberAndPIN;

    @ManyToOne
    @JoinColumn(name = "id_wlasciciela", nullable = false)
    private CarOwner carOwner;

    @ManyToOne
    @JoinColumn(name = "id_pojazdu", nullable = false)
    private Vehicle vehicle;

}
