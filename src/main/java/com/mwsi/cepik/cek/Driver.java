package com.mwsi.cepik.cek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Kierowca")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kierowcy")
    private Long id;

    @Embedded
    private Address address;

    @Column(name = "PESEL", length = 11)
    private String PESEL;

    @Column(name = "imie", length = 50)
    private String firstName;

    @Column(name = "nazwisko", length = 50)
    private String lastName;

    @Column(name = "data_waznosci_badan")
    private LocalDate examinationElapseDate;

    @OneToMany(mappedBy = "driver")
    private Set<Authorisation> authorisationSet;

    @OneToMany(mappedBy = "driver")
    private Set<DrivingLicence> drivingLicenceSet;

}
