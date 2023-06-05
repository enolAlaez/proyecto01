package com.dawes.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArbolDTO {
	private int idarbol;
	private int fila;
	private int columna;
	private String estado;
	private int idfinca;
	private int idvariedad;	

}