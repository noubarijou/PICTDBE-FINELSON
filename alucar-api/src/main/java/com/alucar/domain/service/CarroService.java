package com.alucar.domain.service;

import com.alucar.domain.model.Carro;
import com.alucar.domain.model.Categorias;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.CarroRepository;
import com.alucar.domain.repository.CategoriasRepository;
import com.alucar.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarroService {

    private CarroRepository carroRepository;
    private ClienteRepository clienteRepository;
    @Autowired
    private final PasswordEncoder encoder;

    @Transactional
    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public void excluir (Integer carroId) {
        carroRepository.deleteById((carroId));
    }

}


