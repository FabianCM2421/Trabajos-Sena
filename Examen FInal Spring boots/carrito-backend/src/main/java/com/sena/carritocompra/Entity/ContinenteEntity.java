package com.sena.carritocompra.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "continente")
public class ContinenteEntity extends ABaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

public String getCodigo() {
	return codigo;
}
public Long getId() {
	return id;
}
public String getNombre() {
	return nombre;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setId(Long id) {
	this.id = id;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
}
