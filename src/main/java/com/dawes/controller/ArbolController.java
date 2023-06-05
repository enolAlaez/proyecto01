package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolDTO;
import com.dawes.modelo.ArbolTratamientoDTO;
import com.dawes.modelo.ArbolTratamientoVO;
import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.ReposicionVO;
import com.dawes.modelo.VariedadVO;
import com.dawes.service.ArbolService;
import com.dawes.service.ArbolTratamientoService;
import com.dawes.service.FincaService;
import com.dawes.service.ReposicionService;
import com.dawes.service.TratamientoService;
import com.dawes.service.VariedadService;

@Controller
@RequestMapping("/arboles")
public class ArbolController {
	
	@Autowired
	ArbolService as;
	@Autowired
	FincaService fs;
	@Autowired
	VariedadService vs;
	@Autowired
	ArbolTratamientoService ats;
	@Autowired
	TratamientoService ts;
	@Autowired
	ReposicionService reps;
	
	@RequestMapping("/mostrar")
	public String mostrar(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("arbol", as.findAllByFincaId(idfinca));
		if(modelo.toString().length() < 11) {
			System.out.println(fs.findById(idfinca).get());
			modelo.addAttribute("erfinca", fs.findById(idfinca).get());
			return "arbol/noArbolesError";
		}
		return "arbol/mostrarArbol";
	}
	

	@RequestMapping("/formulario")
	public String forminsertar(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("arbol", new ArbolDTO());
		modelo.addAttribute("finca", fs.findById(idfinca).get());
		modelo.addAttribute("variedades", vs.findAll());
		return "arbol/formularioArbol";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("idfinca") int idfinca, @ModelAttribute ArbolDTO arbol, Model modelo) {
		System.out.println("prueba de arbol------------------------");
		System.out.println(arbol);
		ArbolVO arbolinsert = new ArbolVO();
		
		arbolinsert.setColumna(arbol.getColumna());
		arbolinsert.setFila(arbol.getFila());
		arbolinsert.setEstado(arbol.getEstado());
		arbolinsert.setFecha(LocalDate.now());
		arbolinsert.setFinca(fs.findById(idfinca).get());
		arbolinsert.setVariedad(vs.findById(arbol.getIdvariedad()).get());
	
		as.save(arbolinsert);
		modelo.addAttribute("arbol", as.findAllByFincaId(idfinca));
		return "arbol/mostrarArbol";
	}
	
