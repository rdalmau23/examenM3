package menuFitxers;

import java.util.Scanner;

import metodesFitxers.fitxers;

public class fitxersMenu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            String menuOpcions = obtenirMenu();
            System.out.println(menuOpcions);
            
            opcio = scanner.nextInt();
            
            switch (opcio) {
                case 1:
                    fitxers.eliminaExtensio();
                    break;

                case 2:
                    fitxers.sencerMesGran();                    
                    break;

                case 3:
                    fitxers.calculaMitja();
                    break;

                case 0:
                    System.out.println("Adeu Montse!");
                    break;

                default:
                    System.out.println("Opció no vàlida. tria una opció correcta.");
                    break;
            }

        } while (opcio != 0); 

        scanner.close();
    }

    public static String obtenirMenu() {
        return "\nHola Montse, tria una opció:\n" +
               "1. Eliminar extensió\n" +
               "2. Mostrar valor més gran del fitxer Sencers.txt\n" +
               "3. Calcular nota mitjana del fitxer NotesAlumnes.txt\n" +
               "0. Sortir";
    }
}
