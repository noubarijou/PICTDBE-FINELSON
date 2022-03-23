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
public class CarroService {

    private CarroRepository carroRepository;
    private CategoriasRepository categoriasRepository;

    @Transactional
    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }



    public void excluir (Integer carroId) {
        carroRepository.deleteById((carroId));
    }
}
