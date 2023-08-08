package prueba1_programacionii;

public class VideogameItem extends BlockBusterItem {

    public static final String PLAYSTATION = "PLAYSTATION";
    public static final String XBOX = "XBOX";
    public static final String WII = "WII";

    String consola;

    public VideogameItem(int codigo, String nombre, double precioRenta, String consola) {

        super(codigo, nombre, precioRenta);
        this.consola = consola;

    }

    @Override
    public double pagoRenta(int dias) {
        return precioRenta * dias;
    }

    public String toString() {
        return super.toString() + consola + " Game";
    }

    public String getConsola() {
        return consola;
    }

}
    

