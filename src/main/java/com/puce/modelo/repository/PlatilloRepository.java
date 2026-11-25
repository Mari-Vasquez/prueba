package com.puce.modelo.repository;

import com.puce.modelo.model.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatilloRepository extends JpaRepository<Platillo, Integer> {
}
