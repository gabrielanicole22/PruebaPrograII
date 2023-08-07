/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1_programacionii;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void agregarItem(int codigo, String nombre, String tipoItem) {
        if (buscarItem(codigo, tipoItem) == null) {
            Scanner scanner = new Scanner(System.in);
            if (tipoItem.equals("MOVIE")) {
                System.out.print("Ingrese el precio de renta: ");
                double precio = scanner.nextDouble();
                MovieItem movieItem = new MovieItem(codigo, nombre, precio);
                items.add(movieItem);
            } else if (tipoItem.equals("GAME")) {
                System.out.print("Ingrese la consola (PLAYSTATION, XBOX, o WII): ");
                String consola = scanner.next();
                VideogameItem videoGameItem = new VideogameItem(codigo, nombre, consola);
                items.add(videoGameItem);
            }
        } else {
            System.out.println("Ya existe un ítem con ese código y ese tipo.");
        }
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
        String informacion=("\t\tINFORMACIÓN\n\n");
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado();
            }
        }
        return informacion;
    }
}