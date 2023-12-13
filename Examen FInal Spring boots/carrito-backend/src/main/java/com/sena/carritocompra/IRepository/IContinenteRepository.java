package com.sena.carritocompra.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.carritocompra.Entity.ContinenteEntity;

public interface IContinenteRepository extends JpaRepository<ContinenteEntity, Long>{
}
