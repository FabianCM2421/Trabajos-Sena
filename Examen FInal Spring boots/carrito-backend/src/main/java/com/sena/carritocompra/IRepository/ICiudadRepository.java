package com.sena.carritocompra.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.carritocompra.Entity.CiudadEntity;


public interface ICiudadRepository extends JpaRepository<CiudadEntity, Long>{
}