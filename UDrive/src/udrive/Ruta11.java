
package udrive;

import java.time.LocalDateTime;

/**
 *
 * @author Enner
 */
public class Ruta11 extends Thread{
    Viajes viaje;
    private boolean b1=true;
    private double distancia;
    public Ruta11(Viajes viaje) {
        this.viaje = viaje;
        distancia=((Viajes.po1+590)/(Viajes.d1-Viajes.rec1));
    }
    @Override
    public void run(){
        try{
            while(b1){
                sleep(1000);
                if(Viajes.po1>=810){
                    Viajes.disto1=Viajes.d1*2;
                    pausar();
                    LocalDateTime now=LocalDateTime.now();
                    String tf1=now.format(Viajes.formato);
                    String nombre=(String) Viajes.lbl11.getText();
                    UDrive.historial.add(new Linea(tf1,Viajes.ti1,String.valueOf(Viajes.disto1),nombre,String.valueOf((Viajes.gast1))));
                    UDrive.serializar();
                }else{
                    Viajes.po1=(int)(Viajes.po1+distancia);
                    Viajes.rec1=+1;
                    Viajes.disto1+=1;
                    Viajes.gas1=Viajes.gas1-viaje.a;
                    Viajes.gast1+=Viajes.a;
                    
                }
                if(Viajes.gas1<=0){
                        pausar();
                        this.viaje.btn13.setVisible(true);
                    }
                Viajes.LabelImagen1.setLocation((int) Viajes.po1, this.viaje.LabelImagen1.getY());
                Viajes.lbl16.setLocation((int) Viajes.po1, this.viaje.lbl16.getY());
                Viajes.btn13.setLocation((int) (Viajes.po1+135), this.viaje.btn13.getY());
                Viajes.lbl16.setText("Gasolina actual: "+ Math.round(Viajes.gas1) +"gal");
                Viajes.lbl15.setLocation((int) Viajes.po1, this.viaje.lbl15.getY());
                Viajes.lbl15.setText("Recorrido: "+ (Viajes.disto1) +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void pausar(){
        b1=false;
    }
}
