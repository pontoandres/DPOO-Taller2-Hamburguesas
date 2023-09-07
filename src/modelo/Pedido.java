package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
	/**
	 * atributos
	 */
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido = new ArrayList<>();
	
	
	/**
	 * metodos
	 */
	public Pedido(String pNombreCliente, String pDireccionCliente) {
		
		nombreCliente = pNombreCliente;
		direccionCliente = pDireccionCliente;
		numeroPedidos++;
		idPedido = numeroPedidos;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	private int getPrecioNetoPedido() {
		
		int precioNeto = 0;
		
		for (Producto item : itemsPedido) {
		
		precioNeto += item.getPrecio();
			
		}
		
		return precioNeto;
	}
	private int getPrecioTotalPedido() {
		
		int precioIVA = getPrecioIVAPedido();
		int precioNeto = getPrecioNetoPedido();
		int precioTotal = precioNeto + precioIVA;
		
		return precioTotal;
	}
	private int getPrecioIVAPedido() {
		
		int precioNeto = getPrecioNetoPedido();
		int precioIVA = (precioNeto * 19)/100;
		
		return precioIVA;	
	}
	public String generarTextoFactura() {
		
		String stringItemsPrecio = null;
		for (Producto item : itemsPedido) {
			stringItemsPrecio += item.getNombre() + "......" + item.getPrecio() + "\n";
			
		}
		
		String texto = "Nombre: " + nombreCliente + "\n" + "Direccion: " + direccionCliente 
				+ "\n----- Items Pedido ----- \n" + stringItemsPrecio 
				+ "\n----- Precio Neto ----- \n" + getPrecioNetoPedido()
				+ "\n----- Precio IVA ----- \n" + getPrecioIVAPedido()
				+ "\n----- Precio Total ----- \n" + getPrecioTotalPedido();
		
		return texto;
	}
	public void guardarFactura(File archivo) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			writer.write("\n----- FACTURA -----\n");
			writer.write("Numero Pedido: " + idPedido + "\n");
			writer.write(generarTextoFactura());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
