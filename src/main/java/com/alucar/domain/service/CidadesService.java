package com.alucar.domain.service;

import com.alucar.domain.model.Cidades;
import com.alucar.domain.repository.CidadesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CidadesService {

    private CidadesRepository cidadesRepository;

    @Transactional
    public Cidades salvar (Cidades cidades) {
        return cidadesRepository.save(cidades);
    }

    @Transactional
    public void excluir (Integer cidadesId) {
        cidadesRepository.deleteById(cidadesId);
    }
}
