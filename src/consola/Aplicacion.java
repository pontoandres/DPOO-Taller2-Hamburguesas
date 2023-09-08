package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.Restaurante;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;
import modelo.Combo;

public class Aplicacion {
	
	private Restaurante restaurante; 

	public void ejecutarAplicacion() throws IOException {
		
		restaurante = new Restaurante();
		
		boolean continuar = true;
		File archivoIngredientes = new File("./data/ingredientes.txt");
		File archivoMenu = new File("./data/menu.txt");
		File archivoCombos = new File("./data/combos.txt");
		
		restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		
		while(continuar) {
			
			try {
				
				mostrarMenu();
				int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opcion: "));
				
				if (opcionSeleccionada != 6) {
					
					ejecutarOpcion(opcionSeleccionada);
				}
				else {
					
					System.out.println("\nSaliendo de la aplicacion...");
					continuar = false;
				}
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	public void mostrarMenu() {
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el Menu.");
		System.out.println("2. Iniciar un nuevo pedido.");
		System.out.println("3. Agregar un Elemento a un pedido.");
		System.out.println("4. Cerrar un pedido y guardar la factura.");
		System.out.println("5. Consultar la informacion de un pedido dado su id.");
		System.out.println("6. Salir de la aplicacion");
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) {
		
		
		if(opcionSeleccionada == 1) {
			
			ArrayList<Ingrediente> ingredient = new ArrayList<>();
			ArrayList<Combo> combos = new ArrayList<>();
			ArrayList<ProductoMenu> menu = new ArrayList<>();
			ArrayList<ProductoMenu> bebidas = new ArrayList<>();
			
			System.out.println("\n------ Menu Combos ------\n");
			System.out.println("Nombre Combo : Precio\n");
			
			int i = 1;
			combos = restaurante.getCombos();
			for (Combo comb : combos) {
				System.out.println(i + "." + comb.getNombre() + " : " + comb.getPrecio());
				i++;
			}
			
			System.out.println("\n------ Menu Base ------\n");
			System.out.println("Nombre Producto : Precio\n");
			
			i = 1;
			menu = restaurante.getMenuBase();
			for (ProductoMenu base : menu) {
				System.out.println(i + "." + base.getNombre() + " : " + base.getPrecio());
				i++;
			}
			System.out.println("\n------ Menu Bebidas ------\n");
			System.out.println("Nombre Producto : Precio\n");
			
			i = 1;
			bebidas = restaurante.getBebidas();
			for (ProductoMenu bebida : bebidas) {
				System.out.println(i + "." + bebida.getNombre() + " : " + bebida.getPrecio());
				i++;
			}
			
			System.out.println("\n------ Menu Ingredientes ------\n");
			System.out.println("Nombre Ingrediente : Precio\n");
			
			i=1;
			ingredient = restaurante.getIngredientes();
			for (Ingrediente ingr : ingredient) {
				System.out.println(i + "." + ingr.getNombre() + " : " + ingr.getCostoAdicional());
				i++;
			}
		}
		else if (opcionSeleccionada == 2) {
			
			String nombreCliente = input("Por favor ingrese el nombre del cliente: ");
			String direccionCliente = input("por favor ingrese la direcccion del cliente: ");
			
			restaurante.iniciarPedido(nombreCliente, direccionCliente);
			System.out.println("\nEl pedido se ha creado. Por favor agregar items al pedido.");
			
		}
		else if (opcionSeleccionada == 3) {
			
			System.out.println("\n------ Tipos de Productos ------\n");
			System.out.println("1. Combo\n"
					+ "2. Producto del Menu Base\n"
					+ "3.Bebida\n"
					+ "4. Producto Ajustado (Productos del menu base al que se les ha agregado/ eliminado ingredientes\n");
			
			int tipo = Integer.parseInt(input("Por favor digite el numero del tipo de Producto que desea agreagar a su pedido: "));
			
			if (tipo == 1 ) {
				int opcion = Integer.parseInt(input("Por favor digite el numero del Combo que desea agregar a su pedido: "));
				
				if (opcion == 1) {
					
					agregarCombo("combo corral");
					
				} 
				else if(opcion == 2){
					
					agregarCombo("combo corral queso");
					
				}
				else if(opcion == 3){
					
					agregarCombo("combo todoterreno");
					
				}
				else if(opcion == 4){
					
					agregarCombo("combo especial");
					
				}
			} else if(tipo == 2) {
				
				int opcion = Integer.parseInt(input("Por favor digite el numero del Producto Base que desea agregar a su pedido: "));
				
				if (opcion == 1) {
					
					agregarProductoMenu("corral");
					
				}
				else if (opcion == 2) {
					
					agregarProductoMenu("corral queso ");
				}
				else if (opcion == 3) {
					
					agregarProductoMenu("corral pollo");
				}
				else if (opcion == 4) {
					
					agregarProductoMenu("corralita");
				}
				else if (opcion == 5) {
					
					agregarProductoMenu("todoterreno");
				}
				else if (opcion == 6) {
					
					agregarProductoMenu("1/2 libra");
				}
				else if (opcion == 7) {
					
					agregarProductoMenu("especial");
				}
				else if (opcion == 8) {
					
					agregarProductoMenu("casera");
					
				}
				else if (opcion == 9) {
					
					agregarProductoMenu("mexicana");
				}
				else if (opcion == 10) {
					
					agregarProductoMenu("criolla");
				}
				else if (opcion == 11) {
					
					agregarProductoMenu("costeña");
				}
				else if (opcion == 12) {
					
					agregarProductoMenu("hawaiana");
				}
				else if (opcion == 13) {
					
					agregarProductoMenu("wrap de pollo");
				}
				else if (opcion == 14) {
					
					agregarProductoMenu("wrap de lomo");
				}
				else if (opcion == 15) {
					
					agregarProductoMenu("ensalada mexicana");
				}
				else if (opcion == 16) {
					
					agregarProductoMenu("papas medianas");
				}
				else if (opcion == 17) {
					
					agregarProductoMenu("papas grandes");
				}
				else if (opcion == 18) {
					
					agregarProductoMenu("papas en casco medianas");
				}
				else if (opcion == 19) {
					
					agregarProductoMenu("papas en casco grandes");
				}
				
				
			} else if(tipo == 3) {
				
				int opcion = Integer.parseInt(input("Por favor digite el numero de la bebida que desea agregar: "));
				
				if (opcion == 1) {
					
					agregarBebida("agua cristal sin gas");
				}
				else if(opcion == 2) {
					
					agregarBebida("agua cristal con gas");
				}
				else if (opcion == 3) {
					
					agregarBebida("gaseosa");
				}
				
			}else if(tipo == 4){
				
				int prod = Integer.parseInt(input("Por favor digite el numero del Producto Base que desea modificar: "));
				
				ProductoAjustado prA = crearProdAjustado(prod);
				
				
				boolean sentinela = true;
				
				while(sentinela) {
					try {
						
						System.out.println("\nLe gustaria agregar o eliminar un elemento a su pedido?\n"
								+ "1.Agregar.\n"
								+ "2.Eliminar.\n"
								+ "3.Salir");
						int opcion = Integer.parseInt(input("Por favor digite el numero: "));
						
						if (opcion == 1) {
							int ing = Integer.parseInt(input("Por favor digite el numero del Ingrediente que desea agregar a su pedido: "));
							
							if (ing == 1) {
								
								agregarOEliminarProductoAjustado("lechuga", opcion, prA);
							}
							else if (ing == 2) {
								
								agregarOEliminarProductoAjustado("tomate", opcion, prA);
							}
							else if (ing == 3) {
								
								agregarOEliminarProductoAjustado("cebolla", opcion, prA);
							}
							else if (ing == 4) {
								
								agregarOEliminarProductoAjustado("queso mozzarella", opcion, prA);
							}
							else if (ing == 5) {
								
								agregarOEliminarProductoAjustado("huevo", opcion, prA);
							}
							else if (ing == 6) {
								
								agregarOEliminarProductoAjustado("queso americano", opcion, prA);
							}
							else if (ing == 7) {
								
								agregarOEliminarProductoAjustado("tocineta express", opcion, prA);
							}
							else if (ing == 8) {
								
								agregarOEliminarProductoAjustado("papa callejera", opcion, prA);
							}
							else if (ing == 9) {
								
								agregarOEliminarProductoAjustado("pepinillos", opcion, prA);
							}
							else if (ing == 10) {
								
								agregarOEliminarProductoAjustado("cebolla grille", opcion, prA);
							}
							else if (ing == 11) {
								
								agregarOEliminarProductoAjustado("suero costeño", opcion, prA);
							}
							else if (ing == 12) {
								
								agregarOEliminarProductoAjustado("frijol refrito", opcion, prA);
							}
							else if (ing == 13) {
								
								agregarOEliminarProductoAjustado("queso fundido", opcion, prA);
							}
							else if (ing == 14) {
								
								agregarOEliminarProductoAjustado("tocineta picada", opcion, prA);
							}
							else if (ing == 15) {
								
								agregarOEliminarProductoAjustado("piña", opcion, prA);
							}
						}
						else if (opcion ==2) {
							
							int ing = Integer.parseInt(input("Por favor digite el numero del Ingrediente que desea eliminar de su pedido: "));
							
							if (ing == 1) {
								
								agregarOEliminarProductoAjustado("lechuga", opcion, prA);
							}
							else if (ing == 2) {
								
								agregarOEliminarProductoAjustado("tomate", opcion, prA);
							}
							else if (ing == 3) {
								
								agregarOEliminarProductoAjustado("cebolla", opcion, prA);
							}
							else if (ing == 4) {
								
								agregarOEliminarProductoAjustado("queso mozzarella", opcion, prA);
							}
							else if (ing == 5) {
								
								agregarOEliminarProductoAjustado("huevo", opcion, prA);
							}
							else if (ing == 6) {
								
								agregarOEliminarProductoAjustado("queso americano", opcion, prA);
							}
							else if (ing == 7) {
								
								agregarOEliminarProductoAjustado("tocineta express", opcion, prA);
							}
							else if (ing == 8) {
								
								agregarOEliminarProductoAjustado("papa callejera", opcion, prA);
							}
							else if (ing == 9) {
								
								agregarOEliminarProductoAjustado("pepinillos", opcion, prA);
							}
							else if (ing == 10) {
								
								agregarOEliminarProductoAjustado("cebolla grille", opcion, prA);
							}
							else if (ing == 11) {
								
								agregarOEliminarProductoAjustado("suero costeño", opcion, prA);
							}
							else if (ing == 12) {
								
								agregarOEliminarProductoAjustado("frijol refrito", opcion, prA);
							}
							else if (ing == 13) {
								
								agregarOEliminarProductoAjustado("queso fundido", opcion, prA);
							}
							else if (ing == 14) {
								
								agregarOEliminarProductoAjustado("tocineta picada", opcion, prA);
							}
							else if (ing == 15) {
								
								agregarOEliminarProductoAjustado("piña", opcion, prA);
							}
						}
						else if (opcion == 3) {
							sentinela = false;
						}
						
					}
					catch(NumberFormatException e){
						System.out.println("Debe seleccionar uno de los números de las opciones.");
					}
				}
				
				Pedido pEnCurso = restaurante.getPedidoEnCurso();
				pEnCurso.agregarProducto(prA);
				System.out.println("\nEl producto ajustado se ha agregado exitosamente.");
				 
			}
		}
		else if (opcionSeleccionada ==4) {
			System.out.println("\nCerrando el pedido y guardando la factura.\n");
			restaurante.cerrarYGuardarPedido();
			
		}
		else if (opcionSeleccionada ==5) {
			
			Pedido buscarPedido = null;
			System.out.println("\n----- Buscar Pedido -----\n");
			int idPedido = Integer.parseInt(input("Por favor introduzca el ID del pedido quiere buscar: "));
			System.out.println("Buscando el pedido...");
			
			ArrayList<Pedido> pedidos = restaurante.getPedidos();
			
			for (Pedido p : pedidos) {
				System.out.println(p.getIdPedido());
				if (p.getIdPedido() == idPedido) { 
					buscarPedido = p;
				}
			}
			if (buscarPedido != null) {
				System.out.println("Su pedido es: " + buscarPedido.getIdPedido()
				+ "\n" + buscarPedido.generarTextoFactura());
			}
			else {
				System.out.println("Su pedido no ha sido encontrado.");
			}
		}
			
	}
	public ProductoAjustado crearProdAjustado(int prod) {
		
		ArrayList<ProductoMenu> menu = new ArrayList<>();
		menu = restaurante.getMenuBase();
		ProductoAjustado retorno = null;
		
		if (prod == 1) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("corral")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 2) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("corral queso")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 3) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("corral pollo")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 4) {

			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("corralita")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 5) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("todoterreno")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 6) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("1/2 libra")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 7) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("especial")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 8) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("casera")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 9) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("mexicana")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 10) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("criolla")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 11) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("costeña")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 12) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("hawaiana")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 13) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("wrap de pollo")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 14) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("wrap de lomo")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 15) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("ensalada mexicana")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 16) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("papas medianas")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 17) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("papas grandes")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 18) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("papas en casco medianas")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		else if (prod == 19) {
			
			for(ProductoMenu base : menu) {
				if(base.getNombre().equals("papas en casco grandes")) {
					
					ProductoAjustado pA = new ProductoAjustado(base);
					retorno = pA;	
				}
			}
		}
		
		return retorno;
	}
	
	public void agregarCombo(String nombre) {
		
		ArrayList<Combo> combos = new ArrayList<>();
		combos = restaurante.getCombos();
		
		for(Combo comb : combos) {

			if((comb.getNombre()).equals(nombre)) {
				Pedido pEnCurso = restaurante.getPedidoEnCurso();
				pEnCurso.agregarProducto(comb);
				System.out.println("\nEl combo se ha agregado exitosamente.");
			}
		}
	}
	public void agregarProductoMenu(String nombre) {
		
		ArrayList<ProductoMenu> menu = new ArrayList<>();
		menu = restaurante.getMenuBase();
		
		for(ProductoMenu base : menu) {
			if(base.getNombre().equals(nombre)) {
				Pedido pEnCurso = restaurante.getPedidoEnCurso();
				pEnCurso.agregarProducto(base);
				System.out.println("\nEl producto se ha agregado exitosamente.");
			}
		}
	}
	public void agregarBebida(String nombre) {
		
		ArrayList<ProductoMenu> bebidas = new ArrayList<>();
		bebidas = restaurante.getBebidas();
		
		for (ProductoMenu bebida : bebidas) {
			if(bebida.getNombre().equals(nombre)) {
				Pedido pEnCurso = restaurante.getPedidoEnCurso();
				pEnCurso.agregarProducto(bebida);
				System.out.println("\nLa bebida se ha agregado exitosamente.");
			}
		}
	}
	public void agregarOEliminarProductoAjustado(String nombre, int opcion, ProductoAjustado prA) {
		
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes = restaurante.getIngredientes();
		
		//Agregar ingrediente
		if (opcion == 1) {
			
			for (Ingrediente ing : ingredientes) {
				if(ing.getNombre().equals(nombre)) {
					prA.agregarIngrediente(ing);
					
				}
			}
		}
		
		//Eliminar ingrediente
		if (opcion == 2) {
			
			for (Ingrediente ing : ingredientes) {
				if(ing.getNombre().equals(nombre)) {
					prA.eliminarIngrediente(ing);
				}
			}
		}
	}

	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();

	}

}
