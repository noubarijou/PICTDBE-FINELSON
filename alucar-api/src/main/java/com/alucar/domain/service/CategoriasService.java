package com.alucar.domain.service;


import com.alucar.domain.model.Carro;
import com.alucar.domain.model.Categorias;
import com.alucar.domain.repository.CarroRepository;
import com.alucar.domain.repository.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoriasService {

    private CategoriasRepository categoriasRepository;
    private CarroRepository carroRepository;

    @Transactional
    public Categorias salvar(Categorias categorias) {
        List<Carro> carro =  categorias.getCarros()
                .stream()
                .map(carro1 -> carroRepository
                        .findById(carro1.getCarro_id()).orElseThrow())
                .collect(Collectors.toList());
        categorias.getCarros().clear();
        categorias.getCarros().addAll(carro);

        return categoriasRepository.save(categorias);
    }

    @Transactional
    public void excluir(Integer categoriasId) {
        categoriasRepository.deleteById(categoriasId);
    }

}
