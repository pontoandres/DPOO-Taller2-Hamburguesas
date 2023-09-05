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
			ArrayList<Combo> combo = new ArrayList<>();
			ArrayList<ProductoMenu> menu = new ArrayList<>();
			
			System.out.println("\n------ Menu Combos ------\n");
			System.out.println("Nombre Combo : Precio\n");
			
			int i = 1;
			combo = restaurante.getCombos();
			for (Combo comb : combo) {
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
			
		}
		else if (opcionSeleccionada == 3) {
			
			System.out.println("\n------ Tipos de Productos ------\n");
			System.out.println("1. Combo\n"
					+ "2. Producto del Menu Base\n"
					+ "3. Producto Ajustado (Productos del menu base al que se les ha agregado/ eliminado ingredientes\n");
			
			int tipo = Integer.parseInt(input("Por favor digite el numero del tipo de Producto que desea agreagar a su pedido: "));
			
			if (tipo == 1 ) {
				int opcion = Integer.parseInt(input("Por favor digite el numero del Combo que desea agregar a su pedido: "));
				
				if (opcion == 1) {
					Combo c = new Combo("combo corral", 0.1);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(c);
					System.out.println("El combo se ha agregado exitosamente.");
				} 
				else if(opcion == 2){
					Combo c = new Combo("combo corral queso", 0.1);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(c);
					System.out.println("El combo se ha agregado exitosamente.");
				}
				else if(opcion == 3){
					Combo c = new Combo("combo todoterreno", 0.07);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(c);
					System.out.println("El combo se ha agregado exitosamente.");
				}
				else if(opcion == 4){
					Combo c = new Combo("combo especial", 0.07);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(c);
					System.out.println("El combo se ha agregado exitosamente.");
				}
			} else if(tipo == 2) {
				
				int opcion = Integer.parseInt(input("Por favor digite el numero del Producto Base que desea agregar a su pedido: "));
				
				if (opcion == 1) {
					ProductoMenu p = new ProductoMenu("corral", 14000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 2) {
					ProductoMenu p = new ProductoMenu("corral queso", 16000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 3) {
					ProductoMenu p = new ProductoMenu("corral pollo", 15000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 4) {
					ProductoMenu p = new ProductoMenu("corralita", 13000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 5) {
					ProductoMenu p = new ProductoMenu("todoterreno", 25000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 6) {
					ProductoMenu p = new ProductoMenu("1/2 libra", 25000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 7) {
					ProductoMenu p = new ProductoMenu("especial", 24000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 8) {
					ProductoMenu p = new ProductoMenu("casera", 23000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 9) {
					ProductoMenu p = new ProductoMenu("mexicana", 22000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 10) {
					ProductoMenu p = new ProductoMenu("criolla", 22000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 11) {
					ProductoMenu p = new ProductoMenu("costeña", 20000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 12) {
					ProductoMenu p = new ProductoMenu("hawaiana", 20000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 13) {
					ProductoMenu p = new ProductoMenu("wrap de pollo", 15000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 14) {
					ProductoMenu p = new ProductoMenu("wrap de lomo", 22000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 15) {
					ProductoMenu p = new ProductoMenu("ensalada mexicana", 20900);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 16) {
					ProductoMenu p = new ProductoMenu("papas medianas", 5500);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 17) {
					ProductoMenu p = new ProductoMenu("papas grandes", 6900);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 18) {
					ProductoMenu p = new ProductoMenu("papas en casco medianas", 5500);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 19) {
					ProductoMenu p = new ProductoMenu("papas en casco grandes", 6900);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 20) {
					ProductoMenu p = new ProductoMenu("agua cristal sin gas", 5000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 21) {
					ProductoMenu p = new ProductoMenu("agua cristal con gas", 5000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
				else if (opcion == 22) {
					ProductoMenu p = new ProductoMenu("gaseosa", 5000);
					Pedido pEnCurso = restaurante.getPedidoEnCurso();
					pEnCurso.agregarProducto(p);
					System.out.println("El producto se ha agregado exitosamente.");
				}
			} else if(tipo == 3){
				
				int prod = Integer.parseInt(input("Por favor digite el numero del Producto Base que desea modificar: "));
				
				ProductoAjustado prA = crearProdAjustado(prod);
				
				System.out.println("\nLe gustaria agregar o eliminar un elemento a su pedido?\n"
						+ "1.Agregar.\n"
						+ "2.Eliminar.");
				int opcion = Integer.parseInt(input("Por favor digite el numero: "));
				
				if (opcion == 1) {
					int ing = Integer.parseInt(input("Por favor digite el numero del Ingrediente que desea agregar a su pedido: "));
					
					if (ing == 1) {
						Ingrediente i = new Ingrediente("lechuga", 1000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 2) {
						Ingrediente i = new Ingrediente("tomate", 1000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 3) {
						Ingrediente i = new Ingrediente("cebolla", 1000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 4) {
						Ingrediente i = new Ingrediente("queso mozzarella", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 5) {
						Ingrediente i = new Ingrediente("huevo", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 6) {
						Ingrediente i = new Ingrediente("queso americano", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 7) {
						Ingrediente i = new Ingrediente("tocineta express", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 8) {
						Ingrediente i = new Ingrediente("papa callejera", 2000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 9) {
						Ingrediente i = new Ingrediente("pepinillos", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 10) {
						Ingrediente i = new Ingrediente("cebolla grille", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 11) {
						Ingrediente i = new Ingrediente("suero costeño", 3000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 12) {
						Ingrediente i = new Ingrediente("frijol refrito", 4500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 13) {
						Ingrediente i = new Ingrediente("queso fundido", 4500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 14) {
						Ingrediente i = new Ingrediente("tocineta picada", 6000);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 15) {
						Ingrediente i = new Ingrediente("piña", 2500);
						prA.agregarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
				}
				else if (opcion ==2) {
					int ing = Integer.parseInt(input("Por favor digite el numero del Ingrediente que desea agregar a su pedido: "));
					
					if (ing == 1) {
						Ingrediente i = new Ingrediente("lechuga", 1000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 2) {
						Ingrediente i = new Ingrediente("tomate", 1000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 3) {
						Ingrediente i = new Ingrediente("cebolla", 1000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 4) {
						Ingrediente i = new Ingrediente("queso mozzarella", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 5) {
						Ingrediente i = new Ingrediente("huevo", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 6) {
						Ingrediente i = new Ingrediente("queso americano", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 7) {
						Ingrediente i = new Ingrediente("tocineta express", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 8) {
						Ingrediente i = new Ingrediente("papa callejera", 2000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 9) {
						Ingrediente i = new Ingrediente("pepinillos", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 10) {
						Ingrediente i = new Ingrediente("cebolla grille", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 11) {
						Ingrediente i = new Ingrediente("suero costeño", 3000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 12) {
						Ingrediente i = new Ingrediente("frijol refrito", 4500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 13) {
						Ingrediente i = new Ingrediente("queso fundido", 4500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 14) {
						Ingrediente i = new Ingrediente("tocineta picada", 6000);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
					else if (ing == 15) {
						Ingrediente i = new Ingrediente("piña", 2500);
						prA.eliminarIngrediente(i);
						Pedido pEnCurso = restaurante.getPedidoEnCurso();
						pEnCurso.agregarProducto(prA);
						System.out.println("El producto se ha modificado y agregado exitosamente.");
					}
				}
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
		ProductoAjustado retorno = null;
		
		if (prod == 1) {
			ProductoMenu p = new ProductoMenu("corral", 14000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 2) {
			ProductoMenu p = new ProductoMenu("corral queso", 16000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 3) {
			ProductoMenu p = new ProductoMenu("corral pollo", 15000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 4) {
			ProductoMenu p = new ProductoMenu("corralita", 13000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 5) {
			ProductoMenu p = new ProductoMenu("todoterreno", 25000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 6) {
			ProductoMenu p = new ProductoMenu("1/2 libra", 25000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 7) {
			ProductoMenu p = new ProductoMenu("especial", 24000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 8) {
			ProductoMenu p = new ProductoMenu("casera", 23000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 9) {
			ProductoMenu p = new ProductoMenu("mexicana", 22000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 10) {
			ProductoMenu p = new ProductoMenu("criolla", 22000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 11) {
			ProductoMenu p = new ProductoMenu("costeña", 20000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 12) {
			ProductoMenu p = new ProductoMenu("hawaiana", 20000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 13) {
			ProductoMenu p = new ProductoMenu("wrap de pollo", 15000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 14) {
			ProductoMenu p = new ProductoMenu("wrap de lomo", 22000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 15) {
			ProductoMenu p = new ProductoMenu("ensalada mexicana", 20900);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 16) {
			ProductoMenu p = new ProductoMenu("papas medianas", 5500);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 17) {
			ProductoMenu p = new ProductoMenu("papas grandes", 6900);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 18) {
			ProductoMenu p = new ProductoMenu("papas en casco medianas", 5500);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 19) {
			ProductoMenu p = new ProductoMenu("papas en casco grandes", 6900);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 20) {
			ProductoMenu p = new ProductoMenu("agua cristal sin gas", 5000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 21) {
			ProductoMenu p = new ProductoMenu("agua cristal con gas", 5000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
		}
		else if (prod == 22) {
			ProductoMenu p = new ProductoMenu("gaseosa", 5000);
			ProductoAjustado pA = new ProductoAjustado(p);
			retorno = pA;
			
		}
		
		return retorno;
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
