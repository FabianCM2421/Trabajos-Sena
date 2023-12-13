package com.sena.carritocompra.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class CiudadEntity extends ABaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "departamento_id", nullable = false)
	private DepartamentoEntity DepartamentoId;
	
public DepartamentoEntity getDepartamentoId() {
	return DepartamentoId;
}
public void setDepartamentoId(DepartamentoEntity departamentoId) {
	DepartamentoId = departamentoId;
}
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
