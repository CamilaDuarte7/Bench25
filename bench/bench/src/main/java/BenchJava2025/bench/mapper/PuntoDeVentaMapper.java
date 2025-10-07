package BenchJava2025.bench.mapper;

import org.mapstruct.Mapper;

import BenchJava2025.bench.dto.PuntoDeVentaDTO;
import BenchJava2025.bench.models.PuntoDeVenta;

@Mapper(componentModel = "spring")
public interface PuntoDeVentaMapper {
    PuntoDeVenta toEntity(PuntoDeVentaDTO puntoDeVentaDTO);
    PuntoDeVentaDTO toDto(PuntoDeVenta  puntoDeVenta);
}
