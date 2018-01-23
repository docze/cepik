package com.mwsi.cepik.cek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
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

    @Column(name = "PESEL", length = 11, unique = true)
    private String pesel;

    @Column(name = "imie", length = 50)
    private String firstName;

    @Column(name = "nazwisko", length = 50)
    private String lastName;

    @Column(name = "data_waznosci_badan", columnDefinition = "DATE")
    private java.sql.Date examinationElapseDate;

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Authorisation> authorisationSet;

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<DrivingLicence> drivingLicenceSet;

    public Driver(Address address, String pesel, String firstName, String lastName, Date examinationElapseDate) {
        this.address = address;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examinationElapseDate = examinationElapseDate;
    }

    public Driver(DriverForm driverForm) {
        this.address = new Address(
                driverForm.getCity(), driverForm.getZipCode(),
                driverForm.getStreet(), driverForm.getHouseNumber(),
                driverForm.getResidenceNumber()
        );
        this.pesel = driverForm.getPesel();
        this.firstName = driverForm.getFirstName();
        this.lastName = driverForm.getLastName();
        this.examinationElapseDate = driverForm.getExaminationElapseDate();
    }
}
