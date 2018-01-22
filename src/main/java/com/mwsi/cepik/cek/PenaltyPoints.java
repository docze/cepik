package com.mwsi.cepik.cek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "punkty_karne")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_punktow_karnych")
    private Long id;

    @Column(name = "liczba")
    private int count;

    @Column(name = "data_przyznania")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_kierowcy", nullable = false)
    private Driver driver;

}
