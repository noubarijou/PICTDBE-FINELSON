package com.alucar.domain.service;

import com.alucar.domain.model.Carro;
import com.alucar.domain.repository.CarroRepository;
import com.alucar.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CarroService {

    private CarroRepository carroRepository;


    @Transactional
    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public void excluir (Integer carroId) {
        carroRepository.deleteById((carroId));
    }

}


