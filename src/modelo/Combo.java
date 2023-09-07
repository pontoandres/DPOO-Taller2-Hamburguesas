package modelo;

import java.util.ArrayList;

public class Combo implements Producto {
	/**
	 * atributos
	 */
	private int descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<>();
	private int calorias;
	
	/**
	 * metodos
	 */
	public Combo(String nombre, int pDescuento, int pCalorias) {
		nombreCombo = nombre;
		descuento = pDescuento;
		calorias = pCalorias;
		
		
	}
	public void agregarItemACombo(ProductoMenu itemCombo) {
		
		itemsCombo.add(itemCombo);
		
	}
	@Override
	public int getPrecio() {
		
		int precio = 0;
		
		if (nombreCombo.equals("combo corral")) {
			precio = ((16000 + 5500 + 5000) * descuento)/100;
		} else if (nombreCombo.equals("combo corral queso")) {
			precio = ((14000 + 5500 + 5000) * descuento)/100;
		} else if (nombreCombo.equals("combo todoterreno")) {
			precio = ((25000 + 6900 + 5000) * descuento)/100;
		} else if (nombreCombo.equals("combo especial")) {
			precio = ((24000 + 5500 + 5000) * descuento)/100;
		}
		
		return precio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombreCombo;
	}

	@Override
	public String generarTextoFactura() {
		
		
		return null;
	}
	@Override
	public int getCalorias() {
		// TODO Auto-generated method stub
		return calorias;
	}

}
