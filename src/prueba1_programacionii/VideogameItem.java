package prueba1_programacionii;

public class VideogameItem extends BlockBusterItem{
    
private static final String PLAYSTATION = "PLAYSTATION";
    private static final String XBOX = "XBOX";
    private static final String WII = "WII";

    private String consola;
    
    public VideogameItem(int codigo, String nombre, String consola) {
        
        super(codigo,nombre,30);
        this.consola=consola;
        
    }
    
    public double pagarRenta(int dias){
        return super.pagoRenta(dias);
    }
    
    public String toString() {
        return super.toString()+ consola + " Game";
    }
    
    
    
}
    

