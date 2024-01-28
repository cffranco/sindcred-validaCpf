package com.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacao.model.Validacpf;
import com.votacao.service.ValidaCPFService;


@RestController
@RequestMapping("/valida")
public class ValidaCpfController {
	
	@Autowired
	ValidaCPFService  service;
	
	@GetMapping(value = "/{cpf}",
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Validacpf validaCpf(@PathVariable(value = "cpf") String cpf) {
		return service.validarCPF(cpf);
	}
	
	

}
