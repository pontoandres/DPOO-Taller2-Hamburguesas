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
	private ArrayList<ProductoMenu> bebidas = new ArrayList<>();
	private Pedido pedidoEnCurso;
	
	public Restaurante() {
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
		pedidoEnCurso = nuevoPedido;
		pedidos.add(nuevoPedido);
	}
	public void cerrarYGuardarPedido() {
		
		String nombreArchivo = "factura" + pedidoEnCurso.getIdPedido() + ".txt";
		File factura = new File(nombreArchivo);
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
public ArrayList<ProductoMenu> getBebidas(){
		
		return bebidas;
		
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
			String nombre;
			int precio;
			int calorias;
			
			
			while((line = reader.readLine()) != null) {
				
				lista = line.split(";");
				nombre = lista[0];
				precio = Integer.parseInt(lista[1]);
				calorias = Integer.parseInt(lista[2]);
				
				Ingrediente nuevo = new Ingrediente(nombre, precio, calorias);
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
			int calorias;
			
			
			while((line = reader.readLine()) != null) {
				lista = line.split(";");
				nombre = lista[0];
				precio = Integer.parseInt(lista[1]);
				calorias = Integer.parseInt(lista[2]);
				
				ProductoMenu nuevo = new ProductoMenu(nombre, precio, calorias);
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
			int calorias;
			
			while((line = reader.readLine()) != null) {
				lista = line.split(";");
				nombre = lista[0];
				cambio = lista[1];
				cambio = cambio.replace("%","");
				descuento = Integer.parseInt(cambio);
				calorias = Integer.parseInt(lista[5]);
				
				Combo nuevo = new Combo(nombre, descuento, calorias);
				combos.add(nuevo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cargarBebidas(File archivoBebidas) throws NumberFormatException, IOException {
		
		try {
			BufferedReader reader = new BufferedReader( new FileReader(archivoBebidas));
			String line;
			String[] lista;
			String nombre;
			int precio;
			int calorias;
			
			while((line = reader.readLine()) != null) {
				lista = line.split(";");
				nombre = lista[0];
				precio = Integer.parseInt(lista[1]);
				calorias = Integer.parseInt(lista[2]);
				ProductoMenu nuevo = new ProductoMenu(nombre, precio, calorias);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}