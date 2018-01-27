package com.mwsi.cepik.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "dowod_rejestracyjny")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dowodu")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pojazdu", nullable = false)
    private Vehicle vehicle;

    @Size(max = 50)
    private String sequence;

    @Column(name = "data_waznosci", nullable = false)
    private java.sql.Date to;

    @ManyToMany(mappedBy = "registrationDocumentList")
    @JsonIgnore
    private Set<CarOwner> carOwnerSet;

}
