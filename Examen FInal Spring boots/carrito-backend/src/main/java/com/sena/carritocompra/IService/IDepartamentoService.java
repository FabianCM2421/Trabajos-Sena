package com.sena.carritocompra.IService;

import java.util.List;
import java.util.Optional;

import com.sena.carritocompra.Entity.DepartamentoEntity;
public interface IDepartamentoService {

	
	
	
	/**
	 * Método para consultar todo
	 * **/
	public List<DepartamentoEntity> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<DepartamentoEntity> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public DepartamentoEntity save(DepartamentoEntity Departamento);
	
	/**
	 * Método para modificar
	 * **/
	public void update(DepartamentoEntity Departamento, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
	
}