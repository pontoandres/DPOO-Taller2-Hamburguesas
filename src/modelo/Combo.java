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
		
		ProductoMenu papasMedianas = new ProductoMenu("papas medianas", 5500, 450);
		ProductoMenu papasGrandes = new ProductoMenu("papas grandes", 6900, 500);
		ProductoMenu corral = new ProductoMenu("corral", 14000, 546);
		ProductoMenu corralQueso = new ProductoMenu("corral queso", 16000, 626);
		ProductoMenu todoterreno = new ProductoMenu("todoterreno", 25000, 775);
		ProductoMenu gaseosa = new ProductoMenu("gaseosa", 5000, 150);
		ProductoMenu especial = new ProductoMenu("especial", 24000, 681);
		
		if (nombreCombo.equals("combo corral")){
			
			agregarItemACombo(papasMedianas);
			agregarItemACombo(gaseosa);
			agregarItemACombo(corral);
			
		}
		else if(nombreCombo.equals("combo corral queso")) {
			
			agregarItemACombo(papasMedianas);
			agregarItemACombo(gaseosa);
			agregarItemACombo(corralQueso);
		
		}
		else if(nombreCombo.equals("combo todoterreno")) {
			
			agregarItemACombo(gaseosa);
			agregarItemACombo(papasGrandes);
			agregarItemACombo(todoterreno);
		
		}
		else if(nombreCombo.equals("combo especial")) {
			
			agregarItemACombo(papasMedianas);
			agregarItemACombo(gaseosa);
			agregarItemACombo(especial);
		
		}
		
	}
	public void agregarItemACombo(ProductoMenu itemCombo) {
		
		itemsCombo.add(itemCombo);
		
	}
	@Override
	public int getPrecio() {
		
		int precio = 0;
		
		if (nombreCombo.equals("combo corral")) {
			precio = ((16000 + 5500 + 5000) * (100-descuento))/100;
		} else if (nombreCombo.equals("combo corral queso")) {
			precio = ((14000 + 5500 + 5000) * (100-descuento))/100;
		} else if (nombreCombo.equals("combo todoterreno")) {
			precio = ((25000 + 6900 + 5000) * (100-descuento))/100;
		} else if (nombreCombo.equals("combo especial")) {
			precio = ((24000 + 5500 + 5000) * (100-descuento))/100;
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
		
		String texto = "";
		
		if (nombreCombo.equals("combo corral")) {
			
			texto = nombreCombo + "......" + 23835 + "\nCalorias: " + calorias;
		} else if (nombreCombo.equals("combo corral queso")) {
			
			texto = nombreCombo + "......" + 22050 + "\nCalorias: " + calorias;
		} else if (nombreCombo.equals("combo todoterreno")) {
			
			texto = nombreCombo + "......" + 34317 + "\nCalorias: " + calorias;
			
		} else if (nombreCombo.equals("combo especial")) {
			
			texto = nombreCombo + "......" + 32085 + "\nCalorias: " + calorias;
		}
		
		return texto;
	}
	@Override
	public int getCalorias() {
		
		return calorias;
	}

}
