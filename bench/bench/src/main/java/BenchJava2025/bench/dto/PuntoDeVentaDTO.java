package BenchJava2025.bench.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public record PuntoDeVentaDTO(
    @NotNull(message = "El nombre de usuario no puede ser nulo.")
    @Size(min=10, max = 50, message = "El nombre de usuario no debe ser menor a 10 caracteres ni ser mayor a 50 caracteres")
    String nombre) {

    
}
