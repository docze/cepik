package com.mwsi.cepik.cek;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prawo_jazdy")
@Data
@NoArgsConstructor
@AllArgsConstructor
class DrivingLicence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prawa_jazdy")
    private Long id;

    @Column(name = "data_wydania")
    private LocalDate from;

    @Column(name = "data_wygasniecia")
    private LocalDate to;

    @Column(name = "seria", length = 50)
    private String sequence;

    @ManyToOne
    @JoinColumn(name = "id_kierowcy", nullable = false)
    private Driver driver;
}
