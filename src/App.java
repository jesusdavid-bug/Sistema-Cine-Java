import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    
        char[][] sala = new char[5][8];       
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j]='O';
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
            while (opcion<1 || opcion>5) {
                System.out.print("Elige una opción válida: ");
                opcion=sc.nextInt();
            }
            switch (opcion) {
                case 1:
                // todo(guillermo): mostrar la sala de cine
                    break;
                case 2:
                // todo(jesus): reservar un asiento
                    break;
                case 3:
                    // todo(víctor): liberar un asiento
                    break;
                case 4:
                    // todo(ferran): mostrar disponibilidad
                    break;
            }
        } while (opcion!=5);
        System.out.println("Eperemos que vuelva!");
        sc.close();
    }
}