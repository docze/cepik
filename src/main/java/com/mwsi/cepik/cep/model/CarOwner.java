package com.mwsi.cepik.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mwsi.cepik.cek.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "carOwner")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OCInsurance> ocInsuranceSet;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "wlasciciel_dowodRejestracyjny",
            joinColumns = {@JoinColumn(name = "id_wlasciciela")},
            inverseJoinColumns = {@JoinColumn(name = "id_dowodu")}
    )
    @JsonProperty
    private List<RegistrationDocument> registrationDocumentList;

}
