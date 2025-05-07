package controller;

import model.Tablero;

public class ReinaController {
    private Tablero tablero;

    public ReinaController() {
        tablero = new Tablero();
    }

    public void resolverTablero(int fila, int columna) {
        tablero.esSeguro(fila, columna);
        tablero.resolver(0);
    }

    public void mostrarSoluciones() {
        for (int[][] solucion : tablero.obtenerSoluciones()) {
            for (int[] fila : solucion) {
                for (int celda : fila) {
                    System.out.print((celda == 1 ? "Q " : ". "));
                }
                System.out.println();
            }
            System.out.println("------------");
        }
    }
}