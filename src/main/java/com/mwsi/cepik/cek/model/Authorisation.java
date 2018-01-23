package com.mwsi.cepik.cek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Uprawnienia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorisation {

    public enum Category {
        A("A"), A1("A1"), A2("A2"),
        B("B"), B_E("B+E"),
        C("C"), C_E("C+E"), C1("C1"), C1_E("C1+E"),
        D("D"), D_E("D+E"), D1("D1"), D1_E("D1+E");

        private String name;

        Category(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_uprawnienia")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "kategoria")
    private Category category;

    @Column(name = "data_przyznania")
    private java.sql.Date from;

    @Column(name = "data_wygasniecia")
    private java.sql.Date to;

    @ManyToOne
    @JoinColumn(name = "id_kierowcy", nullable = false)
    private Driver driver;

    public Authorisation(Category category, java.sql.Date from, java.sql.Date to, Driver driver) {
        this.category = category;
        this.from = from;
        this.to = to;
        this.driver = driver;
    }
}
