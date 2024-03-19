
package udrive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Enner
 */
public class UDrive {

    /**
     * @param args the command line arguments
     */
    public static int ID=0;
    public static int ruta[]=new int[3];//aquí guardarpe las posiciones de los vehículos
    public static boolean libre[]={true,true,true};
    public static ArrayList<String[]> historial=new ArrayList<>();
    
    //public Object[][] tableo(){
        
        
        
    //}
    
    
    public static void main(String[] args) {
        Inicio inicio= new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setResizable(false);
        inicio.setVisible(true);
        //Viajes viaje=new Viajes();
    }
    
    public static boolean disponible[]={true,true,true,true,true,true,true,true,true};
    public static String vehiculo[]={
        "Motocicleta 1","Motocicleta 2","Motocicleta 3",
        "Vehículo estándar 1","Vehículo estándar 2","Vehículo estándar 3",
        "Vehículo premium 1","Vehículo premium 2","Vehículo premium 3"
    };
    
    public static void leerCSV(JFrame frame){
        JFileChooser escojo=new JFileChooser();
        
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivos CSV","csv");
        escojo.setFileFilter(filtro);
        
        int resultado=escojo.showOpenDialog(frame);
        
        if(resultado==JFileChooser.APPROVE_OPTION){
            
            File escojido=escojo.getSelectedFile();
            try{
               Scanner scan=new Scanner(escojido);
               while(scan.hasNextLine()){
                   String linea= scan.nextLine();
                   String[] partes=linea.split(",");
                   for (int i=0;i<partes.length;i=i+3){//Solo lo coloco todo entro de la tabla
                       String[] vector=new String[4];
                           ID++;
                           vector[0]=String.valueOf(ID);
                           vector[1]=partes[i];
                           vector[2]=partes[i+1];
                           vector[3]=partes[i+2];
                           Menu.d.addRow(vector);
                   }
               }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            
        }
    }
    
    
    
    
    
}
