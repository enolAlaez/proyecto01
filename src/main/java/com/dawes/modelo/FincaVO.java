package com.dawes.modelo;

import java.time.LocalDate;
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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="finca")
public class FincaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	private String denom;
	private String direccion;
	private String ref;
	private int superf;
	private LocalDate fecha;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "finca", cascade = CascadeType.REMOVE)
	private List<ArbolVO> arbol;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "finca", cascade = CascadeType.REMOVE)
	private List<RecoleccionVO> recolecciones;

	public FincaVO(String denom, String direccion, String ref, int superf, LocalDate fecha) {
		super();
		this.denom = denom;
		this.direccion = direccion;
		this.ref = ref;
		this.superf = superf;
		this.fecha = fecha;
	}


	
	
	
	
}