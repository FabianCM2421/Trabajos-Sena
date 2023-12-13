package com.sena.carritocompra.Controller;

import com.sena.carritocompra.Entity.CiudadEntity;
import com.sena.carritocompra.IService.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/Ciudad")

public class CiudadController {

	@Autowired  private ICiudadService service;
	@GetMapping
	public List<CiudadEntity> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<CiudadEntity> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public CiudadEntity save(@RequestBody CiudadEntity detalleFactura) {
		return service.save(detalleFactura);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody CiudadEntity detalleFactura, @PathVariable  Long id) {
		service.update(detalleFactura, id);
	}
	
	@PutMapping("deleted-at/{id}")
	public void deletedAt(@PathVariable  Long id) {
		service.deletedAt(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		service.delete(id);
	}
}