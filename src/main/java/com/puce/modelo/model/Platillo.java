package com.puce.modelo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Platillo {

    @Id
    private int id;
    private String nombre;
    private double precio;
    private boolean vegetariano;
}