	@RequestMapping("/formulariomodif")
	public String formmodificar(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		modelo.addAttribute("variedades", vs.findAll());
		modelo.addAttribute("fincas", fs.findAll());
		return "arbol/formModificarArbol";
	}
	
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute ArbolVO arbol, Model modelo) {
		System.out.println(arbol);
		System.out.println(arbol.getFinca());
		as.save(arbol);
		modelo.addAttribute("arbol", as.findAllByFincaId(arbol.getFinca().getIdfinca()));
		return "arbol/mostrarArbol";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idarbol") int idarbol, Model modelo) {
		int idfinca = as.findById(idarbol).get().getFinca().getIdfinca();
		as.deleteById(idarbol);
		modelo.addAttribute("arbol", as.findAllByFincaId(idfinca));
		if(modelo.toString().length() < 11) {
			System.out.println(fs.findById(idfinca).get());
			modelo.addAttribute("erfinca", fs.findById(idfinca).get());
			return "arbol/noArbolesError";
		}
		return "arbol/mostrarArbol";
	}
	
	@RequestMapping("/formularioArbolTrata")
	public String forminsertarTrata(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arboltratamiento", new ArbolTratamientoDTO());
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		modelo.addAttribute("tratas", ts.findAll());
		return "arbol/formularioArbolTrata";
	}
	
	@RequestMapping("/mostrarTratamiento")
	public String trata(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/mostrarArbolTrata";
	}
	
	
	@RequestMapping("/insertarTratamiento")
	public String insertar(@RequestParam("idarbol") int idarbol, @ModelAttribute ArbolTratamientoDTO arbtrat, Model modelo) {
		ArbolTratamientoVO atinsert = new ArbolTratamientoVO();
		atinsert.setFecha(LocalDate.now());
		atinsert.setTratamiento(ts.findById(arbtrat.getIdtratamiento()).get());
		atinsert.setArbol(as.findById(idarbol).get());
		ats.save(atinsert);
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/mostrarArbolTrata";
	}
	
	@RequestMapping("/formularioArbolRepos")
	public String forminsertarrepo(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("idarbol", idarbol);
		modelo.addAttribute("repo", new ReposicionVO());
		return "/arbol/formArbolRepo";
	}
	
	@RequestMapping("/insertarRepos")
	public String insertarrepos(@RequestParam("idarbol") int idarbol, @ModelAttribute ReposicionVO repo, Model modelo) {
		System.out.println("-------------------"+idarbol);
		repo.setArbol(as.findById(idarbol).get());
		repo.setFecha(LocalDate.now());
		reps.save(repo);
		System.out.println("-----.-.-.-.-"+as.findById(idarbol).get().getReposiciones());
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/mostrarArbolTrata";
	}
	
	
	//Metodos para gestionar usuario registrado-----------------------
	
	@RequestMapping("/user/mostrarus")
	public String mostrarus(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("arbol", as.findAllByFincaId(idfinca));
		if(modelo.toString().length() < 11) {
			System.out.println(fs.findById(idfinca).get());
			modelo.addAttribute("erfinca", fs.findById(idfinca).get());
			return "arbol/noArbolesError";
		}
		return "arbol/user/mostrarArbolus";
	}
	
	@RequestMapping("/user/formularious")
	public String forminsertarus(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("arbol", new ArbolDTO());
		modelo.addAttribute("finca", fs.findById(idfinca).get());
		modelo.addAttribute("variedades", vs.findAll());
		return "arbol/user/formularioArbolus";
	}
	
	@RequestMapping("/user/insertarus")
	public String insertarus(@RequestParam("idfinca") int idfinca, @ModelAttribute ArbolDTO arbol, Model modelo) {
		System.out.println("prueba de arbol------------------------");
		System.out.println(arbol);
		ArbolVO arbolinsert = new ArbolVO();
		
		arbolinsert.setColumna(arbol.getColumna());
		arbolinsert.setFila(arbol.getFila());
		arbolinsert.setEstado(arbol.getEstado());
		arbolinsert.setFecha(LocalDate.now());
		arbolinsert.setFinca(fs.findById(idfinca).get());
		arbolinsert.setVariedad(vs.findById(arbol.getIdvariedad()).get());
	
		as.save(arbolinsert);
		modelo.addAttribute("arbol", as.findAllByFincaId(idfinca));
		return "arbol/user/mostrarArbolus";
	}
	
	@RequestMapping("/user/formulariomodifus")
	public String formmodificarus(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		modelo.addAttribute("variedades", vs.findAll());
		modelo.addAttribute("fincas", fs.findAll());
		return "arbol/user/formModificarArbolus";
	}
	
	@RequestMapping("/user/modificarus")
	public String modificarus(@ModelAttribute ArbolVO arbol, Model modelo) {
		System.out.println(arbol);
		System.out.println(arbol.getFinca());
		as.save(arbol);
		modelo.addAttribute("arbol", as.findAllByFincaId(arbol.getFinca().getIdfinca()));
		return "arbol/user/mostrarArbolus";
	}
	
	@RequestMapping("/user/formularioArbolTrataus")
	public String forminsertarTrataus(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arboltratamiento", new ArbolTratamientoDTO());
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		modelo.addAttribute("tratas", ts.findAll());
		return "arbol/user/formularioArbolTrataus";
	}
	
	@RequestMapping("/user/mostrarTratamientous")
	public String trataus(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/user/mostrarArbolTrataus";
	}
	
	@RequestMapping("/user/insertarTratamientous")
	public String insertarus(@RequestParam("idarbol") int idarbol, @ModelAttribute ArbolTratamientoDTO arbtrat, Model modelo) {
		ArbolTratamientoVO atinsert = new ArbolTratamientoVO();
		atinsert.setFecha(LocalDate.now());
		atinsert.setTratamiento(ts.findById(arbtrat.getIdtratamiento()).get());
		atinsert.setArbol(as.findById(idarbol).get());
		ats.save(atinsert);
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/user/mostrarArbolTrataus";
	}
	
	@RequestMapping("/user/formularioArbolReposus")
	public String forminsertarrepous(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("idarbol", idarbol);
		modelo.addAttribute("repo", new ReposicionVO());
		return "/arbol/user/formArbolRepous";
	}
	
	@RequestMapping("/user/insertarReposus")
	public String insertarreposus(@RequestParam("idarbol") int idarbol, @ModelAttribute ReposicionVO repo, Model modelo) {
		System.out.println("-------------------"+idarbol);
		repo.setArbol(as.findById(idarbol).get());
		repo.setFecha(LocalDate.now());
		reps.save(repo);
		System.out.println("-----.-.-.-.-"+as.findById(idarbol).get().getReposiciones());
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return "arbol/user/mostrarArbolTrataus";
	}
	

}