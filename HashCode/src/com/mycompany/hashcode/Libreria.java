package com.mycompany.hashcode;

import java.util.ArrayList;

public class Libreria extends ArrayList<Libro> implements Comparable<Libreria>{
	public int idLibreria;
	public int numeroLibros;
	public Integer diasSignUp;
	public int librosPorDiaAEscanear;

	public Libreria(int idLibreria, int numeroLibros, int diasSignUp, int librosPorDiaAEscanear) {
		super();
		this.idLibreria = idLibreria;
		this.numeroLibros = numeroLibros;
		this.diasSignUp = Integer.valueOf(diasSignUp);
		this.librosPorDiaAEscanear = librosPorDiaAEscanear;
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

	public int getPuntos() {
		return 0;
	}
	
	@Override
	public int compareTo(Libreria lib) {
		return lib.getFactor().compareTo(this.getFactor());
	}
	public Double getFactor() {
	    return Double.valueOf((this.getPuntos())/(getDiasSignUp()+(this.size()/librosPorDiaAEscanear)));
	  }
}
