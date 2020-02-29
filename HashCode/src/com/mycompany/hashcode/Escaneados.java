package com.mycompany.hashcode;

import java.util.ArrayList;

public class Escaneados {
	public int idLibreria;
	public int librosEscaneados;
	public ArrayList<Integer> listaIdsLibrosEscaneados;
	
	public Escaneados() {
		super();
	}
	
	public int getIdLibreria() {
		return idLibreria;
	}
	public void setIdLibreria(int idLibreria) {
		this.idLibreria = idLibreria;
	}
	public int getLibrosEscaneados() {
		return librosEscaneados;
	}
	public void setLibrosEscaneados(int librosEscaneados) {
		this.librosEscaneados = librosEscaneados;
	}
	public ArrayList<Integer> getListaIdsLibrosEscaneados() {
		return listaIdsLibrosEscaneados;
	}
	public void setListaIdsLibrosEscaneados(ArrayList<Integer> listaIdsLibrosEscaneados) {
		this.listaIdsLibrosEscaneados = listaIdsLibrosEscaneados;
	}
}
