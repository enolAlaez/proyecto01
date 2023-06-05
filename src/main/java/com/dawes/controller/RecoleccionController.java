package com.dawes.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RecoleccionDTO;
import com.dawes.modelo.RecoleccionVO;
import com.dawes.service.FincaService;
import com.dawes.service.RecoleccionService;
import com.dawes.service.VariedadService;

@Controller
@RequestMapping("/recolecciones")
public class RecoleccionController {
	
	@Autowired
	RecoleccionService rs;
	@Autowired
	FincaService fs;
	@Autowired
	VariedadService vs;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("reco", rs.findAll());
		System.out.println(rs.findAll());
		return "recoleccion/mostrarRec";
	}
	
	@RequestMapping("/formulario")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("reco", new RecoleccionDTO());
		modelo.addAttribute("fincas", fs.findAll());
		modelo.addAttribute("variedades", vs.findAll());
		return "recoleccion/formularioRec";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute RecoleccionDTO reco, Model modelo) {
		System.out.println("prueba de reco------------------------");
		System.out.println(reco);
		RecoleccionVO recolinsert = new RecoleccionVO();
		
		recolinsert.setFinca(fs.findById(reco.getIdfinca()).get());
		recolinsert.setVariedad(vs.findById(reco.getIdvariedad()).get()); 
		recolinsert.setKilos(reco.getKilos());
		recolinsert.setFecha(LocalDate.now());
		rs.save(recolinsert);
		modelo.addAttribute("reco", rs.findAll());
		return "recoleccion/mostrarRec";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idreco") int idreco, Model modelo) {
		rs.deleteById(idreco);
		modelo.addAttribute("reco", rs.findAll());
		return "recoleccion/mostrarRec";
	}
	
	@RequestMapping("/formulariomodif")
	public String formmodificar(@RequestParam("idreco") int idreco, Model modelo) {
		modelo.addAttribute("reco", rs.findById(idreco).get());
		modelo.addAttribute("variedades", vs.findAll());
		modelo.addAttribute("fincas", fs.findAll());
		return "recoleccion/formModificarReco";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute RecoleccionVO reco, Model modelo) {
		System.out.println(reco);
		rs.save(reco);
		modelo.addAttribute("reco", rs.findAll());
		return "recoleccion/mostrarRec";
	}
	
	//Metodos para gestionar usuario registrado-----------------------
	
	@RequestMapping("/user/mostrarus")
	public String mostrarus(Model modelo) {
		modelo.addAttribute("reco", rs.findAll());
		System.out.println(rs.findAll());
		return "recoleccion/user/mostrarRecus";
	}
	
	@RequestMapping("/user/formularious")
	public String forminsertarus(Model modelo) {
		modelo.addAttribute("reco", new RecoleccionDTO());
		modelo.addAttribute("fincas", fs.findAll());
		modelo.addAttribute("variedades", vs.findAll());
		return "recoleccion/user/formularioRecus";
	}
	
	@RequestMapping("/user/insertarus")
	public String insertarus(@ModelAttribute RecoleccionDTO reco, Model modelo) {
		System.out.println("prueba de reco------------------------");
		System.out.println(reco);
		RecoleccionVO recolinsert = new RecoleccionVO();
		
		recolinsert.setFinca(fs.findById(reco.getIdfinca()).get());
		recolinsert.setVariedad(vs.findById(reco.getIdvariedad()).get()); 
		recolinsert.setKilos(reco.getKilos());
		recolinsert.setFecha(LocalDate.now());
		rs.save(recolinsert);
		modelo.addAttribute("reco", rs.findAll());
		return "recoleccion/user/mostrarRecus";
	}
}
