package com.mwsi.cepik.cep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "numer_rejestracyjny")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_numeru_rej")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pojazdu", nullable = false)
    private Vehicle vehicle;

    @Column(name = "numer", nullable = false, length = 7)
    private String registrationNumber;

    @Column(name = "czy_aktualny", nullable = false)
    private boolean actual;
}
