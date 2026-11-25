package com.puce.modelo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Celular {

    @Id
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
}
