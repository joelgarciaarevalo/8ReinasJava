import controller.ReinaController;
import view.Consola;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        ReinaController controller = new ReinaController();
        Consola vista = new Consola();
        Scanner scanner = new Scanner(System.in);

        vista.mostrarMensaje("Ingrese la posición inicial de la reina (fila y columna de 0 a 7):");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        controller.resolverTablero(fila, columna);
        controller.mostrarSoluciones();
    }
}
