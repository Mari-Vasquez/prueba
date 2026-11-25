package com.puce.modelo.controller;

import com.puce.modelo.model.Celular;
import com.puce.modelo.model.Evento;
import com.puce.modelo.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private EventoService eventoService;

    public EventoController( EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> verTodos(){
        return eventoService.traerTodos();
    }

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Evento> traerUno(@PathVariable int id){
        return eventoService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Evento> guardar(@RequestBody  Evento evento){
        Evento nuevoEvento = eventoService.guardar(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

    @GetMapping("/ordenados")
    public List<Evento> eventosOrdenados() {
        return eventoService.ordenados();
    }

}
