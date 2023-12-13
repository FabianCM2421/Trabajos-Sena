package com.sena.carritocompra.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.carritocompra.Entity.PaisEntity;


public interface IPaisRepository extends JpaRepository<PaisEntity, Long>{
}