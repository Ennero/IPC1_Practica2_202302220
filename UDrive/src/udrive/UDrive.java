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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Enner
 */
public class UDrive {       

    public static int ruta[] = new int[3];//aquí guardar las posiciones de los vehículos
    public static boolean libre[] = {true, true, true};
    public static ArrayList<Linea> historial = new ArrayList<>();
    public static Vehiculo[] guardado = new Vehiculo[3];
    public static int ID = 99;

    //public Object[][] tableo(){
    //}
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setResizable(false);
        inicio.setVisible(true);
        tablear();
    }

    public static boolean disponible[] = {true, true, true, true, true, true, true, true, true};
    public static String vehiculo[] = {
        "Motocicleta 1", "Motocicleta 2", "Motocicleta 3",
        "Vehículo estándar 1", "Vehículo estándar 2", "Vehículo estándar 3",
        "Vehículo premium 1", "Vehículo premium 2", "Vehículo premium 3"
    };

    public static void leerCSV(JFrame frame) {
        JFileChooser escojo = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
        escojo.setFileFilter(filtro);

        int resultado = escojo.showOpenDialog(frame);

        if (resultado == JFileChooser.APPROVE_OPTION) {//En dado caso haya sido aceptado el archivo
                    

            File escojido = escojo.getSelectedFile();
            try {
                Scanner scan = new Scanner(escojido,"UTF-8");//Leo lo que tiene el archivo con UTF-8 para que pueda tener tildes
                while (scan.hasNextLine()) {
                    String linea = scan.nextLine();
                    String[] partes = linea.split(",");

                    for (int i = 0; i < partes.length; i=i+3) {//Solo lo coloco todo dentro de la tabla
                        
                            String[] vector = new String[4];

                            vector[0] = String.valueOf(ID);
                            vector[1] = partes[i];
                            vector[2] = partes[i + 1];
                            vector[3] = partes[i + 2];
                            Menu.d.addRow(vector);
                            ID=ID+1;
                    }
                    
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Menu.d.removeRow(0);//esto solo espara quitar la primera fila que es la de los encabezados
        }
    }

    public static Object leerHistorial() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Archivos/historial.bin"));
            ArrayList<Linea> historial = (ArrayList<Linea>) in.readObject();
            in.close();
            System.out.println("Lo ando leyendo");
            return historial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void tablear() {
        int id=1000;
        ArrayList<Linea> pre = (ArrayList<Linea>) leerHistorial();
        if (pre != null) {
            historial = pre;
            String[] vector = new String[6];
            int fila = historial.size();
            for (int i = 0; i < fila; i++) {
                vector[0] = String.valueOf(id);
                id++;
                vector[1] = historial.get(i).getFechai();
                vector[2] = historial.get(i).getFechaf();
                vector[3] = historial.get(i).getDistancia();
                vector[4] = historial.get(i).getVehiculo();
                vector[5] = historial.get(i).getGasolina();
                Historial.h.addRow(vector);
            }
        }

    }

    public static void serializar() {//método para que serizalice la información del arrayList
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Archivos/historial.bin"));
            out.writeObject(historial);
            out.close();
            System.out.println("Se serializó correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void guardo() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Archivos/guardado.bin"));
            out.writeObject(guardado);
            out.close();
            System.out.println("Serializado :)");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Object leerGuardado() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Archivos/guardado.bin"));
            Vehiculo[] guardado = (Vehiculo[]) in.readObject();
            in.close();
            System.out.println("Lo estoy leyendo");
            return guardado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void recargar() {
        Vehiculo[] pepe = (Vehiculo[]) leerGuardado();
        if (pepe != null) {
            guardado = pepe;
            
            UDrive.ruta[0] = guardado[0].getI();
            libre[0]=guardado[0].isIni();
            
            UDrive.ruta[1] = guardado[1].getI();
            libre[1]=guardado[1].isIni();
            
            UDrive.ruta[2] = guardado[2].getI();
            libre[2]=guardado[2].isIni();
            
            if(guardado[0].getL()>-1){
                UDrive.disponible[guardado[0].getL()] = guardado[0].isAvailable();
            }
            Generar.l1=guardado[0].getL();
            
            
            if(guardado[1].getL()>-1){
                UDrive.disponible[guardado[1].getL()] = guardado[1].isAvailable();
            }
            Generar.l2=guardado[1].getL();
            if(guardado[2].getL()>-1){

                UDrive.disponible[guardado[2].getL()] = guardado[2].isAvailable();
            }
            Generar.l3=guardado[2].getL();
            
            Viajes.trozo1=guardado[0].getTrozo();
            Viajes.trozo2=guardado[1].getTrozo();
            Viajes.trozo3=guardado[2].getTrozo();
            
            Viajes.d1 = guardado[0].getDistancia();
            Viajes.d2 = guardado[1].getDistancia();
            Viajes.d3 = guardado[2].getDistancia();

            Viajes.I1 = guardado[0].getInicio();
            Viajes.I2 = guardado[1].getInicio();
            Viajes.I3 = guardado[2].getInicio();

            Viajes.disto1 = guardado[0].getDistanciado();
            Viajes.disto2 = guardado[1].getDistanciado();
            Viajes.disto3 = guardado[2].getDistanciado();

            Viajes.gas1 = guardado[0].getGasolina();
            Viajes.gas2 = guardado[1].getGasolina();
            Viajes.gas3 = guardado[2].getGasolina();

            Viajes.D1 = guardado[0].getDestino();
            Viajes.D2 = guardado[1].getDestino();
            Viajes.D3 = guardado[2].getDestino();

            Viajes.po1 = guardado[0].getPos();
            Viajes.po2 = guardado[1].getPos();
            Viajes.po3 = guardado[2].getPos();
            
            Viajes.ti1= guardado[0].getT1();
            Viajes.ti2= guardado[1].getT1();
            Viajes.ti3=guardado[2].getT1();

            
        }else{
            JOptionPane.showMessageDialog(null, "Primero debe haber guardado algo", "Error al cargar", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Nel, no hay nada ");
        }
        
    }

}
