package com.puce.modelo.service;

import com.puce.modelo.model.Celular;
import com.puce.modelo.repository.CelularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {

    private CelularRepository celularRepository;

    public CelularService(CelularRepository celularRepository){
        this.celularRepository = celularRepository;
    }

    //TRAER TODOS
    public List<Celular> traerTodos(){
        return celularRepository.findAll();
    }

    //TRAER UNO
    public Optional<Celular> traerUno(int id){
        return celularRepository.findById(id);
    }

    //GUARDAR
    public Celular  guardar (Celular celular){
        return celularRepository.save(celular);
    }

    // OBTENER EL VALOR TOTAL DEL INVENTARIO
    public double obtenerValorTotal() {
        List<Celular> celulares = celularRepository.findAll();
        double total = 0;

        for (Celular celular: celulares) {
            total = total + (celular.getPrecio() * celular.getStock());
        }

        return total;
    }
}
