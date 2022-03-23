package com.alucar.api.controller;

import com.alucar.domain.model.Cidades;
import com.alucar.domain.repository.CidadesRepository;
import com.alucar.domain.service.CidadesService;
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
@RequestMapping("/cidades")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class CidadesController {

    @Autowired
    private CidadesRepository cidadesRepository;
    @Autowired
    private CidadesService cidadesService;

    @GetMapping
    public List<Cidades> listar() {
        return cidadesRepository.findAll();
    }

    @GetMapping("/{cidadesId}")
    public ResponseEntity<Cidades> buscar(@PathVariable Integer cidadesId) {
        Optional<Cidades> cidades = cidadesRepository.findById(cidadesId);
        if(cidades.isPresent()){
            return ResponseEntity.ok(cidades.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidades adicionar (@Valid @RequestBody Cidades cidades) {
        return cidadesService.salvar(cidades);
    }

    @PutMapping("/{cidadesId}")
    public ResponseEntity<Cidades> atualizar (@PathVariable Integer cidadesId, @Valid @RequestBody Cidades cidades) {
        if (!cidadesRepository.existsById(cidadesId)) {
            return ResponseEntity.notFound().build();
        }

        cidades.setCidades_id(cidadesId);
        cidades = cidadesService.salvar(cidades);

        return ResponseEntity.ok(cidades);
    }

    @DeleteMapping("/{cidadesId}")
    public ResponseEntity<Void> excluir (@PathVariable Integer cidadesId) {
        if (!cidadesRepository.existsById(cidadesId)) {
            return ResponseEntity.notFound().build();
        }

        cidadesService.excluir(cidadesId);

        return ResponseEntity.noContent().build();
    }
}