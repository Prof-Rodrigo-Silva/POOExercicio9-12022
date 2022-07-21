package model;

import java.util.Objects;

public class Compromisso {
	
	private int dia;
	private int mes;
	private String descricao;
	
	public Compromisso() {
		
	}
	
	public Compromisso(int dia, int mes, String descricao) {
		this.dia = dia;
		this.mes = mes;
		this.descricao = descricao;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compromisso other = (Compromisso) obj;
		return dia == other.dia && mes == other.mes;
	}

	@Override
	public String toString() {
		return "Dados do Compromisso: " + dia + "/" + mes + " - Descrição = " + descricao ;
	}
	
	

}
