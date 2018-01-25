package com.mwsi.cepik.cep.model;

import com.mwsi.cepik.cek.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "wlasciciel_pojazdu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_wlasciciela")
    private Long id;

    @Embedded
    private Address address;

    @Column(name = "PESEL", length = 11, unique = true)
    private String pesel;

    @Column(name = "REGON", length = 9, unique = true)
    private String regon;

    @Column(name = "imie", length = 50)
    private String firstName;

    @Column(name = "nazwisko", length = 50)
    private String lastName;

    @Column(name = "nazwa_instytucji", length = 50)
    private String institution;

}
