/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1_programacionii;

import java.time.LocalDate;

/**
 *
 * @author Gabriela Mejía
 */
public class MovieItem extends BlockBusterItem {
    private String estado;

    public MovieItem(int codigo, String nombre, double precioRenta) {
        super(codigo, nombre, precioRenta);
        this.estado = "ESTRENO";
    }

    @Override
    public String toString() {
        return super.toString() + ", Estado: " + estado + " - Movie";
    }

    @Override
    public double pagoRenta(int dias) {
        if (estado.equals("ESTRENO") && dias > 2) {
            return super.pagoRenta(dias) + (dias - 2) * 50;
        } else if (estado.equals("NORMAL") && dias > 5) {
            return super.pagoRenta(dias) + (dias - 5) * 30;
        } else {
            return super.pagoRenta(dias);
        }
    }
    
    public void evaluarEstado() {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(fechaAdicion.plusMonths(5))) {
            estado = "NORMAL";
        }
    }
}