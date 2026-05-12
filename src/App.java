import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        char[][] sala = new char[5][8];
        Scanner sc = new Scanner(System.in);
        
        inicializarSala(sala);

        int opcion;
        do {
            opcion = mostrarMenuYLeerOpcion(sc);
            
            switch (opcion) {
                case 1:
                    mostrarSala(sala);
                    break;
                case 2:
                    reservarAsiento(sala, sc);
                    break;
                case 3:
                    liberarAsiento(sala, sc);
                    break;
                case 4:
                    mostrarDisponibilidad(sala);
                    break;
                case 5:
                    System.out.println("¡Esperamos que vuelva!");
                    break;
            }
        } while (opcion != 5);
        
        sc.close();
    }


    private static void inicializarSala(char[][] sala) {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = 'O';
            }
        }
    }

    private static int mostrarMenuYLeerOpcion(Scanner sc) {
        System.out.println("\n--- MENÚ DEL CINE ---");
        System.out.println("1 - Mostrar sala");
        System.out.println("2 - Reservar asiento");
        System.out.println("3 - Liberar asiento");
        System.out.println("4 - Mostrar disponibilidad");
        System.out.println("5 - Salir");
        System.out.print("Introduce una opción: ");
        
        int opcion = sc.nextInt();
        while (opcion < 1 || opcion > 5) {
            System.out.print("Elige una opción válida (1-5): ");
            opcion = sc.nextInt();
        }
        return opcion;
    }

    private static void mostrarSala(char[][] sala) {
        System.out.println("\n--- ESTADO DE LA SALA ---");
        for (int i = 0; i < sala.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void reservarAsiento(char[][] sala, Scanner sc) {
        int fila = pedirFila(sc);
        int columna = pedirColumna(sc);

        // Acceso directo a la matriz en lugar de recorrerla con bucles
        if (sala[fila - 1][columna - 1] == 'O') {
            sala[fila - 1][columna - 1] = 'X';
            System.out.println("Asiento reservado con éxito.");
        } else {
            System.out.println("Error: Ese asiento ya está reservado.");
        }
    }

    private static void liberarAsiento(char[][] sala, Scanner sc) {
        int fila = pedirFila(sc);
        int columna = pedirColumna(sc);

        // Acceso directo a la matriz
        if (sala[fila - 1][columna - 1] == 'X') {
            sala[fila - 1][columna - 1] = 'O';
            System.out.println("Asiento liberado con éxito.");
        } else {
            System.out.println("Aviso: Ese asiento ya estaba libre.");
        }
    }

    private static void mostrarDisponibilidad(char[][] sala) {
        int libres = 0;
        int ocupados = 0;

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                if (sala[i][j] == 'O') {
                    libres++;
                } else {
                    ocupados++;
                }
            }
        }
        
        System.out.println("\n--- DISPONIBILIDAD ---");
        System.out.println("Asientos libres: " + libres);
        System.out.println("Asientos ocupados: " + ocupados);
        System.out.println("Total de asientos: " + (libres + ocupados));
    }

    private static int pedirFila(Scanner sc) {
        System.out.print("Seleccione en qué fila (1-5): ");
        int fila = sc.nextInt();
        while (fila < 1 || fila > 5) {
            System.out.print("Seleccione una fila válida (1-5): ");
            fila = sc.nextInt();
        }
        return fila;
    }

    private static int pedirColumna(Scanner sc) {
        System.out.print("Seleccione en qué asiento/columna (1-8): ");
        int columna = sc.nextInt();
        while (columna < 1 || columna > 8) {
            System.out.print("Seleccione un asiento válido (1-8): ");
            columna = sc.nextInt();
        }
        return columna;
    }
}