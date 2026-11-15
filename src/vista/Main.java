package vista;

import controlador.SistemaTurnos;
import java.util.Scanner;
import modelo.Solicitud;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static SistemaTurnos sistema = new SistemaTurnos();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerNumero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    consultarSiguiente();
                    break;
                case 3:
                    atender();
                    break;
                case 4:
                    sistema.mostrarPendientes();
                    break;
                case 5:
                    System.out.println("Solicitudes pendientes: " + sistema.obtenerCantidadPendiente());
                    break;
                case 6:
                    if (sistema.estaVacia()) {
                        System.out.println("La cola está vacía");
                    } else {
                        System.out.println("La cola contiene solicitudes pendientes");
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("SISTEMA DE TURNOS - SOPORTE TÉCNICO");
        System.out.println("1. Registrar solicitud");
        System.out.println("2. Consultar siguiente solicitud");
        System.out.println("3. Atender solicitud");
        System.out.println("4. Mostrar solicitudes pendientes");
        System.out.println("5. Consultar cantidad de solicitudes");
        System.out.println("6. Comprobar si la cola está vacía");
        System.out.println("0. Salir");
    }

    private static void registrar() {
        System.out.println();
        System.out.println("REGISTRO DE SOLICITUD");
        String nombre = leerTexto("Nombre del estudiante o usuario: ");
        String tipo = leerTexto("Tipo de incidencia (hardware, software, red o plataforma): ");
        String descripcion = leerTexto("Descripción breve del problema: ");

        if (sistema.registrarSolicitud(nombre, tipo, descripcion)) {
            System.out.println("Solicitud registrada correctamente.");
        } else {
            System.out.println("No se pudo registrar, cola llena");
        }
    }

    private static void consultarSiguiente() {
        Solicitud solicitud = sistema.consultarSiguiente();

        if (solicitud == null) {
            System.out.println("No hay solicitudes para consultar.");
        } else {
            System.out.println("Siguiente solicitud:");
            System.out.println(solicitud);
        }
    }

    private static void atender() {
        Solicitud solicitud = sistema.atenderSolicitud();

        if (solicitud == null) {
            System.out.println("No hay solicitudes pendientes para atender.");
        } else {
            System.out.println("Solicitud atendida:");
            System.out.println(solicitud);
        }
    }

    private static String leerTexto(String mensaje) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = entrada.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Este dato no puede quedar vacío");
            }
        } while (texto.isEmpty());

        return texto;
    }

    private static int leerNumero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número válido");
            }
        }
    }
}
