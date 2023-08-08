/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1_programacionii;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela Mejía
 */
public class BlockBuster {

    private ArrayList<BlockBusterItem> items;

    public BlockBuster() {
        this.items = new ArrayList<>();
    }

    public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem && tipo.equals("MOVIE") && item.getCodigo() == codigo) {
                return item;
            } else if (item instanceof VideogameItem && tipo.equals("GAME") && item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    public void agregarItem(int codigo, String nombre, double precioRenta, String tipoItem) {
        if (buscarItem(codigo, tipoItem) == null) {
            if (tipoItem.equals("MOVIE")) {
                //double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de renta: "));
                MovieItem movieItem = new MovieItem(codigo, nombre, precioRenta);
                items.add(movieItem);
            } else if (tipoItem.equals("GAME")) {
                String consola = JOptionPane.showInputDialog("Ingrese la consola (PLAYSTATION, XBOX, o WII): ");
                VideogameItem videoGameItem = new VideogameItem(codigo, nombre, precioRenta, consola);
                items.add(videoGameItem);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un ítem con ese código y ese tipo.");
        }
    }

    public double obtenerMontoAPagar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            return item.pagoRenta(dias);
        }
        return 0;
    }

    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            System.out.println(item);
            double montoPagar = item.pagoRenta(dias);
            System.out.println("Monto a pagar: " + montoPagar);
        } else {
            System.out.println("Ítem no existe.");
        }
    }

    public String auditarMovieEstados() {
        String informacion = ("\t\tINFORMACIÓN\n\n");
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado();
            }
        }
        return informacion;
    }
}
