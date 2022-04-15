package com.alucar.domain.repository;

import com.alucar.domain.model.Caracteristicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasRepository  extends JpaRepository<Caracteristicas, Integer> {
}
