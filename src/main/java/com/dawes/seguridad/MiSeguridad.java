package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.seguridadServiceImpl.ServicioUsuarioImpl;

//Eta clase sigue el pdf de Implementacion security en el campus

@Configuration
@EnableWebSecurity
public class MiSeguridad {
	//Por que bean un bean es un componente qu eeta en memoria que manjea 
	//spring y lo usara cuando lo necesite, una peticion
	
	@Autowired
	ServicioUsuarioImpl su;
	
	@Bean
	public BCryptPasswordEncoder encripta() {
		System.out.println("---------------Prueba encripta------------------");
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public SecurityFilterChain filtroCompleto(HttpSecurity http)throws Exception {
		System.out.println("---------------Prueba encripta 2------------------");

		http
		.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(su)
		.passwordEncoder(encripta());
		
		
		http
		.authorizeHttpRequests()
		.requestMatchers("/user/**", "/tratamientos/user/**", "/arboles/user/**", "/fincas/user/**", "/recolecciones/user/**")
		.hasAnyRole("ADMIN", "USER")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");
		
		
		http
		.authorizeHttpRequests()
		.requestMatchers("/admin/**", "/tratamientos/**", "/arboles/**", "/fincas/**", "/recolecciones/**")
		.hasAnyRole("ADMIN")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");
		
		
		http
		.authorizeHttpRequests()
		.requestMatchers("/","/login","/principal","/formuuser","/signup", "/main/**","/images/**","/css/main/**", "/css/general/**", "/scripts/**")
		.permitAll()
		.anyRequest()
		.authenticated();
		
		
		http
		.formLogin()
		.loginPage("/login")
		.permitAll();
		
		return http.build();
		
	}

}
