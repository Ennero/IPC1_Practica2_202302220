
package udrive;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Enner
 */
public class Viajes extends JFrame implements ActionListener    {
    JLabel lbl11,lbl12,lbl13, lbl14,lbl15,lbl16,lbl21,lbl22,lbl23,lbl24,lbl25,lbl26,lbl31,lbl32,lbl33,lbl34,lbl35,lbl36,
            LabelImagen1,LabelImagen2,LabelImagen3,D1,D2,D3,I1,I2,I3;
    double d1,d2,d3,r1,r2,r3,g1,g2,g3;
    JButton btn01,btn02, btn03, btn04, btn11, btn12,btn13, btn21, btn22,btn23, btn31, btn32,btn33; 

    public Viajes() throws HeadlessException {
        
        //coloco los dos botones de arriba
        btn01=new JButton("Cerrar");
        btn01.setBounds(5,5,100,30);
        btn01.addActionListener(this);
        this.add(btn01);
        
        btn02=new JButton("Reanudar");
        btn02.setBounds(110,5,100,30);
        btn02.addActionListener(this);
        this.add(btn02);
        
        btn03=new JButton("Iniciar Todos");
        btn03.setBounds(920,5,160,30);
        btn03.addActionListener(this);
        this.add(btn03);
        
        //**************************************************************************************************************************************
        //generación de las rutas (las lineas)
        ImageIcon imagenIcono01 = new ImageIcon(getClass().getResource("./v/linea.png"));
        Image imageDimension01 = imagenIcono01.getImage().getScaledInstance(860, 95, Image.SCALE_SMOOTH);
        ImageIcon imagenadjustada01 = new ImageIcon(imageDimension01);
        JLabel LabelImagen01 = new JLabel(imagenadjustada01); //Label de la iamgen
        LabelImagen01.setBounds(95, 110, 860, 160); 
        this.add(LabelImagen01);
        
        ImageIcon imagenIcono02 = new ImageIcon(getClass().getResource("./v/linea.png"));
        Image imageDimension02 = imagenIcono02.getImage().getScaledInstance(860, 95, Image.SCALE_SMOOTH);
        ImageIcon imagenadjustad02 = new ImageIcon(imageDimension02);
        JLabel LabelImagen02 = new JLabel(imagenadjustad02); //Label de la iamgen
        LabelImagen02.setBounds(95, 280, 860, 160); 
        this.add(LabelImagen02);
        
        ImageIcon imagenIcono03 = new ImageIcon(getClass().getResource("./v/linea.png"));
        Image imageDimension03 = imagenIcono03.getImage().getScaledInstance(860, 95, Image.SCALE_SMOOTH);
        ImageIcon imagenadjustada03 = new ImageIcon(imageDimension03);
        JLabel LabelImagen03 = new JLabel(imagenadjustada03); //Label de la iamgen
        LabelImagen03.setBounds(95, 445, 860, 160); 
        this.add(LabelImagen03);
                  UDrive.ruta.add(2);
        UDrive.ruta.add(9);
        UDrive.ruta.add(4);

        int y=0;
        for(int i=0;i<UDrive.ruta.size();i++){
            if(UDrive.ruta.get(i)<3){//La generación de los autos con sus respectivas posiciones
                ImageIcon imagenIcono1 = new ImageIcon(getClass().getResource("./v/moto.png"));
                Image imageDimension1 = imagenIcono1.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                ImageIcon imagenadjustada1 = new ImageIcon(imageDimension1);
                LabelImagen1 = new JLabel(imagenadjustada1); //Label de la iamgen
                LabelImagen1.setBounds(830, 75+165*y, 125, 160); 
                this.add(LabelImagen1);
                
                lbl11= new JLabel(UDrive.vehiculo[UDrive.ruta.get(i)]);
                lbl11.setBounds(10, 40+165*y, 150, 30);
                lbl11.setFont(new Font("Arial",Font.BOLD, 20));
                this.add(lbl11);
                
                lbl12=new JLabel ("Distancia: " + d1);
                lbl12.setBounds(10, 80+165*y, 150, 30);
                this.add(lbl12);
                
                lbl13=new JLabel ("Destino: " + D1);
                lbl13.setBounds(10, 100+165*y, 150, 30);
                this.add(lbl13);
                
                lbl14=new JLabel ("Inicio: "+ I1);
                lbl14.setBounds(870, 40+165*y, 270, 30);
                lbl14.setFont(new Font("Arial",Font.BOLD, 20));
                this.add(lbl14);
                
                lbl15=new JLabel ("Recorrido: "+ r1 +"km");
                lbl15.setBounds(830, 65+165*y, 150, 30);
                this.add(lbl15);
                
                lbl16=new JLabel ("Gasolina actual: "+ g1 + "gal");
                lbl16.setBounds(830, 80+165*y, 200, 30);
                this.add(lbl16);
                //Aquí me quedé
            }else{
                if(UDrive.ruta.get(i)<6){
                ImageIcon imagenIcono2 = new ImageIcon(getClass().getResource("./v/picanto.png"));
                Image imageDimension2 = imagenIcono2.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                ImageIcon imagenadjustada2 = new ImageIcon(imageDimension2);
                LabelImagen2 = new JLabel(imagenadjustada2); //Label de la iamgen
                LabelImagen2.setBounds(830, 80+165*y, 125, 160); 
                this.add(LabelImagen2);   
                }else{
                ImageIcon imagenIcono3 = new ImageIcon(getClass().getResource("./v/tesla.png"));
                Image imageDimension3 = imagenIcono3.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                ImageIcon imagenadjustada3 = new ImageIcon(imageDimension3);
                LabelImagen3 = new JLabel(imagenadjustada3); //Label de la iamgen
                LabelImagen3.setBounds(830, 90+165*y, 125, 160); 
                this.add(LabelImagen3); 
                }
            }
            y++;
        }
        
        
        
        
        
        
        
        this.setTitle("Viajes");  // Título de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(1100, 600);
        setLocationRelativeTo(null);

        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn01){
            this.dispose();
        }



    }
    
}
