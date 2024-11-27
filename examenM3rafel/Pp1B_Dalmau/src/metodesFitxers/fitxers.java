package metodesFitxers;

import java.io.File;
import java.util.Scanner;

public class fitxers {
    private static final Scanner scanner = new Scanner(System.in);

    public static void eliminaExtensio() {
        try {
            System.out.println("Escriu la ruta:");
            String rutaFitxer = scanner.nextLine();

            File fitxer = new File(rutaFitxer);
            if (!fitxer.exists() || !fitxer.isFile()) {
                System.out.println("El fitxer no es vàlid.");
                return;
            }

            String nomFitxer = fitxer.getName();
            String[] parts = nomFitxer.split("\\."); 

            String nomBase = "";
            for (int i = 0; i < parts.length - 1; i++) {
                nomBase += parts[i];
                if (i < parts.length - 2) {
                    nomBase += "."; 
                }
            }

            File fitxerSenseExtensio = new File(fitxer.getParent(), nomBase);

            if (fitxer.renameTo(fitxerSenseExtensio)) {
                System.out.println("Fitxer renombrat: " + fitxerSenseExtensio.getName());
            } else {
                System.out.println("Error al renombrar el fitxer.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void sencerMesGran() {
        try {
            File fitxer = new File("Sencers.txt");
            Scanner lectorFitxer = new Scanner(fitxer);
            int maxValor = Integer.MIN_VALUE;
    
            while (lectorFitxer.hasNextInt()) {
                int valor = lectorFitxer.nextInt();
                if (valor > maxValor) {
                    maxValor = valor;
                }
            }
            lectorFitxer.close();
    
            System.out.println("El numero mes gran és: " + maxValor);
        } catch (Exception e) {
            System.out.println("Error: No s'ha pogut llegir el fitxer.");
        }
    }
    
}


