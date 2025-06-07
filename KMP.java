import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMP {

    // Función de fallo (LPS)
    private static int[] computeFailureFunction(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Búsqueda de patrón
    public static List<Integer> search(String text, String pattern) {
        List<Integer> resultado = new ArrayList<>();
        int[] lps = computeFailureFunction(pattern);

        int i = 0, j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                resultado.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return resultado;
    }

    // Método principal main 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el texto: ");
        String texto = scanner.nextLine();

        System.out.print("Ingrese el patrón a buscar: ");
        String patron = scanner.nextLine();

        List<Integer> posiciones = search(texto, patron);

        if (posiciones.isEmpty()) {
            System.out.println("No se encontró el patrón.");
        } else {
           System.out.print("Patrón encontrado en las posiciones: ");
for (int i = 0; i < posiciones.size(); i++) {
    System.out.print(posiciones.get(i));
    if (i != posiciones.size() - 1) {
        System.out.print(", ");
    }
}
System.out.println();

        }

        scanner.close();
    }
}