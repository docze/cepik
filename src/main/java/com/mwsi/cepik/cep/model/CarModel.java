package com.mwsi.cepik.cep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "model")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modelu")
    private Long id;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @ManyToOne
    @JoinColumn(name = "id_marki", nullable = false)
    private CarBrand brand;

    public CarModel(CarBrand brand, String model) {
        this.model = model;
        this.brand = brand;
    }
}
