package com.puce.modelo.service;

import com.puce.modelo.model.Platillo;
import com.puce.modelo.repository.PlatilloRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlatilloService {

    private PlatilloRepository platilloRepository;

    public PlatilloService(PlatilloRepository platilloRepository){
        this.platilloRepository = platilloRepository;
    }

    //TRAER TODOS
    public List<Platillo> traerTodos(){
        return platilloRepository.findAll();
    }

    //TRAER UNO
    public Optional<Platillo> traerUno(int id){
        return platilloRepository.findById(id);
    }

    //GUARDAR
    public Platillo  guardar (Platillo platillo){
        return platilloRepository.save(platillo);
    }

    //EDITAR
    public Optional <Platillo> editar(int id, Platillo platilloActualizado){
        return platilloRepository.findById(id)
                .map( platilloExiste ->{
                    platilloExiste.setNombre( platilloActualizado.getNombre());
                    platilloExiste.setPrecio(platilloActualizado.getPrecio());

                    return platilloRepository.save( platilloExiste);
                });
    }

    //ELIMINAR
    public boolean eliminar (int id){
        if ( platilloRepository.existsById(id)){
            platilloRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //LISTAR SOLO PLATILLOS VEGETARIANOS
    public List <Platillo> vegetarianos(){
        List <Platillo> platillos = platilloRepository.findAll();
        List <Platillo> vegetarianos = new ArrayList<>();

        for ( Platillo platillo: platillos){
            if (platillo.isVegetariano()== true){
            vegetarianos.add(platillo);
            }
        }
        return vegetarianos;
    }


}
