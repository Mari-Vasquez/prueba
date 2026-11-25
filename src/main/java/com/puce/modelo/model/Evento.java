package com.puce.modelo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Evento {

    @Id
    private int id;
    private String nombre;
    private String fecha;
    private int aforo;
    private double precioEntrada;

}
