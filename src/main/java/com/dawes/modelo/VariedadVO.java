package com.dawes.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="variedad")
public class VariedadVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvariedad;
	private String nombre;
	private String color;
	
	@OneToMany
	(mappedBy = "variedad", cascade = CascadeType.REMOVE)
	private List<ArbolVO> arbol;
	
	@OneToMany
	(mappedBy = "variedad", cascade = CascadeType.REMOVE)
	private List<RecoleccionVO> recolecciones;

	public VariedadVO(String nombre, String color, List<ArbolVO> arbol) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.arbol = arbol;
	}
	
	

	
}