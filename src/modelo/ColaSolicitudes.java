package modelo;

public class ColaSolicitudes {
    private Solicitud[] elementos;
    private int cantidad;

    public ColaSolicitudes() {
        elementos = new Solicitud[100];
        cantidad = 0;
    }

    // Agrega una solicitud al final de la cola.
    public boolean enqueue(Solicitud solicitud) {
        if (cantidad == elementos.length) {
            return false;
        }

        elementos[cantidad] = solicitud;
        cantidad++;
        return true;
    }

    // Consulta el primer elemento sin retirarlo.
    public Solicitud front() {
        if (isEmpty()) {
            return null;
        }

        return elementos[0];
    }

    // Retira el primer elemento y recorre los demás lugares.
    public Solicitud dequeue() {
        if (isEmpty()) {
            return null;
        }

        Solicitud atendida = elementos[0];

        for (int i = 0; i < cantidad - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[cantidad - 1] = null;
        cantidad--;

        return atendida;
    }

    public boolean isEmpty() {
        return cantidad == 0;
    }

    public int size() {
        return cantidad;
    }

    public void mostrarSolicitudes() {
        if (isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println(elementos[i]);
        }
    }
}
