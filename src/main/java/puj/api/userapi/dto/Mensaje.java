package puj.api.userapi.dto;

/**
 * Clase de mensaje para enviarlo en solicitudes
 */
public class Mensaje {
    private String mensaje;

    /**
     * Constructor de la clase mensaje
     * @param mensaje parametro string para representar el mensaje
     */
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}