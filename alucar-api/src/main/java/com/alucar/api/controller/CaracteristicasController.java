package com.alucar.api.controller;

import com.alucar.domain.model.Caracteristicas;
import com.alucar.domain.repository.CaracteristicasRepository;
import com.alucar.domain.service.CaracteristicasService;
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
@RequestMapping("/caracteristicas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CaracteristicasController {

    @Autowired
    private CaracteristicasRepository caracteristicasRepository;
    @Autowired
    private CaracteristicasService caracteristicasService;

    @GetMapping
    public List<Caracteristicas> listar() { return caracteristicasRepository.findAll(); }

    @GetMapping("/{caracteristicasId}")
    public ResponseEntity<Caracteristicas> buscar (@PathVariable Integer caracteristicasId) {
        Optional<Caracteristicas> caracteristicas = caracteristicasRepository.findById(caracteristicasId);
            if(caracteristicas.isPresent()) {
                return ResponseEntity.ok(caracteristicas.get());
            }
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caracteristicas adicionar(@Valid @RequestBody Caracteristicas caracteristicas) {
        return caracteristicasService.salvar(caracteristicas);
    }

    @PutMapping("/{caracteristicasId}")
    public ResponseEntity<Caracteristicas> atualizar (@PathVariable Integer caracteristicasId, @Valid @RequestBody Caracteristicas caracteristicas) {
        if(!caracteristicasRepository.existsById(caracteristicasId)) {
            return ResponseEntity.notFound().build();
        }

        caracteristicas.setCaracteristicasId((caracteristicasId));
        caracteristicas = caracteristicasService.salvar(caracteristicas);

        return ResponseEntity.ok(caracteristicas);
    }

    @DeleteMapping("/{caracteristicasId}")
    public ResponseEntity<Void> excluir (@PathVariable Integer caracteristicasId) {
        if(!caracteristicasRepository.existsById(caracteristicasId)) {
            return ResponseEntity.notFound().build();
        }

        caracteristicasService.excluir(caracteristicasId);

        return ResponseEntity.noContent().build();
    }




}
