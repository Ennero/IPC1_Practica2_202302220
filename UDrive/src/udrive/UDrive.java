
package udrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    
    public static int ID=0;
    public static int ruta[]=new int[3];//aquí guardar las posiciones de los vehículos
    public static boolean libre[]={true,true,true};
    public static ArrayList<Linea> historial=new ArrayList<>();
    
    //public Object[][] tableo(){
        
        
        
    //}
    
    
    public static void main(String[] args) {
        Inicio inicio= new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setResizable(false);
        inicio.setVisible(true);
        //Viajes viaje=new Viajes();
        tablear();
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
                   for (int i=0;i<partes.length;i=i+3){//Solo lo coloco todo dentro de la tabla
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
    
    public static Object leerHistorial(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Archivos/historial.bin"));
            ArrayList<Linea> historial=(ArrayList<Linea>)in.readObject();
            in.close();
            System.out.println("Lo ando leyendo");
            return historial;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void tablear(){
        ArrayList<Linea> pre=(ArrayList<Linea>)leerHistorial();
        if(pre!=null){
            historial=pre;
            String []vector=new String[6];
            int fila=historial.size();
            for(int i=0;i<fila;i++){
            vector[0]=String.valueOf(Linea.ID);
            Linea.ID++;
            vector[1]=historial.get(i).getFechai();
            vector[2]=historial.get(i).getFechaf();
            vector[3]=historial.get(i).getDistancia();
            vector[4]=historial.get(i).getVehiculo();
            vector[5]=historial.get(i).getGasolina();
            Historial.h.addRow(vector);
        }
        }
        
    }
     public static void serializar(){//método para que serizalice la información del arrayList
            try{
                ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("./Archivos/historial.bin"));
                out.writeObject(historial);
                out.close();
                System.out.println("Se serializó correctamente");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    
    
    
    
}
