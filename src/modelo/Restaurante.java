package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
	
	private ArrayList<Ingrediente> ingredientes = new ArrayList<>();
	private ArrayList<ProductoMenu> menuBase = new ArrayList<>();
	private ArrayList<Combo> combos = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private Pedido pedidoEnCurso;
	
	public Restaurante() {
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
		pedidoEnCurso = nuevoPedido;
		pedidos.add(nuevoPedido);
	}
	public void cerrarYGuardarPedido() {
		
		File factura = new File("factura.txt");
		pedidoEnCurso.guardarFactura(factura);
		pedidoEnCurso = null;
	}
	public Pedido getPedidoEnCurso() {
		
		return pedidoEnCurso;
		
	}
	public ArrayList<ProductoMenu> getMenuBase(){
		
		return menuBase;
		
	}
	public ArrayList<Ingrediente> getIngredientes(){
		
		return ingredientes;
		
	}
	public ArrayList<Combo> getCombos(){
		
		return combos;
		
	}
	public ArrayList<Pedido> getPedidos(){
		
		return pedidos;
		
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoIngredientes));
			String line;
			String[] lista;
			String nombreProducto;
			int precioProducto;
			
			
			while((line = reader.readLine()) != null) {
				
				lista = line.split(";");
				nombreProducto = lista[0];
				precioProducto = Integer.parseInt(lista[1]);
				
				Ingrediente nuevo = new Ingrediente(nombreProducto, precioProducto);
				ingredientes.add(nuevo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cargarMenu(File archivoMenu) throws NumberFormatException, IOException{
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoMenu));
			String line;
			String[] lista;
			String nombre;
			int precio;
			
			
			while((line = reader.readLine()) != null) {
				lista = line.split(";");
				nombre = lista[0];
				precio = Integer.parseInt(lista[1]);
				
				ProductoMenu nuevo = new ProductoMenu(nombre, precio);
				menuBase.add(nuevo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cargarCombos(File archivoCombos) throws NumberFormatException, IOException {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoCombos));
			String line;
			String[] lista;
			String nombre;
			String cambio;
			int descuento;			
			
			while((line = reader.readLine()) != null) {
				lista = line.split(";");
				nombre = lista[0];
				cambio = lista[1];
				cambio = cambio.replace("%","");
				descuento = Integer.parseInt(cambio);
				
				//String[] items = {lista[0], lista[1], lista[2]};
				
				Combo nuevo = new Combo(nombre, descuento);
				combos.add(nuevo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}