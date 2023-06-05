package com.dawes.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVO;
import com.dawes.service.FincaService;

@Controller
@RequestMapping("/fincas")
public class FincaController {
	
	@Autowired
	FincaService fs;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("finca", fs.findAll());
		return "finca/mostrarFinca";
	}
	
	@RequestMapping("/user/mostrarus")
	public String mostrarus(Model modelo) {
		modelo.addAttribute("finca", fs.findAll());
		return "finca/user/mostrarFincaus";
	}
	
	@RequestMapping("/formulario")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("finca", new FincaVO());
		return "finca/formularioFinca";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute FincaVO finca, Model modelo) {
		finca.setFecha(LocalDate.now());
		fs.save(finca);
		modelo.addAttribute("finca", fs.findAll());
		return "finca/mostrarFinca";
	}
	
	@RequestMapping("/formulariomodif")
	public String formmodificar(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("finca", fs.findById(idfinca).get());
		return "finca/formModificarFinca";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute FincaVO finca, Model modelo) {
		fs.save(finca);
		return mostrar(modelo);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idfinca") int idfinca, Model modelo) {
		fs.deleteById(idfinca);
		modelo.addAttribute("finca", fs.findAll());
		return "finca/mostrarFinca";
	}
	
	
	@RequestMapping("/plano")
	public String plano(@RequestParam("idfinca") int idfinca, Model modelo) {
		int maxColumna=0;
		int maxFila=0;
		int cuads;
		if(fs.findById(idfinca).get().getArbol().isEmpty()==true) {
			System.out.println(fs.findById(idfinca).get());
			modelo.addAttribute("erfinca", fs.findById(idfinca).get());
			return "arbol/noArbolesError";
		}
		
		for(int i=0; i<fs.findById(idfinca).get().getArbol().size(); i++) {
			if(fs.findById(idfinca).get().getArbol().get(i).getColumna()>maxColumna) {
				maxColumna=fs.findById(idfinca).get().getArbol().get(i).getColumna();
			}
			if(fs.findById(idfinca).get().getArbol().get(i).getFila()>maxFila) {
				maxFila=fs.findById(idfinca).get().getArbol().get(i).getFila();
			}
		}
		
		cuads = (maxFila*maxColumna)-(fs.findById(idfinca).get().getArbol().size());
		ArrayList<Integer> cuards = new ArrayList<Integer>();
		for(int i=0; i<cuads; i++){
			cuards.add(i);
		}
		
		modelo.addAttribute("finca", fs.findById(idfinca));
		modelo.addAttribute("maxColumna", maxColumna);
		modelo.addAttribute("maxFila", maxFila);
		modelo.addAttribute("cuads", cuards);
		modelo.addAttribute("arboles", fs.findById(idfinca).get().getArbol());
		return "finca/planoFinca";
	}
	
	@RequestMapping("/user/planous")
	public String planous(@RequestParam("idfinca") int idfinca, Model modelo) {
		int maxColumna=0;
		int maxFila=0;
		int cuads;
		if(fs.findById(idfinca).get().getArbol().isEmpty()==true) {
			System.out.println(fs.findById(idfinca).get());
			modelo.addAttribute("erfinca", fs.findById(idfinca).get());
			return "arbol/noArbolesError";
		}
		
		for(int i=0; i<fs.findById(idfinca).get().getArbol().size(); i++) {
			if(fs.findById(idfinca).get().getArbol().get(i).getColumna()>maxColumna) {
				maxColumna=fs.findById(idfinca).get().getArbol().get(i).getColumna();
			}
			if(fs.findById(idfinca).get().getArbol().get(i).getFila()>maxFila) {
				maxFila=fs.findById(idfinca).get().getArbol().get(i).getFila();
			}
		}
		cuads = (maxFila*maxColumna)-(fs.findById(idfinca).get().getArbol().size());
		ArrayList<Integer> cuards = new ArrayList<Integer>();
		for(int i=0; i<cuads; i++){
			cuards.add(i);
		}
		
		modelo.addAttribute("finca", fs.findById(idfinca));
		modelo.addAttribute("maxColumna", maxColumna);
		modelo.addAttribute("maxFila", maxFila);
		modelo.addAttribute("cuads", cuards);
		modelo.addAttribute("arboles", fs.findById(idfinca).get().getArbol());
		return "finca/user/planoFincaus";
	}
}