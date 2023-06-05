package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.VariedadVO;
import com.dawes.service.VariedadService;

@Controller
@RequestMapping("/variedades")
public class VariedadController {
	
	@Autowired
	VariedadService vs;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("variedad", vs.findAll());
		return "variedad/mostrarVariedad";
	}
	
	@RequestMapping("/user/mostrarus")
	public String mostrarus(Model modelo) {
		modelo.addAttribute("variedad", vs.findAll());
		return "variedad/user/mostrarVariedadus";
	}
	
	@RequestMapping("/formulario")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedad", new VariedadVO());
		return "variedad/formularioVariedad";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute VariedadVO variedad, Model modelo) {
		vs.save(variedad);
		modelo.addAttribute("variedad", vs.findAll());
		return "variedad/mostrarVariedad";
	}
	
	@RequestMapping("/formulariomodif")
	public String formmodificar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		modelo.addAttribute("variedad", vs.findById(idvariedad).get());
		return "variedad/formModificarVar";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute VariedadVO var, Model modelo) {
		vs.save(var);
		return mostrar(modelo);
	}
	

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		vs.deleteById(idvariedad);
		modelo.addAttribute("variedad", vs.findAll());
		return "variedad/mostrarVariedad";
	}

}