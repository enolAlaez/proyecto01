package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RecoleccionVO;
import com.dawes.modelo.TratamientoVO;
import com.dawes.service.TratamientoService;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {
	
	@Autowired
	TratamientoService ts;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("tratam", ts.findAll());
		return "tratamiento/mostrarTrata";
	}
	
	@RequestMapping("/user/mostrarus")
	public String mostrarus(Model modelo) {
		modelo.addAttribute("tratam", ts.findAll());
		return "tratamiento/user/mostrarTrataus";
	}
	
	@RequestMapping("/formulario")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("trata", new TratamientoVO());
		return "tratamiento/formularioTrata";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute TratamientoVO trata, Model modelo) {
		trata.setFecha(LocalDate.now());
		ts.save(trata);
		modelo.addAttribute("tratam", ts.findAll());
		return "tratamiento/mostrarTrata";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idtrata") int idtrata, Model modelo) {
		ts.deleteById(idtrata);
		modelo.addAttribute("tratam", ts.findAll());
		return "tratamiento/mostrarTrata";
	}
	
	@RequestMapping("/formulariomodif")
	public String formmodificar(@RequestParam("idtrata") int idtrata, Model modelo) {
		modelo.addAttribute("tratam", ts.findById(idtrata).get());
		return "tratamiento/formModificarTrata";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute TratamientoVO trata, Model modelo) {
		System.out.println(trata);
		ts.save(trata);
		modelo.addAttribute("tratam", ts.findAll());
		return "tratamiento/mostrarTrata";
	}

}
