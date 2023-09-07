package modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	private int calorias;
	
	/**
	 * metodos
	 */
	public ProductoMenu(String pNombre, int pPrecioBase, int pCalorias) {
		nombre = pNombre;
		precioBase = pPrecioBase;
		calorias = pCalorias;
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return nombre + "....." + precioBase + "\nCalorias: " + calorias;
	}

	@Override
	public int getCalorias() {
		// TODO Auto-generated method stub
		return calorias;
	}

}
