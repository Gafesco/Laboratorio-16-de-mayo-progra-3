package programalaboratorioprogra;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Programalaboratorioprogra {
private static Hashtable<String, String> tokenTable;

    public static void main(String[] args) {
String code = "int suma = 0;\n" +
                "suma = 54 + 20;";

        tokenTable = generateTokenTable(code);
        printTokenTable(tokenTable);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave (fila,columna) que desea buscar o escribe 'salir' para terminar: ");
        String searchKey = scanner.nextLine();

        while (!searchKey.equalsIgnoreCase("salir")) {
            String token = getTokenFromKey(searchKey);
            if (token != null) {
                System.out.println("El token correspondiente a la clave '" + searchKey + "' es: " + token);
            } else {
                System.out.println("No se encontró ningún token para la clave '" + searchKey + "'.");
            }

            System.out.print("Ingrese otra clave (fila,columna) que desea buscar (o 'salir' para terminar): ");
            searchKey = scanner.nextLine();
        }

        System.out.println("Fin del programa.");
    }

    public static Hashtable<String, String> generateTokenTable(String code) {
        Hashtable<String, String> tokenTable = new Hashtable<>();
        String[] lines = code.split("\n");

        int row = 0;
        for (String line : lines) {
            String[] tokens = line.split("\\s+"); 

            int column = 0;
            for (String token : tokens) {
                String key = row + "," + column;
                tokenTable.put(key, token);
                column += token.length() + 1;
            }
            row++;
        }
        return tokenTable;
    }
    public static void printTokenTable(Hashtable<String, String> tokenTable) {
        for (Map.Entry<String, String> entry : tokenTable.entrySet()) {
            String key = entry.getKey();
            String token = entry.getValue();
            System.out.println("[" + key + "] -> " + token);
        }
    }
    public static String getTokenFromKey(String searchKey) {
        return tokenTable.get(searchKey);
    }
}