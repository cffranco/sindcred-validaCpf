package com.votacao.model;

import java.io.Serializable;
import java.util.Objects;


public class Validacpf implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cpfValido;
	
	public String getCpfValido() {
		return cpfValido;
	}
	public void setCpfValido(String cpfValido) {
		this.cpfValido = cpfValido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpfValido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Validacpf other = (Validacpf) obj;
		return Objects.equals(cpfValido, other.cpfValido);
	}
	

	
	

}
