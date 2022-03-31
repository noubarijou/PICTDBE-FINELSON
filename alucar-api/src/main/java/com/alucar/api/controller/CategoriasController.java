package com.alucar.api.controller;

import com.alucar.domain.model.Categorias;
import com.alucar.domain.repository.CategoriasRepository;
import com.alucar.domain.service.CategoriasService;
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
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {

    @Autowired
    private CategoriasRepository categoriasRepository;
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> listar() {
        return categoriasRepository.findAll();
    }


    @GetMapping("/{categoriasId}")
    public ResponseEntity<Categorias> buscar(@PathVariable Integer categoriasId) {
        Optional<Categorias> categorias = categoriasRepository.findById(categoriasId);
            if(categorias.isPresent()) {
                return ResponseEntity.ok(categorias.get());
            }
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categorias adicionar (@Valid @RequestBody Categorias categorias) {
        return categoriasService.salvar(categorias);
    }

    @PutMapping("/{categoriasId}")
    public ResponseEntity<Categorias> atualizar (@PathVariable Integer categoriasId, @Valid @RequestBody Categorias categorias) {
        if (!categoriasRepository.existsById(categoriasId)) {
            return ResponseEntity.notFound().build();
        }

        categorias.setCategoriasId(categoriasId);
        categorias = categoriasService.salvar(categorias);

        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{categoriasId}")
    public ResponseEntity<Void> excluir (@PathVariable Integer categoriasId) {
        if (!categoriasRepository.existsById(categoriasId)) {
            return ResponseEntity.notFound().build();
        }

        categoriasService.excluir(categoriasId);

        return ResponseEntity.noContent().build();
    }
}
