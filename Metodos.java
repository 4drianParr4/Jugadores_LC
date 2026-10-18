public class Metodos {
    private JugadorObj primero = null;
    private JugadorObj ultimo = null;
    private JugadorObj turno = null;
    private int cantidad = 0;

    public String insertarAlFinal(String nombre) {
        JugadorObj nuevo = new JugadorObj(nombre);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
            turno = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            ultimo = nuevo;
        }

        cantidad = cantidad + 1;
        return "Jugador insertado al final.";
    }

    public String insertarAlPrincipio(String nombre) {
        JugadorObj nuevo = new JugadorObj(nombre);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
            turno = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        }

        cantidad = cantidad + 1;
        return "Jugador insertado al principio.";
    }

    public String insertarEnMedio(String nombre, int posicion) {
        String mensaje;

        if (posicion < 1 || posicion > cantidad + 1) {
            mensaje = "Posicion no valida.";
        } else if (posicion == 1) {
            mensaje = insertarAlPrincipio(nombre);
        } else if (posicion == cantidad + 1) {
            mensaje = insertarAlFinal(nombre);
        } else {
            JugadorObj nuevo = new JugadorObj(nombre);
            JugadorObj anterior = primero;

            for (int i = 1; i < posicion - 1; i++) {
                anterior = anterior.getSiguiente();
            }

            nuevo.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(nuevo);

            cantidad = cantidad + 1;
            mensaje = "Jugador insertado en la posicion " + posicion + ".";
        }

        return mensaje;
    }

    public String buscarJugador(String nombre) {
        String mensaje = "No se encontro al jugador.";
        JugadorObj actual = primero;

        for (int i = 0; i < cantidad; i++) {
            if (actual.getNombre().equalsIgnoreCase(nombre)) {
                mensaje = actual.getNombre() + " esta en la posicion " + (i + 1)
                        + " con " + actual.getPuntos() + " puntos.";
            }
            actual = actual.getSiguiente();
        }

        return mensaje;
    }

    public String modificarJugador(String nombreActual, String nombreNuevo, int puntosNuevos) {
        String mensaje = "No se encontro al jugador.";
        JugadorObj actual = primero;

        for (int i = 0; i < cantidad; i++) {
            if (actual.getNombre().equalsIgnoreCase(nombreActual)) {
                actual.setNombre(nombreNuevo);
                actual.setPuntos(puntosNuevos);
                mensaje = "Jugador modificado: " + actual.getNombre()
                        + " con " + actual.getPuntos() + " puntos.";
            }
            actual = actual.getSiguiente();
        }

        return mensaje;
    }

    public String jugarTurno(int puntos) {
        String mensaje;

        if (turno == null) {
            mensaje = "No hay jugadores registrados.";
        } else {
            turno.setPuntos(turno.getPuntos() + puntos);
            mensaje = turno.getNombre() + " gano " + puntos
                    + " puntos. Total: " + turno.getPuntos();
            turno = turno.getSiguiente();
        }

        return mensaje;
    }

    public void verJugadores() {
        if (primero == null) {
            System.out.println("No hay jugadores registrados.");
        } else {
            JugadorObj actual = primero;

            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + actual.getNombre()
                        + " - Puntos: " + actual.getPuntos());
                actual = actual.getSiguiente();
            }

            System.out.println("Le toca a: " + turno.getNombre());
        }
    }
}
