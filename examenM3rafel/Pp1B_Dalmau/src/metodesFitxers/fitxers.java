package metodesFitxers;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class fitxers {
    private static final Scanner scanner = new Scanner(System.in);

    public static void eliminaExtensio() {
        try {
            System.out.println("Escriu la ruta:");
            String rutaFitxer = scanner.nextLine();
    
            File fitxer = new File(rutaFitxer);
    
            String nomFitxer = fitxer.getName();
            String[] parts = nomFitxer.split("\\.");
    
            if (parts.length > 1) {
                String nomBase = String.join(".", java.util.Arrays.copyOf(parts, parts.length - 1));
                File fitxerSenseExtensio = new File(fitxer.getParent(), nomBase);
    
                if (fitxer.renameTo(fitxerSenseExtensio)) {
                    System.out.println("Fitxer renombrat a: " + fitxerSenseExtensio.getName());
                } else {
                    System.out.println("Error al renombrar el fitxer.");
                }
            } else {
                System.out.println("El fitxer no té cap extensió.");
            }
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public static void sencerMesGran() {
        try {
            File fitxer = new File("Sencers.txt");
            Scanner scanner = new Scanner(fitxer);
            int maxValor = Integer.MIN_VALUE;
    
            while (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                if (valor > maxValor) {
                    maxValor = valor;
                }
            }
            scanner.close();
    
            System.out.println("El numero mes gran és: " + maxValor);
        } catch (Exception e) {
            System.out.println("Error al llegir fitxer");
        }
    }

    public static void calculaMitja() {
        try {
            Scanner scanner = new Scanner(new File("NotesAlumnes.txt"));
            PrintWriter writer = new PrintWriter("NotaMitja.txt");
    
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
    
                if (linia.equals("fi")) {
                    break;
                }
    
                String[] parts = linia.split(" ");
                String nom = parts[0];
                float suma = 0;
                int count = 0;
    
                for (int i = 1; i < parts.length; i++) {
                    suma += Float.parseFloat(parts[i]);
                    count++;
                }
    
                float mitjana = suma / count;
    
                if (mitjana >= 5) {
                    writer.println(nom + " estudiant aprovat");
                } else {
                    writer.println(nom + " estudiant suspes");
                }
            }
    
            scanner.close();
            writer.close();
    
            System.out.println("Mitjana feta a NotaMitja.txt");
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}


