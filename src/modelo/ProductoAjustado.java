package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	/*
	 * atributos
	 */
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados = new ArrayList<>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<>();
	private int calorias;
	
	/**
	 * metodos
	 */
	public ProductoAjustado(ProductoMenu pBase) {
		base = pBase;
		calorias = pBase.getCalorias();
	}
	
	public void agregarIngrediente(Ingrediente ingredient) {
		agregados.add(ingredient);
	}
	public void eliminarIngrediente(Ingrediente ingredient) {
		eliminados.add(ingredient);
	}
	
	@Override
	public int getPrecio() {
		
		int costoAdicional = 0;
		
		for(Ingrediente ing : agregados) {
			costoAdicional += ing.getCostoAdicional();
		}
		
		
		return base.getPrecio() + costoAdicional;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return base.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		String add = "";
		String elim = "";
		for(Ingrediente ing : agregados) {
			add += ing.getNombre();
		}
		for(Ingrediente ing : eliminados) {
			elim += ing.getNombre();
		}
		
		return base.getNombre() + "....." + getPrecio() + "\nAddiciones: " + add + "\nEliminacion: " + elim + "\nCalorias: " + getCalorias();
	}

	@Override
	public int getCalorias() {
		
		int caloriasMas = 0;
		int caloriasMenos = 0;
		
		for(Ingrediente ing : agregados) {
			caloriasMas += ing.getCalorias();
		}
		for(Ingrediente ing : eliminados) {
			caloriasMenos += ing.getCalorias();
		}
		return (calorias + caloriasMas - caloriasMenos);
	}

}
