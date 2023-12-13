package com.sena.carritocompra.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.CiudadEntity;
import com.sena.carritocompra.IRepository.ICiudadRepository;
import com.sena.carritocompra.IService.ICiudadService;

@Service
public class CiudadService implements ICiudadService{

	@Autowired
	private ICiudadRepository repository;
	
	@Override
	public List<CiudadEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<CiudadEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public CiudadEntity save(CiudadEntity Ciudad) {
		Ciudad.setFechaCreacion(LocalDateTime.now());
		return repository.save(Ciudad);
	}

	@Override
	public void update(CiudadEntity Continente, Long id) {
		//Consultar si existe el registro
				Optional<CiudadEntity> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					CiudadEntity updateCiudad = op.get();					
					updateCiudad.setNombre(Continente.getNombre());
					updateCiudad.setCodigo(Continente.getCodigo());
					updateCiudad.setEstado(Continente.getEstado());
					updateCiudad.setDepartamentoId(Continente.getDepartamentoId());
					updateCiudad.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateCiudad);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<CiudadEntity> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			CiudadEntity updateCliente = op.get();					
			updateCliente.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateCliente);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}



}
