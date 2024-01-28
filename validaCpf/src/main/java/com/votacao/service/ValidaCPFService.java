package com.votacao.service;

import org.springframework.stereotype.Service;

import com.votacao.model.Validacpf;

@Service
public class ValidaCPFService {
	
	 public  Validacpf validarCPF(String cpf) {
	        // Remover caracteres não numéricos
		    Validacpf validacpf = new Validacpf();
		    
		    validacpf.setCpfValido("nao");
		 	
		 	cpf = cpf.replaceAll("[^0-9]", "");

	        // Verificar se o CPF tem 11 dígitos
	        if (cpf.length() != 11) {
	            return validacpf;
	        }

	        // Verificar se todos os dígitos são iguais
	        if (cpf.matches("(\\d)\\1{10}")) {
	            return validacpf;
	        }

	        // Calcular e verificar os dígitos verificadores
	        int soma = 0;
	        for (int i = 0; i < 9; i++) {
	            soma += (cpf.charAt(i) - '0') * (10 - i);
	        }
	        int digito1 = 11 - (soma % 11);
	        if (digito1 > 9) {
	            digito1 = 0;
	        }

	        soma = 0;
	        for (int i = 0; i < 10; i++) {
	            soma += (cpf.charAt(i) - '0') * (11 - i);
	        }
	        int digito2 = 11 - (soma % 11);
	        if (digito2 > 9) {
	            digito2 = 0;
	        }

	        // Verificar se os dígitos calculados são iguais aos dígitos informados
	        boolean tmp = (digito1 == cpf.charAt(9) - '0') && (digito2 == cpf.charAt(10) - '0');
	        
	        if(tmp) {
	        	validacpf.setCpfValido("sim");
	        }
	       
	        return validacpf;
	    }

}
