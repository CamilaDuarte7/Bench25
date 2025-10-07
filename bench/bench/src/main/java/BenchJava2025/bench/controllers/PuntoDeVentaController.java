package BenchJava2025.bench.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BenchJava2025.bench.dto.PuntoDeVentaDTO;
import BenchJava2025.bench.services.PuntoDeVentaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/puntosVenta/")
public class PuntoDeVentaController {

    
    private final PuntoDeVentaServiceImpl puntoDeVentaService;

    @GetMapping
    private List<PuntoDeVentaDTO> getAllPuntoDeVentas(){
        return puntoDeVentaService.getAllPuntoDeVentas();
    }

    @PostMapping("nuevo")
    private ResponseEntity<PuntoDeVentaDTO> addPuntoDeVenta(@RequestBody PuntoDeVentaDTO puntoDeVentaDTO){
        return ResponseEntity.ok(puntoDeVentaService.addPuntoDeVenta(puntoDeVentaDTO));
    }

    @PutMapping("actualizar/{id}/{nombre}")
    private ResponseEntity<PuntoDeVentaDTO> updatePuntoDeVenta(@RequestParam @Valid Long id, 
        @RequestParam @Valid String nombre){
            return ResponseEntity.ok(puntoDeVentaService.updatePuntoDeVenta(id, nombre));
                
    }

    @DeleteMapping("borrar/{id}")
    private String deletePuntoDeVenta(@RequestParam @Valid Long id){
        return "Punto de venta eliminado";
    }

    
}
