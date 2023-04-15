package com.example.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoCotroller {
	
	@GetMapping("/hola")
	public String saludar() {
		return "no te rindas Luis!";
		
	}

}
