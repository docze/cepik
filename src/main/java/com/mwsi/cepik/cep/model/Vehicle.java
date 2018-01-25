package com.mwsi.cepik.cep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pojazd")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pojazdu")
    private Long id;

    @Column(name = "marka", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @Column(name = "model", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarModel model;

    @Column(name = "rok_produkcji", nullable = false, length = 4)
    private String productionYear;

    @Column(name = "vin", nullable = false, length = 17)
    private String vin;

    @Column(name = "numer_silnika", nullable = false)
    private String engineNumber;

    @Column(name = "moc_silnika", nullable = false)
    private int enginePower;

    @Column(name = "pojemnosc_silnika", nullable = false)
    private float engineCapacity;

    @Column(name = "liczba_miejsc", nullable = false)
    private int numberOfSeats;

    @Column(name = "data_pierwszej_rejestracji", nullable = false)
    private java.sql.Date firstRegistrationDate;

    @Column(name = "masa_wlasna_kg", nullable = false)
    private int curbWeight;

    @Column(name = "dopuszczalna_masa_calkowita_kg", nullable = false)
    private int permissibleLadenMass;

    @Column(name = "liczba_osi", nullable = false)
    private int numberOfAxies;

    @Column(name = "uprzywilejowany", nullable = false)
    private boolean privileged;
}
