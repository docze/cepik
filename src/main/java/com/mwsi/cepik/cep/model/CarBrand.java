package com.mwsi.cepik.cep.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "marka")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marki")
    private Long id;

    @Column(name = "marka", nullable = false, length = 100)
    private String brand;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<CarModel> carModelSet;

    public CarBrand(String brand) {
        this.brand = brand;
    }
}
