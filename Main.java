import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        boolean continuar = true;
        int opcion;
        String nombre;
        String nombreNuevo;
        String respuesta;
        int posicion;
        int puntos;

        while (continuar == true) {
            System.out.println("\n===== JUEGO POR TURNOS =====");
            System.out.println("1) Insertar jugador al final");
            System.out.println("2) Insertar jugador al principio");
            System.out.println("3) Insertar jugador en medio");
            System.out.println("4) Buscar jugador");
            System.out.println("5) Modificar jugador");
            System.out.println("6) Jugar un turno");
            System.out.println("7) Ver jugadores");
            System.out.println("8) Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del jugador: ");
                    nombre = sc.next();
                    respuesta = m.insertarAlFinal(nombre);
                    System.out.println(respuesta);
                    break;

                case 2:
                    System.out.print("Nombre del jugador: ");
                    nombre = sc.next();
                    respuesta = m.insertarAlPrincipio(nombre);
                    System.out.println(respuesta);
                    break;

                case 3:
                    System.out.print("Nombre del jugador: ");
                    nombre = sc.next();
                    System.out.print("En que posicion lo quieres insertar: ");
                    posicion = sc.nextInt();
                    respuesta = m.insertarEnMedio(nombre, posicion);
                    System.out.println(respuesta);
                    break;

                case 4:
                    System.out.print("Nombre del jugador a buscar: ");
                    nombre = sc.next();
                    respuesta = m.buscarJugador(nombre);
                    System.out.println(respuesta);
                    break;

                case 5:
                    System.out.print("Nombre del jugador a modificar: ");
                    nombre = sc.next();
                    System.out.print("Nuevo nombre: ");
                    nombreNuevo = sc.next();
                    System.out.print("Nuevos puntos: ");
                    puntos = sc.nextInt();
                    respuesta = m.modificarJugador(nombre, nombreNuevo, puntos);
                    System.out.println(respuesta);
                    break;

                case 6:
                    System.out.print("Puntos ganados en este turno: ");
                    puntos = sc.nextInt();
                    respuesta = m.jugarTurno(puntos);
                    System.out.println(respuesta);
                    break;

                case 7:
                    m.verJugadores();
                    break;

                case 8:
                    System.out.println("Hasta luego!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}