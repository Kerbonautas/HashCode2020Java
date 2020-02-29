package com.mycompany.hashcode;

import java.util.ArrayList;
import java.util.List;

public class Libreria extends ArrayList<Libro> implements Comparable<Libreria>{
	public int idLibreria;
	public int numeroLibros;
	public Integer diasSignUp;
	public int librosPorDiaAEscanear;
	public int puntos;
	public Double factor;

	public Libreria(int idLibreria, int numeroLibros, int diasSignUp, int librosPorDiaAEscanear, int diasRestantes) {
		super();
		this.idLibreria = idLibreria;
		this.numeroLibros = numeroLibros;
		this.diasSignUp = Integer.valueOf(diasSignUp);
		this.librosPorDiaAEscanear = librosPorDiaAEscanear;
		calcularPuntos(diasRestantes);
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
	
	public List<Libro> getLibrosUtiles(int diasR) {
		if (diasR <= diasSignUp) {
			return new ArrayList <Libro>();
		} else if(diasR > diasSignUp + (this.size() / librosPorDiaAEscanear)) { 
			return this.subList(0, this.size());
		} else {
			int index = diasR - getDiasSignUp();
			return this.subList(0, index*librosPorDiaAEscanear);
		}
	}

	public void calcularPuntos(int diasR) {
		
		if (diasR <= diasSignUp) {
			factor = 0d;
			puntos = 0;
		} else if(diasR > diasSignUp + (this.size() / librosPorDiaAEscanear)) {
			
			for(Libro lib : this) {
				puntos  += lib.getValor();
			}
			
			factor = (double) ((this.getPuntos())/(getDiasSignUp()+(this.size()/librosPorDiaAEscanear)));
			
			//factor = (double) ((this.getPuntos())/diasR);
			
		} else {
			int index = diasR - getDiasSignUp();
			
			for (Libro lib : this.subList(0, index*librosPorDiaAEscanear)) {
				puntos += lib.getValor();
			}
			
			factor = (double) (getPuntos() / getDiasSignUp() + index);		
			//factor = (double) ((this.getPuntos())/diasR);
		}
	}

	public int getPuntos() {
		return this.puntos;
	}
	
	@Override
	public boolean add(Libro e) {
		if (!this.contains(e))
			return super.add(e);
		return false;
	}

	@Override
	public int compareTo(Libreria lib) {
		return lib.getFactor().compareTo(this.getFactor());
	}
	public Double getFactor() {
	    //return Double.valueOf((this.getPuntos())/(getDiasSignUp()+(this.size()/librosPorDiaAEscanear)));
		return factor;
	  }
}
