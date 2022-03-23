package com.alucar.domain.service;

import com.alucar.domain.model.Carro;
import com.alucar.domain.model.Imagens;
import com.alucar.domain.repository.CarroRepository;
import com.alucar.domain.repository.ImagensRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ImagensService {

    private ImagensRepository imagensRepository;
    private CarroRepository carroRepository;

    @Transactional
    public Imagens salvar(Imagens imagens) {
        List<Carro> carro =  imagens.getCarros()
                .stream()
                .map(imagem -> carroRepository
                        .findById(imagem.getCarro_id()).orElseThrow())
                .collect(Collectors.toList());
        imagens.getCarros().clear();
        imagens.getCarros().addAll(carro);

        return imagensRepository.save(imagens);
    }

    @Transactional
    public void excluir (Integer imagensId) {
        imagensRepository.deleteById((imagensId));
    }

}
