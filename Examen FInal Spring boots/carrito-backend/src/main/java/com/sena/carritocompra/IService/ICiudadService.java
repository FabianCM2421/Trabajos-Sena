package com.sena.carritocompra.IService;

import java.util.List;
import java.util.Optional;

import com.sena.carritocompra.Entity.CiudadEntity;
public interface ICiudadService {

	
	
	
	/**
	 * Método para consultar todo
	 * **/
	public List<CiudadEntity> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<CiudadEntity> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public CiudadEntity save(CiudadEntity Continente);
	
	/**
	 * Método para modificar
	 * **/
	public void update(CiudadEntity Continente, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
	
}