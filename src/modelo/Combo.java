package modelo;

import java.util.ArrayList;

public class Combo implements Producto {
	/**
	 * atributos
	 */
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<>();
	
	/**
	 * metodos
	 */
	public Combo(String nombre, double pDescuento) {
		nombreCombo = nombre;
		descuento = pDescuento;
		
		
	}
	public void agregarItemACombo(ProductoMenu itemCombo) {
		
		itemsCombo.add(itemCombo);
		
	}
	@Override
	public double getPrecio() {
		
		double precio = 0;
		
		if (nombreCombo.equals("combo corral")) {
			precio = (16000 + 5500 + 5000) * descuento;
		} else if (nombreCombo.equals("combo corral queso")) {
			precio = (14000 + 5500 + 5000) * descuento;
		} else if (nombreCombo.equals("combo todoterreno")) {
			precio = (25000 + 6900 + 5000) * descuento;
		} else if (nombreCombo.equals("combo especial")) {
			precio = (24000 + 5500 + 5000) * descuento;
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

}
