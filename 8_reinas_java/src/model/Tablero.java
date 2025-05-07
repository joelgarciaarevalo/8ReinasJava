package model;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private int[][] tablero;
    private int tamaño = 8;
    private List<int[][]> soluciones;

    public Tablero() {
        tablero = new int[tamaño][tamaño];
        soluciones = new ArrayList<>();
    }

    public boolean esSeguro(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) return false;
            if (columna - (fila - i) >= 0 && tablero[i][columna - (fila - i)] == 1) return false;
            if (columna + (fila - i) < tamaño && tablero[i][columna + (fila - i)] == 1) return false;
        }
        return true;
    }

    public void resolver(int fila) {
        if (fila == tamaño) {
            almacenarSolucion();
            return;
        }
        for (int col = 0; col < tamaño; col++) {
            if (esSeguro(fila, col)) {
                tablero[fila][col] = 1;
                resolver(fila + 1);
                tablero[fila][col] = 0;
            }
        }
    }

    private void almacenarSolucion() {
        int[][] solucion = new int[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++)
            System.arraycopy(tablero[i], 0, solucion[i], 0, tamaño);
        soluciones.add(solucion);
    }

    public List<int[][]> obtenerSoluciones() {
        return soluciones;
    }
}