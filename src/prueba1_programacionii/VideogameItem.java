package prueba1_programacionii;

public class VideogameItem extends BlockBusterItem{
    
private static final String PLAYSTATION = "PLAYSTATION";
    private static final String XBOX = "XBOX";
    private static final String WII = "WII";

    private String consola;
    
    public VideogameItem(int codigo, String nombre, double precioRenta) {
        
        super(codigo,nombre,precioRenta);
        
    }
    
    
    public String toString() {
        return super.toString()+ consola + " Game";
    }
    
    
    
}
    

