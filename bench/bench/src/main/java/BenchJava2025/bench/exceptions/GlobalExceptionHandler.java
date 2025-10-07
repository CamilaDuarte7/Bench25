package BenchJava2025.bench.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import BenchJava2025.bench.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PuntoNoEncontradoException.class)
    public ResponseEntity<ErrorDTO> handlePuntoNoEncontradoException(PuntoNoEncontradoException ex){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), "PuntoNoEncontradoException", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        
    }

    
}
