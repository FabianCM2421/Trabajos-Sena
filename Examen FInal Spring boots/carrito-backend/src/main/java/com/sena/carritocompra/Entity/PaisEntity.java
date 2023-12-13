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
@Table(name = "pais")
public class PaisEntity extends ABaseEntity{

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "continente_id", nullable = false)
	private ContinenteEntity ContinenteId;
	
public ContinenteEntity getContinenteId() {
	return ContinenteId;
}
public void setContinenteId(ContinenteEntity continenteId) {
	ContinenteId = continenteId;
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
