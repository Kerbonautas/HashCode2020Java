package com.mycompany.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class Principal extends Thread{
	public String fichATratar;
	public String type;
	public int numeroLibrosDiferentes;
	public int numeroLibrerias;
	public int numeroDias;
	public HashMap<Integer, Integer> listaPuntosLibro;
	public ArrayList<Libreria> listaLibrerias;
	public ArrayList<Escaneados> listaEscaneados;

	public Principal(String file, String type) {
		fichATratar = file;
		this.type = type;
		listaPuntosLibro = new HashMap<Integer, Integer>(); //Almacena los puntos que se obteniente en cada libro <id, valor>
		listaLibrerias = new ArrayList<Libreria>();
		listaEscaneados = new ArrayList<Escaneados>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Launching " + type + "...");
		
		leerFichero();
		ejecutar();
		escribirFichero();
		
		System.out.println(type + " ended.");
	}

	public void ejecutar() {
		Collections.sort(listaLibrerias);
		ArrayList<Libro> librosABorrar = new ArrayList<Libro>();
		while(numeroDias>0&&listaLibrerias.size()>0) {//numero dias restante
			Escaneados escaneado = new Escaneados();
			Libreria libreria = listaLibrerias.get(0);//siempre la primera
			numeroDias -= libreria.getDiasSignUp();
			if(numeroDias < 0) break;
			escaneado.setIdLibreria(libreria.getidLibreria());
			ArrayList<Integer> listaLibrosEscaneados = new ArrayList<Integer>();
			int leer = Math.min(libreria.getNumeroLibros(), (numeroDias*libreria.librosPorDiaAEscanear)-1);
			//System.out.println(lib.getListaLibros().size());
			//System.out.println(leer);
			for (Libro book:libreria) {
				listaLibrosEscaneados.add(book.getId());
				librosABorrar.add(book);
				//listaPuntosLibro.put(book.getId(), 0);//TODO cambiar para eliminar los libros del resto de librerias
			}
			borrarLibros(librosABorrar);
			escaneado.setLibrosEscaneados(listaLibrosEscaneados.size());
			escaneado.setListaIdsLibrosEscaneados(listaLibrosEscaneados);
			listaEscaneados.add(escaneado);
			listaLibrerias.remove(0);
			for(Libreria libr : listaLibrerias) {
				libr.calcularPuntos();
			}
			Collections.sort(listaLibrerias);
		}
	}

	public void leerFichero() {
		File input = new File(".\\GoogleFiles\\in\\" + fichATratar);
		BufferedReader br = null;
		FileInputStream fis = null;
		String linea = "";
		try {
			fis = new FileInputStream(input);
			br = new BufferedReader(new InputStreamReader(fis));
			linea = br.readLine();
			numeroLibrosDiferentes = Integer.parseInt(linea.split(" ")[0]);
			numeroLibrerias = Integer.parseInt(linea.split(" ")[1]);
			numeroDias = Integer.parseInt(linea.split(" ")[2]);
			linea = br.readLine();
			String[] listaAux = linea.split(" ");
			for (int i = 0; i < listaAux.length; i++) {
				listaPuntosLibro.put(i, Integer.valueOf(listaAux[i]));
			}

			for (int idLibreria = 0; idLibreria < numeroLibrerias; idLibreria++) {
				linea = br.readLine();
				int numeroLibros = Integer.parseInt(linea.split(" ")[0]);
				int diasSignUp = Integer.parseInt(linea.split(" ")[1]);
				int librosPorDiaAEscanear = Integer.parseInt(linea.split(" ")[2]);
				//System.out.println("numLib: "+numeroLibros+",diasSing: "+diasSignUp+"libros dia: "+librosPorDiaAEscanear);
				linea = br.readLine();
				int[] intlist = Stream.of(linea.split(" ")).mapToInt(Integer::parseInt).toArray();
				
				Libreria lbr = new Libreria(idLibreria, numeroLibros, diasSignUp, librosPorDiaAEscanear);
				
				for (int i : intlist) lbr.add(new Libro(i, listaPuntosLibro.get(i)));
				
				listaLibrerias.add(lbr);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void escribirFichero() {
		File output = new File(".\\GoogleFiles\\out\\" + type + ".txt");
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		String escritura = "";
		try {
			fos = new FileOutputStream(output);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			escritura = Integer.toString(listaEscaneados.size());
			bw.write(escritura);
			for (int i = 0; i < listaEscaneados.size(); i++) {
				Escaneados escaneado = listaEscaneados.get(i);
				escritura = escaneado.getIdLibreria() + " " + escaneado.getLibrosEscaneados();
				bw.newLine();
				bw.write(escritura);
				bw.newLine();
				escritura = "";
				for (int n = 0; n < escaneado.getListaIdsLibrosEscaneados().size(); n++) {
					escritura += escaneado.getListaIdsLibrosEscaneados().get(n) + " ";
				}
				escritura = escritura.trim();
				bw.write(escritura);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	private void borrarLibros(ArrayList<Libro> books) {
		listaLibrerias.forEach(libreria-> libreria.removeAll(books));
	}
}