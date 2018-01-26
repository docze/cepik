package com.mwsi.cepik.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "id_modelu", nullable = false)
    private CarModel model;

    @Column(name = "rok_produkcji", nullable = false, length = 4)
    private String productionYear;

    @Column(name = "vin", nullable = false, length = 17, unique = true)
    private String vin;

    @Column(name = "numer_silnika", nullable = false, unique = true)
    private String engineNumber;

    @Column(name = "moc_silnika_KM", nullable = false)
    private int enginePower;

    @Column(name = "pojemnosc_silnika", nullable = false)
    private double engineCapacity;

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

    @Column(name = "data_waznosci_badania")
    private java.sql.Date servicingDate;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<RegistrationNumber> registrationNumberSet;

    @OneToMany(mappedBy = "carOwner")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<OCInsurance> ocInsuranceSet;
}
