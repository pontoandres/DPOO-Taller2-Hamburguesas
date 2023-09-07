package modelo;

public class Ingrediente {
	
	private String nombre;
	private int costoAdicional;
	private int calorias;
	
	public Ingrediente (String pNombre, int pCostoAdicional, int pCalorias) {
		
		nombre = pNombre;
		costoAdicional = pCostoAdicional;
		calorias = pCalorias;
		
	}
	public String getNombre() {
		
		return nombre;
		
	}
	public int getCostoAdicional() {
		
		return costoAdicional;
		
	}
	public int getCalorias() {
		return calorias;
	}
}
