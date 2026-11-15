package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitud {
    private int numeroTurno;
    private String nombre;
    private String tipoIncidencia;
    private LocalDateTime horaRegistro;
    private String descripcion;
    private String estado;

    public Solicitud(int numeroTurno, String nombre, String tipoIncidencia, String descripcion) {
        this.numeroTurno = numeroTurno;
        this.nombre = nombre;
        this.tipoIncidencia = tipoIncidencia;
        this.horaRegistro = LocalDateTime.now();
        this.descripcion = descripcion;
        this.estado = "Pendiente";
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void atender() {
        estado = "Atendida";
    }

    public String getHoraRegistro() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return horaRegistro.format(formato);
    }

    @Override
    public String toString() {
        return "Turno: " + numeroTurno
                + "Usuario: " + nombre
                + "Incidencia: " + tipoIncidencia
                + "Registro: " + getHoraRegistro()
                + "Descripción: " + descripcion
                + "Estado: " + estado;
    }
}
