package controlador;

import modelo.ColaSolicitudes;
import modelo.Solicitud;

public class SistemaTurnos {
    private ColaSolicitudes cola;
    private int siguienteTurno;

    public SistemaTurnos() {
        cola = new ColaSolicitudes();
        siguienteTurno = 1;
    }

    public boolean registrarSolicitud(String nombre, String tipo, String descripcion) {
        Solicitud solicitud = new Solicitud(siguienteTurno, nombre, tipo, descripcion);

        if (cola.enqueue(solicitud)) {
            siguienteTurno++;
            return true;
        }

        return false;
    }

    public Solicitud consultarSiguiente() {
        return cola.front();
    }

    public Solicitud atenderSolicitud() {
        Solicitud solicitud = cola.dequeue();

        if (solicitud != null) {
            solicitud.atender();
        }

        return solicitud;
    }

    public void mostrarPendientes() {
        cola.mostrarSolicitudes();
    }

    public int obtenerCantidadPendiente() {
        return cola.size();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
