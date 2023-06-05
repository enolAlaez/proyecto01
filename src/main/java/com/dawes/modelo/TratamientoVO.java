package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Tratamiento")
public class TratamientoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamiento;
	private String nombre;
	private LocalDate fecha;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "tratamiento", cascade = CascadeType.REMOVE)
	private List<ArbolTratamientoVO> arboles; 
	
	public TratamientoVO(String nombre, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	}
	

}