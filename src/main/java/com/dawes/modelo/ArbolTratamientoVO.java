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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="arboltratamiento")
public class ArbolTratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarboltratamiento;
	private LocalDate Fecha;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="idarbol")
	private ArbolVO arbol;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="idtratamiento")
	private TratamientoVO tratamiento;
	
	
}
