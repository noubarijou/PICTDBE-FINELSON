package com.alucar.api.controller;

import com.alucar.domain.model.Carro;
import com.alucar.domain.repository.CarroRepository;
import com.alucar.domain.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listar() {
        return carroRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Carro> buscar(@PathVariable Integer carroId) {
        Optional<Carro> carro = carroRepository.findById(carroId);
            if(carro.isPresent()){
                return ResponseEntity.ok(carro.get());
            }
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro adicionar (@Valid @RequestBody Carro carro) {
        return carroService.salvar(carro);
    }

    @PutMapping("/{carroId}")
    public ResponseEntity<Carro> atualizar (@PathVariable Integer carroId, @Valid @RequestBody Carro carro) {
        if(!carroRepository.existsById(carroId)){
            return ResponseEntity.notFound().build();
        }

        carro.setCarroId(carroId);
        carro = carroService.salvar(carro);

        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{carroId}")
    public ResponseEntity<Void> excluir (@PathVariable Integer carroId) {
        if (!carroRepository.existsById(carroId)) {
            return ResponseEntity.notFound().build();
        }

        carroService.excluir(carroId);

        return ResponseEntity.noContent().build();
    }


}
