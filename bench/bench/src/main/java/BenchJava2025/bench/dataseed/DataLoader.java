package BenchJava2025.bench.dataseed;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import BenchJava2025.bench.models.PuntoDeVenta;
import BenchJava2025.bench.repositories.PuntoDeVentaRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{

    private final PuntoDeVentaRepository puntoDeVentaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadPuntosDeVenta();
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    
    private void loadPuntosDeVenta(){
        List<PuntoDeVenta> puntosLista = List.of(
            PuntoDeVenta.builder().nombre("CABA").build(),
            PuntoDeVenta.builder().nombre("GBA_1").build(),
            PuntoDeVenta.builder().nombre("GBA_2").build());
        puntoDeVentaRepository.saveAll(puntosLista);
        
    }

    
    
}
