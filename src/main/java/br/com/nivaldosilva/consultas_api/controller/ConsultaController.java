package br.com.nivaldosilva.consultas_api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.nivaldosilva.consultas_api.dto.ConsultaDTO;
import br.com.nivaldosilva.consultas_api.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

private final ConsultaService service;


@PostMapping
public ResponseEntity<ConsultaDTO> create(@RequestBody @Valid ConsultaDTO request){
         
        Optional<ConsultaDTO> response = service.create(request);

        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response.get(),HttpStatus.BAD_REQUEST);
    }


@GetMapping
public ResponseEntity<List<ConsultaDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

@GetMapping("/{id}")
public ResponseEntity<ConsultaDTO> getById(@PathVariable("id") Long id){
  Optional<ConsultaDTO> response = service.getById(id);
  
   if (response.isPresent()) {
    return ResponseEntity.ok(response.get());   
   }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     
    }


@PutMapping("/{id}")
public ResponseEntity<ConsultaDTO> update(@PathVariable("id") Long id, @RequestBody @Valid ConsultaDTO request){
     
    Optional<ConsultaDTO> response = service.update(id, request);

      if (response.isPresent()) {
        return ResponseEntity.ok(response.get());
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


@DeleteMapping("/{id}")
public ResponseEntity<ConsultaDTO> inactive(@PathVariable("id") Long id){
    boolean inactive = service.inactive(id);
    return inactive 
       ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
