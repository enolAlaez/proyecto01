package com.dawes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encripta {

	public static void main(String[] args) {
		BCryptPasswordEncoder encripta=new BCryptPasswordEncoder();
		
		System.out.println(encripta.encode("1234T"));	}
	
	//para conseguir la contraseña encriptada, en este caso temporal, ejecutamos esta clase individualmente as java aplication.
	//luego se copiaran en password de users en la base de datos y se pondran en el .sql 
}
