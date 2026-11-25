package com.puce.modelo.service;

import com.puce.modelo.model.Celular;
import com.puce.modelo.model.Evento;
import com.puce.modelo.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    //TRAER TODOS
    public List<Evento> traerTodos(){
        return eventoRepository.findAll();
    }

    //TRAER UNO
    public Optional<Evento> traerUno(int id){
        return eventoRepository.findById(id);
    }

    //GUARDAR
    public Evento  guardar (Evento evento){
        return eventoRepository.save(evento);
    }

    //LISTAR EVENTOS ORDENADOS POR PRECIO DE MENOR A MAYOR
    public List<Evento> ordenados() {
        List<Evento> eventos = eventoRepository.findAll();
        eventos.sort((e1, e2) -> Double.compare(e1.getPrecioEntrada(), e2.getPrecioEntrada()));
        return eventos;
    }



}
