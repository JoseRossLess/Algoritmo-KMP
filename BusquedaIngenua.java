//Busqueda Codigo
import java.util.Scanner;
import java.util.ArrayList;

public class BusquedaIngenua {
    public static void naiveSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                indices.add(i);
            }
        }

        if (indices.isEmpty()) {
            System.out.println("No se encontró el patrón en el texto.");
        } else {
            System.out.print("Patrón encontrado en los índices: [");
            for (int i = 0; i < indices.size(); i++) {
                System.out.print(indices.get(i));
                if (i < indices.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el texto: ");
        String text = scanner.nextLine();

        System.out.print("Ingrese el patrón a buscar: ");
        String pattern = scanner.nextLine();

        System.out.println("\nBuscando el patrón (método ingenuo)...");
        long start = System.nanoTime();
        naiveSearch(text, pattern);
        long end = System.nanoTime();  

        System.out.println("Tiempo de ejecución: " + (end - start) + " nanosegundos");
        scanner.close();
    }
}