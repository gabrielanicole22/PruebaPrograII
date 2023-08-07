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

public class BlockBusterItem {
    private int codigo;
    private String nombre;
    private double precioRenta;
    public LocalDate fechaAdicion;

    public BlockBusterItem(int codigo, String nombre, double precioRenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioRenta = precioRenta;
        this.fechaAdicion = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio de Renta: " + precioRenta;
    }

    public double pagoRenta(int dias) {
        return dias * precioRenta;
    }
}