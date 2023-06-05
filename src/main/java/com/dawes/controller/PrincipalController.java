package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.seguridadModelo.UsuarioRolVO;
import com.dawes.seguridadModelo.UsuarioVO;
import com.dawes.seguridadService.ServicioRol;
import com.dawes.seguridadService.ServicioUsuario;
import com.dawes.seguridadService.ServicioUsuarioRol;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PrincipalController {
	
	@Autowired
	ServicioUsuario su;
	@Autowired
	ServicioUsuarioRol sur;
	@Autowired
	ServicioRol sr;
	
	
	@RequestMapping("/principal")
	public String Principal() {
		return "/main/principal";
	}
	
	@RequestMapping("/admin")
	public String Admin(){
		return "admin/admin";
	}
	
	@RequestMapping("/user")
	public String user() {
		return"user/regis";
	}

	//No hace falta al estar en una carpeta error /403.html va solo
	@RequestMapping("/403")
	public String error403() {
		return"error/403";
	}

	@RequestMapping("/login")
	public String loginr() {
		return"/main/login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/main/principal";
	}
	
	@RequestMapping("/register")
	public String register() {
		return"user/formuuser";
	}
	
	@RequestMapping("/formuuser")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("usuario", new UsuarioVO());
		return "user/formuuser";
	}
	
	
	@RequestMapping("/signup")
	public String insertar(Model modelo, @ModelAttribute UsuarioVO usuario) {
		System.out.print("prueba");
		System.out.print(usuario);
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		su.save(usuario);
		sur.save(new UsuarioRolVO(0, usuario, sr.findById(2).get()));
		return "main/login";
	}
	
	@RequestMapping("/salir")
	public String salir(HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "/main/principal";
	}
}

