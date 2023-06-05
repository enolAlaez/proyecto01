package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="arbol")
public class ArbolVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarbol;
	private int fila;
	private int columna;
	private String estado;
	private LocalDate fecha;
	
	@ToString.Exclude
	@ManyToOne()
	private FincaVO finca;
	
	@ToString.Exclude
	@ManyToOne()
	@JoinColumn(name = "idvariedad")
	private VariedadVO variedad;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "arbol", cascade = CascadeType.REMOVE)
	private List<ArbolTratamientoVO>  tratamientos;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "arbol", cascade = CascadeType.REMOVE)
	private List<ReposicionVO>  reposiciones;

}