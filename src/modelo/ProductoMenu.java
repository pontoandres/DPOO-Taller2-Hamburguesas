package modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	
	/**
	 * metodos
	 */
	public ProductoMenu(String pNombre, int pPrecioBase) {
		nombre = pNombre;
		precioBase = pPrecioBase;
	}

	@Override
	public double getPrecio() {
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
		return null;
	}

}
