
package udrive;

import java.time.LocalDateTime;

/**
 *
 * @author Enner
 */
public class Ruta22 extends Thread{
    Viajes viaje;
    private boolean b1=true;
    
    public Ruta22(Viajes viaje) {
        this.viaje = viaje;
    }
    @Override
    public void run(){
        Generar.ll2=Generar.l2;
        try{
            while(b1){
                sleep(1000);
                if(Viajes.po2>=810){
                    Viajes.disto2=Viajes.d2*2;
                    Viajes.gast2=Viajes.disto2*Viajes.b;
                    
                    pausar();
                    LocalDateTime now=LocalDateTime.now();
                    String tf2=now.format(Viajes.formato);
                    String nombre=(String) Viajes.lbl21.getText();
                    UDrive.historial.add(new Linea(tf2,Viajes.ti2,String.valueOf(Viajes.disto2),nombre,String.valueOf((Viajes.gast2))));
                    UDrive.serializar();
                    UDrive.libre[1]=true;
                    UDrive.disponible[Generar.ll2]=true;
                    Viajes.b2=true;
                    Generar.b=-1;
                    Viajes.po2=830;

                }else{
                    Viajes.po2=(int)(Viajes.po2+Viajes.trozo2);
                    Viajes.rec2=+1;
                    Viajes.disto2+=1;
                    Viajes.gas2=Viajes.gas2-viaje.b;
                    Viajes.gast2+=viaje.b;
                }
                if(Viajes.gas2<=0 && Viajes.gas2!=-1){
                        pausar();
                        this.viaje.btn23.setVisible(true);
                        Viajes.reca2=true;
                    }
                Viajes.LabelImagen2.setLocation((int) Viajes.po2, this.viaje.LabelImagen2.getY());
                Viajes.lbl26.setLocation((int) Viajes.po2, this.viaje.lbl26.getY());
                Viajes.btn23.setLocation((int) (Viajes.po2+135), this.viaje.btn23.getY());
                Viajes.lbl26.setText("Gasolina actual: "+ Math.round(Viajes.gas2) +"gal");
                Viajes.lbl25.setLocation((int) Viajes.po2, this.viaje.lbl25.getY());
                Viajes.lbl25.setText("Recorrido: "+ Viajes.disto2 +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void pausar(){
        b1=false;
    }
}
