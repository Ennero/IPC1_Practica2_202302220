
package udrive;

/**
 *
 * @author Enner
 */
public class Ruta3 extends Thread{
    
    Viajes viaje;
    private boolean b1=true;
    public Ruta3(Viajes viaje) {
        this.viaje = viaje;
    }
    @Override
    public void run(){
        Generar.ll3=Generar.l3;
        try{
            while(b1){
                sleep(1000);
                if(Viajes.po3<=120){
                    pausar();
                    Viajes.disto3=Viajes.d3;
                    Viajes.btn32.setEnabled(true);
                    Viajes.br3=true;
                }else{
                    Viajes.po3=(int)(Viajes.po3-Viajes.trozo3);
                    Viajes.rec3+=1;
                    Viajes.disto3+=1;
                    Viajes.gas3=Viajes.gas3-viaje.c;
                    Viajes.gast3+=Viajes.c;
                }
                if(Viajes.gas3<=0 && Viajes.gas3!=-1){
                        pausar();
                        this.viaje.btn33.setVisible(true);
                        Viajes.reca3=true;
                    }
                Viajes.LabelImagen3.setLocation((int) Viajes.po3, this.viaje.LabelImagen3.getY());
                Viajes.lbl36.setLocation((int) Viajes.po3, this.viaje.lbl36.getY());
                Viajes.btn33.setLocation((int) (Viajes.po3+135), this.viaje.btn33.getY());
                Viajes.lbl36.setText("Gasolina actual: "+ Math.round(Viajes.gas3) +"gal");
                Viajes.lbl35.setLocation((int) Viajes.po3, this.viaje.lbl35.getY());
                Viajes.lbl35.setText("Recorrido: "+ Viajes.disto3 +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void pausar(){
        b1=false;
    }
    
    
}
