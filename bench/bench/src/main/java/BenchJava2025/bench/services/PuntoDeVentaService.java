package BenchJava2025.bench.services;

import java.util.List;

import BenchJava2025.bench.dto.PuntoDeVentaDTO;


public interface PuntoDeVentaService {
    List<PuntoDeVentaDTO> getAllPuntoDeVentas();
    PuntoDeVentaDTO addPuntoDeVenta(PuntoDeVentaDTO puntoDeVentaDTO);
    PuntoDeVentaDTO updatePuntoDeVenta(Long id, String nombre);
    String deletePuntoDeVenta(Long id);
}
