package com.puce.modelo.controller;

import com.puce.modelo.model.Platillo;
import com.puce.modelo.service.PlatilloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platillo")
public class PlatilloController {

    private PlatilloService platilloService;

    public PlatilloController( PlatilloService platilloService){
        this.platilloService = platilloService;
    }

    @GetMapping
    public List<Platillo> verTodos(){
        return platilloService.traerTodos();
    }

    //TRAER UNO
    @GetMapping("/{id}")
    public ResponseEntity<Platillo> traerUno(@PathVariable int id){
        return platilloService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Platillo> guardar(@RequestBody  Platillo platillo){
        Platillo nuevoPlatillo = platilloService.guardar(platillo);
        return new ResponseEntity<>(nuevoPlatillo, HttpStatus.CREATED);
    }

    //EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Platillo> editar(@PathVariable int id, @RequestBody Platillo platillo){
        return platilloService.editar(id, platillo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Platillo> eliminar (@PathVariable int id){
        if (platilloService.eliminar(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/vegetarianos")
    public List<Platillo> vegetarianos(){
        return platilloService.vegetarianos();
    }

}
