package com.alucar.domain.service;

import com.alucar.domain.model.Caracteristicas;
import com.alucar.domain.model.Carro;
import com.alucar.domain.repository.CaracteristicasRepository;
import com.alucar.domain.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CaracteristicasService {

    private CaracteristicasRepository caracteristicasRepository;
    private CarroRepository carroRepository;

    @Transactional
    public Caracteristicas salvar(Caracteristicas caracteristicas) {
        List<Carro> carro =  caracteristicas.getCarros()
                .stream()
                .map(carro1 -> carroRepository
                        .findById(carro1.getCarro_id()).orElseThrow())
                .collect(Collectors.toList());
        caracteristicas.getCarros().clear();
        caracteristicas.getCarros().addAll(carro);

        return caracteristicasRepository.save(caracteristicas);
    }

    @Transactional
    public void excluir (Integer caracteristicasId) {
        caracteristicasRepository.deleteById(caracteristicasId);
    }
}
