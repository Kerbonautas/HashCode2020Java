package com.mycompany.hashcode;

public class Libro implements Comparable<Libro>{
	
	//Numero del libro
	private int id;
	//Puntos del libro
	private Integer valor;
	
	public Libro(int id, int valor) {
		this.id = id;
		this.valor = Integer.valueOf(valor);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Libro) {
			return ((Libro) arg0).getId()==this.getId();
		}
		return super.equals(arg0);
	}

	//Se ordenarán de mayor a menor
	@Override
	public int compareTo(Libro o) {
		return o.getValor().compareTo(this.getValor());
	}
}
