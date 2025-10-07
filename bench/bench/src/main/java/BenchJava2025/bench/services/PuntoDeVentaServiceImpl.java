package BenchJava2025.bench.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import BenchJava2025.bench.dto.PuntoDeVentaDTO;
import BenchJava2025.bench.exceptions.PuntoNoEncontradoException;
import BenchJava2025.bench.mapper.PuntoDeVentaMapper;
import BenchJava2025.bench.models.PuntoDeVenta;
import BenchJava2025.bench.repositories.PuntoDeVentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "puntosDeVenta")
public class PuntoDeVentaServiceImpl implements PuntoDeVentaService{
    
    private final PuntoDeVentaRepository puntoDeVentaRepository;
    private final PuntoDeVentaMapper puntoDeVentaMapper;

    @Override
    @Cacheable(key = "'all'")
    public List<PuntoDeVentaDTO> getAllPuntoDeVentas(){
        List<PuntoDeVenta> puntosDeVenta = puntoDeVentaRepository.findAll();
        return puntosDeVenta.stream()
                .map(puntoDeVentaMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    @Caching(evict = {
        @CacheEvict(value= "puntosDeVenta", key = "'all'"),
        @CacheEvict(value= "puntosDeVenta", key = "#result.nombre", condition = "#result != null")
    })
    public PuntoDeVentaDTO addPuntoDeVenta(PuntoDeVentaDTO puntoDeVentaDTO){
        PuntoDeVenta puntoDeVenta = puntoDeVentaMapper.toEntity(puntoDeVentaDTO);
        PuntoDeVenta save = puntoDeVentaRepository.save(puntoDeVenta);
        return puntoDeVentaMapper.toDto(save);
    }

    @Override
    @Caching(evict = {
        @CacheEvict(key = "'all'"),
        @CacheEvict(key = "#id")
    })
    public PuntoDeVentaDTO updatePuntoDeVenta(Long id, String nombre){
        PuntoDeVenta puntoExistente = puntoDeVentaRepository.findById(id)
                .orElseThrow(()-> new PuntoNoEncontradoException("Punto De Venta no existente"));

        puntoExistente.setNombre(nombre);

        PuntoDeVenta puntoActualizado = puntoDeVentaRepository.save(puntoExistente);
        return puntoDeVentaMapper.toDto(puntoActualizado);
    }

    @Override
    @Caching(evict = {
        @CacheEvict(key = "'all'"),
        @CacheEvict(key = "#id")
    })
    public String deletePuntoDeVenta(Long id){
        PuntoDeVenta puntoExistente = puntoDeVentaRepository.findById(id)
                .orElseThrow(()-> new PuntoNoEncontradoException("Punto De Venta no existente"));
        puntoDeVentaRepository.deleteById(id);
        return "Punto eliminado";
    }

}
