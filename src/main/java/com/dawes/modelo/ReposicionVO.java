package com.dawes.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reposicion")
public class ReposicionVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecoleccion;
	private String causa;
	private LocalDate fecha;
	
	@ToString.Exclude
	@ManyToOne()
	@JoinColumn(name = "idarbol")
	private ArbolVO arbol;
	
	

}
