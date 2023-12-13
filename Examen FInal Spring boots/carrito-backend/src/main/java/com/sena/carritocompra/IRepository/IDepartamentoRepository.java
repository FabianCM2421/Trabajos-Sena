package com.sena.carritocompra.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.carritocompra.Entity.DepartamentoEntity;


public interface IDepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>{
}
