
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
    public static ArrayList<Integer> ruta=new ArrayList<Integer>();//aqu� guardarpe las posiciones de los veh�culos
    
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
        "Veh�culo est�ndar 1","Veh�culo est�ndar 2","Veh�culo est�ndar 3",
        "Veh�culo premium 1","Veh�culo premium 2","Veh�culo premium 3"
    };
    
    
}
