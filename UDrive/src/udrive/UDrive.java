
package udrive;

import java.util.ArrayList;

/**
 *
 * @author Enner
 */
public class UDrive {

    /**
     * @param args the command line arguments
     */
    public static int ID=0;
    public static ArrayList<Integer> ruta=new ArrayList<Integer>();//aquí guardarpe las posiciones de los vehículos
    
    public static void main(String[] args) {
        //Inicio inicio= new Inicio();
        //inicio.setLocationRelativeTo(null);
        //inicio.setResizable(false);
        //inicio.setVisible(true);
        Viajes viaje=new Viajes();
    }
    
    public static boolean disponible[]={true,true,true,true,true,true,true,true,true};
    public static String vehiculo[]={
        "Motocicleta 1","Motocicleta 2","Motocicleta 3",
        "Vehículo estándar 1","Vehículo estándar 2","Vehículo estándar 3",
        "Vehículo premium 1","Vehículo premium 2","Vehículo premium 3"
    };
    
    
}
