package BenchJava2025.bench.mapper;

import BenchJava2025.bench.dto.PuntoDeVentaDTO;
import BenchJava2025.bench.models.PuntoDeVenta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-05T23:59:36-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class PuntoDeVentaMapperImpl implements PuntoDeVentaMapper {

    @Override
    public PuntoDeVenta toEntity(PuntoDeVentaDTO puntoDeVentaDTO) {
        if ( puntoDeVentaDTO == null ) {
            return null;
        }

        PuntoDeVenta.PuntoDeVentaBuilder puntoDeVenta = PuntoDeVenta.builder();

        puntoDeVenta.nombre( puntoDeVentaDTO.nombre() );

        return puntoDeVenta.build();
    }

    @Override
    public PuntoDeVentaDTO toDto(PuntoDeVenta puntoDeVenta) {
        if ( puntoDeVenta == null ) {
            return null;
        }

        String nombre = null;

        nombre = puntoDeVenta.getNombre();

        PuntoDeVentaDTO puntoDeVentaDTO = new PuntoDeVentaDTO( nombre );

        return puntoDeVentaDTO;
    }
}
