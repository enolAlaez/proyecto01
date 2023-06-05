package com.dawes.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecoleccionDTO {
	private int idrecoleccion;
	private int kilos;
	private int idfinca;
	private int idvariedad;	
}
