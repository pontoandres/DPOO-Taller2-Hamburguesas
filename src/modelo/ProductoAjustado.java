package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	/*
	 * atributos
	 */
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados = new ArrayList<>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<>();
	
	/**
	 * metodos
	 */
	public ProductoAjustado(ProductoMenu pBase) {
		base = pBase;
	}
	
	public void agregarIngrediente(Ingrediente ingredient) {
		agregados.add(ingredient);
	}
	public void eliminarIngrediente(Ingrediente ingredient) {
		eliminados.add(ingredient);
	}
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return base.getNombre();
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

}
