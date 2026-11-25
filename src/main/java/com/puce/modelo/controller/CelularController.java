package com.puce.modelo.controller;

import com.puce.modelo.model.Celular;
import com.puce.modelo.service.CelularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/celular")
public class CelularController {

    private CelularService celularService;

    public CelularController( CelularService celularService){
        this.celularService = celularService;
    }

    @GetMapping
    public List<Celular> verTodos(){
        return celularService.traerTodos();
    }

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Celular> traerUno(@PathVariable int id){
        return celularService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Celular> guardar(@RequestBody  Celular celular){
        Celular nuevoCelular = celularService.guardar(celular);
        return new ResponseEntity<>(nuevoCelular, HttpStatus.CREATED);
    }

    @GetMapping("/total")
    public double total(){
        return celularService.obtenerValorTotal();
    }


}
