/*
3e * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import adapter.Usuario;
import composite.Calle;
import composite.Componente;
import decorator.Component;
import decorator.Pago;
import decorator.PagosPSEBanco;
import facade.Facade;

/**
 *
 * @author Andrés
 */
public class Arquitectura {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		String nombre;
		String correo;
		String contrasena;
		String documento;
		int opcion = 0;

		Facade facade = new Facade();
		// LLenado de arreglos
		facade.usuariosDummy();
		facade.rutasDummy();
		facade.reservasDummy();

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"" + "Seleccione la opci�n: \n" + "1. Registrar usuario \n" + "2. Modificar usuario \n"
							+ "3. Eliminar usuario \n" + "4. Acceder al sistema \n" + "0. Salir"));
			switch (opcion) {
			case 1:
				int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				switch (opcion1) {
				case 1:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					documento = JOptionPane.showInputDialog("Introducir documento");
					facade.registrarPasajero(nombre, documento, correo, contrasena);
					break;
				case 2:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					documento = JOptionPane.showInputDialog("Introducir documento");
					facade.registrarConductor(nombre, documento, correo, contrasena);
					break;
				case 3:
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					documento = JOptionPane.showInputDialog("Introducir documento");
					facade.registrarAdministrador(nombre, documento, correo, contrasena);
					break;
				case 4:
				}
				break;
			case 2:
				int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
						"" + "1. Pasajero \n" + "2. Conductor \n" + "3. Administrador \n" + "4. Regresar"));
				switch (opcion2) {
				case 1:
					JOptionPane.showMessageDialog(null, facade.obtenerUsuarios());
					documento = JOptionPane.showInputDialog("Introduce el documento del pasajero a modificar");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					facade.modificarPasajero(nombre, documento, correo, contrasena);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, facade.obtenerUsuarios());
					documento = JOptionPane.showInputDialog("Introduce el documento del conductor a modificar");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					facade.modificarConductor(nombre, documento, correo, contrasena);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, facade.obtenerUsuarios());
					documento = JOptionPane.showInputDialog("Introduce el documento del administrador a modificar");
					nombre = JOptionPane.showInputDialog("Introducir nombre");
					correo = JOptionPane.showInputDialog("Introducir correo");
					contrasena = JOptionPane.showInputDialog("Introducir contrase�a");
					facade.modificarAdministrador(nombre, documento, correo, contrasena);
					break;
				case 4:
				}
				break;
			case 3:
				System.out.println(facade.obtenerUsuarios());
				documento = JOptionPane.showInputDialog(null, "Introduce el documento del usuario a eliminar");
				facade.eliminarUsuario(documento);
				break;
			case 4:
				correo = JOptionPane.showInputDialog("Introducir correo");
				contrasena = JOptionPane.showInputDialog("Introducir contrasena");
				Usuario usuario = facade.obtenerUsuario(correo, contrasena);
				System.out.println(usuario);
				int tipoUsuario = facade.verificarUsuario(correo, contrasena);
				switch (tipoUsuario) {
				case 1:
					// Pasajero
					do {
						opcion = Integer.parseInt(JOptionPane.showInputDialog("" + "1. Crear registro de reserva \n"
								+ "2. Listar reservas \n" + "3. Modificar reserva \n" + "4. Eliminar reserva \n"
								+ "5. Realizar pago \n" + "6. Ver pagos \n" + "0. salir \n"));
						switch (opcion) {
						case 1:
							// Crear registro reserva
							String nombreReserva = "Reserva " + usuario.hashCode();
							String nombreRutaReservada = JOptionPane
									.showInputDialog("Introducir nombre de ruta a reservar");
							int puestoRutaReservada = Integer
									.parseInt(JOptionPane.showInputDialog("Introducir puesto a reservar"));
							facade.crearRegistroReserva(nombreReserva, nombreRutaReservada, puestoRutaReservada,
									usuario.getDocumento());

							break;
						case 2:
							// Listar reservas
							JOptionPane.showMessageDialog(null, facade.listarReservasPasajero(usuario.getDocumento()));
							break;
						case 3:
							// Modificar reserva ponerle id a reserva

							// Listar las reservas
							String nombreReservaModificar = JOptionPane
									.showInputDialog("Introducir nombre de reserva a modificar\n"
											+ facade.listarReservasPas(usuario.getDocumento()));

							// String lugarOrigenModificado = JOptionPane.showInputDialog("Introducir lugar
							// origen");
							// String lugarDestinoModificado = JOptionPane.showInputDialog("Introducir lugar
							// destino");
							String nombreRutaReservadaModificado = JOptionPane
									.showInputDialog("Introducir nombre de ruta a reservar");
							int puestoRutaReservadaModificado = Integer
									.parseInt(JOptionPane.showInputDialog("Introducir puesto a reservar"));

							facade.modificarReservaPasajero(nombreReservaModificar, nombreRutaReservadaModificado,
									puestoRutaReservadaModificado, usuario.getDocumento());
							break;
						case 4:
							// Eliminar reserva
							String nombreReservaEliminar = JOptionPane
									.showInputDialog("Introducir nombre de reserva a eliminar");
							facade.eliminarReserva(nombreReservaEliminar, usuario.getDocumento());
							break;
						case 5:
							String parametrosPago = JOptionPane.showInputDialog("Introducir valor de pago");
							parametrosPago += "," + usuario.getDocumento();
							parametrosPago += "," + JOptionPane.showInputDialog("Introducir documento del conductor");
							opcion = Integer.parseInt(JOptionPane
									.showInputDialog("1. Pago PSE por entidad bancaria \n 2. Pago PSE por tarjeta"));
							switch (opcion) {
							case 1:
								// Pago por banco
								parametrosPago += "," + JOptionPane.showInputDialog("Introducir n�mero de cuenta");
								parametrosPago += "," + JOptionPane.showInputDialog("Introducir contrase�a de cuenta");
								if (JOptionPane.showConfirmDialog(null, "�Realizar Pago?") == JOptionPane.YES_OPTION) {
									parametrosPago += ",True";
								} else {
									parametrosPago += ",False";
								}
								facade.registrarPago(parametrosPago);
								break;
							case 2:
								// Pago por tarjeta
								//TODO Robinson
								parametrosPago += "," + JOptionPane.showInputDialog(null, "Introduce el numero de tarjeta.");
								parametrosPago += "," + JOptionPane.showInputDialog(null, "Introduce el codigo de seguridad");
								parametrosPago += "," + JOptionPane.showInputDialog(null, "Introduce la fecha de vencimiento (yyyy/MM/dd)");
								
								
								//parametrosPago += (JOptionPane.showConfirmDialog(null, "� Realizar Pago ?") == JOptionPane.YES_OPTION ? ",True": ",False");
								if(JOptionPane.showConfirmDialog(null, "� Realizar Pago ?") == JOptionPane.YES_OPTION)
								{
									parametrosPago += ",True";
								}else
								{
									parametrosPago += ",False";
								}
								facade.registrarPagoTarjeta(parametrosPago);
								break;
							}
							break;
						case 6:
							JOptionPane.showMessageDialog(null, facade.obtenerPagos());
							break;
						case 0:
							break;
						}
					} while (opcion != 0);

					break;
				case 2:
					// Conductor
					do {
						opcion = Integer
								.parseInt(JOptionPane.showInputDialog("" + "1. Crear ruta \n" + "2. Listar rutas \n"
										+ "3. Modificar ruta \n" + "4. Eliminar ruta \n" + "0. Salir \n"));
						boolean agregarCalle;
						switch (opcion) {
						case 1:
							// Crear registro ruta
							String nombreRuta = JOptionPane.showInputDialog("Introducir nombre de ruta");
							ArrayList<Componente> calles = new ArrayList<Componente>();
							agregarCalle = true;
							while (agregarCalle) {
								String nombreCalle = JOptionPane.showInputDialog("Introducir nombre de calle");
								String distanciaCalle = JOptionPane.showInputDialog("Introducir distancia de calle");
								String coordenadaXOrigenCalle = JOptionPane
										.showInputDialog("Introducir coordenada X de Origen");
								String coordenadaYOrigenCalle = JOptionPane
										.showInputDialog("Introducir coordenada Y de Origen");
								String coordenadaXDestinoCalle = JOptionPane
										.showInputDialog("Introducir coordenada X de Destino");
								String coordenadaYDestinoCalle = JOptionPane
										.showInputDialog("Introducir coordenada Y de Destino");
								Componente calle = new Calle(coordenadaXOrigenCalle, coordenadaYOrigenCalle,
										coordenadaXDestinoCalle, coordenadaYDestinoCalle, nombreCalle, distanciaCalle);
								calles.add(calle);
								int option = JOptionPane.showConfirmDialog(null, "�Deseas agregar otra calle?");
								if (option == JOptionPane.NO_OPTION) {
									// Si se seleccion� en no agregar otra calle
									agregarCalle = false;
								}
							}
							facade.crearRegistroRuta(nombreRuta, calles, usuario.getDocumento());
							break;
						case 2:
							// Listar rutas
							JOptionPane.showMessageDialog(null, facade.listarRutasConductor(usuario.getDocumento()));
							break;
						case 3:
							// Modificar ruta
							String nombreRutaModificar = JOptionPane
									.showInputDialog("Introducir nombre de ruta a modificar");
							String nombreRutaNuevo = JOptionPane.showInputDialog("Introducir nuevo nombre de ruta");
							ArrayList<Componente> callesModificadas = new ArrayList<Componente>();
							agregarCalle = true;
							while (agregarCalle) {
								String nombreCalle = JOptionPane.showInputDialog("Introducir nombre de calle");
								String distanciaCalle = JOptionPane.showInputDialog("Introducir distancia de calle");
								String coordenadaXOrigenCalle = JOptionPane
										.showInputDialog("Introducir coordenada X de Origen");
								String coordenadaYOrigenCalle = JOptionPane
										.showInputDialog("Introducir coordenada Y de Origen");
								String coordenadaXDestinoCalle = JOptionPane
										.showInputDialog("Introducir coordenada X de Destino");
								String coordenadaYDestinoCalle = JOptionPane
										.showInputDialog("Introducir coordenada Y de Destino");
								Componente calle = new Calle(coordenadaXOrigenCalle, coordenadaYOrigenCalle,
										coordenadaXDestinoCalle, coordenadaYDestinoCalle, nombreCalle, distanciaCalle);
								callesModificadas.add(calle);
								int option = JOptionPane.showConfirmDialog(null, "�Deseas agregar otra calle?");
								if (option == JOptionPane.NO_OPTION) {
									// Si se seleccion� en no agregar otra calle
									agregarCalle = false;
								}
							}
							facade.actualizarRuta(nombreRutaModificar, nombreRutaNuevo, callesModificadas,
									usuario.getDocumento());
							break;
						case 4:
							String nombreRutaEliminar = JOptionPane
									.showInputDialog(facade.listarRutasConductor(usuario.getDocumento()) + " \n\n"
											+ " Introducir nombre de ruta a eliminar");
							facade.eliminarRuta(nombreRutaEliminar, usuario.getDocumento());
							break;
						case 0:
							break;
						}
					} while (opcion != 0);
					break;
				}
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				break;
			}
		} while (opcion != 0);

	}

}
