package com.sena.carritocompra.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.DepartamentoEntity;
import com.sena.carritocompra.IRepository.IDepartamentoRepository;
import com.sena.carritocompra.IService.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService{

	@Autowired
	private IDepartamentoRepository repository;
	
	@Override
	public List<DepartamentoEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<DepartamentoEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public DepartamentoEntity save(DepartamentoEntity Departamento) {
		Departamento.setFechaCreacion(LocalDateTime.now());
		return repository.save(Departamento);
	}

	@Override
	public void update(DepartamentoEntity Departamento, Long id) {
		//Consultar si existe el registro
				Optional<DepartamentoEntity> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					DepartamentoEntity updatePais = op.get();					
					updatePais.setNombre(Departamento.getNombre());
					updatePais.setCodigo(Departamento.getCodigo());
					updatePais.setEstado(Departamento.getEstado());
					updatePais.setPaisId(Departamento.getPaisId());
					updatePais.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updatePais);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<DepartamentoEntity> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			DepartamentoEntity updateDepartamento = op.get();					
			updateDepartamento.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateDepartamento);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}



}
