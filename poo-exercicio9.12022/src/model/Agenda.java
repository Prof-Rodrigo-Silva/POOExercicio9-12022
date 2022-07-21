package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import classeauxiliar.Situacao;

public class Agenda {
	
	private String nome;
	private int ano;
	private List<Compromisso> compromissos;
	
	public Agenda() {
		this.compromissos = new ArrayList<Compromisso>();
	}
	
	public Agenda(String nome, int ano) {
		this.nome = nome;
		this.ano = ano;
		this.compromissos = new ArrayList<Compromisso>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Compromisso> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, compromissos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return ano == other.ano && Objects.equals(compromissos, other.compromissos) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Minha Agenda: " + nome + ", ano (" + ano + ")";
	}
	
	public String addCompromisso(Compromisso compromisso) {
		if(this.compromissos.add(compromisso)) {
			return Situacao.ADD;
		}else {
			return Situacao.ERRO;
		}
	}
	
	public String removeCompromisso(int dia, int mes) {
		String retorno = "";
		if (getSizeList()) {
			//Crio uma lista de cópia para percorrer para evitar...
			//o erro ConcurrentModificationException
			List<Compromisso> c1 = new ArrayList<Compromisso>();
			c1.addAll(compromissos);
			for(Compromisso c : c1){
				//Poderia ser como a linha abaixo
				//compromissos.removeIf(n -> (c.getDia() == dia && c.getMes() == mes));
				if (c.getDia() == dia && c.getMes() == mes){
					//Mas criei um outro método para remover da lista quente.
					retorno  = removeHotList(c);
				}
			}
		} else {
			retorno = Situacao.LIST_VAZIA;
		}
		return retorno;
	}
	
	private String removeHotList(Compromisso c) {
		this.compromissos.remove(c);
		return Situacao.REMOVE;
	}
		
	public boolean getSizeList() {
		if(!this.compromissos.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
