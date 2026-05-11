import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        char[][] sala = new char[5][8];
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = 'O';
            }
        }

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1 - Mostrar sala");
            System.out.println("2 - Reservar asiento");
            System.out.println("3 - Liberar asiento");
            System.out.println("4 - Mostrar disponibilidad");
            System.out.println("5 - Salir");
            System.out.println("introduce una opción:");
            opcion = sc.nextInt();
            while (opcion < 1 || opcion > 5) {
                System.out.print("Elige una opción válida: ");
                opcion = sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    for (int i = 0; i < sala.length; i++) {
                        System.out.print("Fila " + (i + 1) + ": ");
                        for (int j = 0; j < sala[i].length; j++) {
                            System.out.print(sala[i][j] + "  ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Seleccione en que fila: ");
                    int fila = sc.nextInt();
                    while (fila < 1 || fila > 5) {
                        System.out.print("Seleccione una fila válida: ");
                        fila = sc.nextInt();
                    }
                    System.out.print("Seleccione en que asiento: ");
                    int columna = sc.nextInt();
                    while (columna < 1 || columna > 8) {
                        System.out.print("Seleccione un asiento válido: ");
                        columna = sc.nextInt();
                    }
                    for (int i = 0; i < sala.length; i++) {
                        for (int j = 0; j < sala[i].length; j++) {
                            if (fila - 1 == i && columna - 1 == j && sala[i][j] != 'X') {
                                sala[i][j] = 'X';
                            }
                            if (fila - 1 == i && columna - 1 == j && sala[i][j] == 'X') {
                                System.out.println("Ese asiento ya esta reservado");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.print("Seleccione en que fila: ");
                    fila = sc.nextInt();
                    while (fila < 1 || fila > 5) {
                        System.out.print("Seleccione una fila válida: ");
                        fila = sc.nextInt();
                    }
                    System.out.print("Seleccione en que asiento: ");
                    columna = sc.nextInt();
                    while (columna < 1 || columna > 8) {
                        System.out.print("Seleccione un asiento válido: ");
                        columna = sc.nextInt();
                    }
                    for (int i = 0; i < sala.length; i++) {
                        for (int j = 0; j < sala[i].length; j++) {
                            if (fila - 1 == i && columna - 1 == j && sala[i][j] != 'O') {
                                sala[i][j] = 'O';
                            }
                            if (fila - 1 == i && columna - 1 == j && sala[i][j] == 'O') {
                                System.out.println("Ese asiento ya esta libre");
                            }
                        }
                    }
                    break;
                case 4:
                    // todo(ferran): mostrar disponibilidad
                    break;
            }
        } while (opcion != 5);
        System.out.println("Eperemos que vuelva!");
        sc.close();
    }
}