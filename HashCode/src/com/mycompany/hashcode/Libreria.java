package com.mycompany.hashcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Libreria implements Comparable<Libreria>{
	public int idLibreria;
	public int numeroLibros;
	public Integer diasSignUp;
	public int librosPorDiaAEscanear;
	public ArrayList<Integer> listaLibros;
	public long puntos;

	public Libreria(int idLibreria, int numeroLibros, int diasSignUp, int librosPorDiaAEscanear, ArrayList<Integer> listaLibros,long puntos) {
		super();
		this.idLibreria = idLibreria;
		this.numeroLibros = numeroLibros;
		this.diasSignUp = Integer.valueOf(diasSignUp);
		this.librosPorDiaAEscanear = librosPorDiaAEscanear;
		this.listaLibros = listaLibros;
		this.puntos = puntos;
	}

	public int getidLibreria() {
		return idLibreria;
	}

	public void setidLibreria(int idLibreria) {
		this.idLibreria = idLibreria;
	}
	
	public int getNumeroLibros() {
		return numeroLibros;
	}

	public void setNumeroLibros(int numeroLibros) {
		this.numeroLibros = numeroLibros;
	}

	public Integer getDiasSignUp() {
		return diasSignUp;
	}

	public void setDiasSignUp(int diasSignUp) {
		this.diasSignUp = diasSignUp;
	}

	public int getLibrosPorDiaAEscanear() {
		return librosPorDiaAEscanear;
	}

	public void setLibrosPorDiaAEscanear(int librosPorDiaAEscanear) {
		this.librosPorDiaAEscanear = librosPorDiaAEscanear;
	}

	public ArrayList<Integer> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Integer> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(Libreria lib) {
		return lib.getFactor().compareTo(this.getFactor());
	}
	public Double getFactor() {
	    return Double.valueOf((this.puntos)/(getDiasSignUp()+(listaLibros.size()/librosPorDiaAEscanear)));
	  }
}
