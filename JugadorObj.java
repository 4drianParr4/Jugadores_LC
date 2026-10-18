public class JugadorObj {
    private String nombre;
    private int puntos;
    private JugadorObj siguiente;

    public JugadorObj(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public JugadorObj getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(JugadorObj siguiente) {
        this.siguiente = siguiente;
    }
}
