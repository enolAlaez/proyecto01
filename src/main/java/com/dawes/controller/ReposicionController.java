package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ReposicionVO;
import com.dawes.service.ReposicionService;

@Controller
@RequestMapping("/reposiciones")
public class ReposicionController {
	
	@Autowired
	ReposicionService reps;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("reps", reps.findAll());
		return "finca/mostrarFinca";
	}
	


}
