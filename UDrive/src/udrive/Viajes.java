package udrive;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author Enner
 */
public class Viajes extends JFrame implements ActionListener {

    public static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static JLabel lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36,
            LabelImagen1, LabelImagen2, LabelImagen3;
    public static String D1, D2, D3, I1, I2, I3, ti1, ti2, ti3, tf1, tf2, tf3;
    public static double d1, d2, d3, r1, r2, r3, g1, g2, g3, a, b, c, rec1, rec2, rec3, disto1, disto2, disto3, gas1, gas2, gas3, gast1, gast2, gast3;
    public static int po1 = 830;
    public static int po2 = 830;
    public static int po3 = 830;
    public static JButton btn01, btn02, btn03, btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33;
    public static boolean v1, v2, v3;
    public static boolean b1 = true;
    public static boolean b2 = true;
    public static boolean b3 = true;

    public Viajes() throws HeadlessException {
        //Aquí solo inicializo los distintos labels para no tener problemas

        //coloco los dos botones de arriba
        btn01 = new JButton("Cerrar");
        btn01.setBounds(5, 5, 100, 30);
        btn01.addActionListener(this);
        this.add(btn01);

        btn02 = new JButton("Reanudar");
        btn02.setBounds(110, 5, 100, 30);
        btn02.addActionListener(this);
        this.add(btn02);

        btn03 = new JButton("Iniciar Todos");
        btn03.setBounds(920, 5, 160, 30);
        btn03.addActionListener(this);
        this.add(btn03);

        //Hago que los botones no estén disponibles a nada más empezar
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

        //*************************************************************************************************************************************
        //Lo de los botones de inicio y regresar
        btn11 = new JButton("Iniciar");
        btn11.setBounds(975, 120, 80, 20);
        btn11.addActionListener(this);
        if (b1) {
            btn11.setEnabled(false);
        }
        btn11.setForeground(Color.green);
        this.add(btn11);

        btn21 = new JButton("Iniciar");
        btn21.setBounds(975, 285, 80, 20);
        btn21.addActionListener(this);
        if (b2) {
            btn21.setEnabled(false);
        }
        btn21.setForeground(Color.green);
        this.add(btn21);

        btn31 = new JButton("Iniciar");
        btn31.setBounds(975, 450, 80, 20);
        btn31.addActionListener(this);
        if (b3) {
            btn31.setEnabled(false);
        }
        btn31.setForeground(Color.green);
        this.add(btn31);

        btn12 = new JButton("Regresar");
        btn12.setBounds(5, 140, 90, 30);
        btn12.addActionListener(this);
        if (v1) {
            btn12.setEnabled(false);
        }
        btn12.setForeground(Color.blue);
        btn12.setEnabled(false);
        this.add(btn12);

        btn22 = new JButton("Regresar");
        btn22.setBounds(5, 305, 90, 30);
        btn22.addActionListener(this);
        if (v2) {
            btn22.setEnabled(false);
        }
        btn22.setForeground(Color.blue);
        btn22.setEnabled(false);
        this.add(btn22);

        btn32 = new JButton("Regresar");
        btn32.setBounds(5, 470, 90, 30);
        btn32.addActionListener(this);
        if (v3) {
            btn32.setEnabled(false);
        }
        btn32.setForeground(Color.blue);
        btn32.setEnabled(false);
        this.add(btn32);
        //Aquí termino la cosa de los botones
//***********************************************************************************************************************************************

        int y = 0;//Esto es para posicionar todo donde quiero que esté
        //********************************************************************************************************************************************************
        //Generación de las posiciones de los viajes
        for (int i = 0; i < UDrive.ruta.length; i++) {
            if (i == 0) {
                if (UDrive.ruta[i] < 3) {//La generación de los autos con sus respectivas posiciones
                    g1 = 6;
                    a = 0.1;
                    ImageIcon imagenIcono1 = new ImageIcon(getClass().getResource("./v/moto.png"));
                    Image imageDimension1 = imagenIcono1.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                    ImageIcon imagenadjustada1 = new ImageIcon(imageDimension1);
                    LabelImagen1 = new JLabel(imagenadjustada1); //Label de la iamgen
                    LabelImagen1.setBounds(po1, 75 + 165 * y, 125, 160);
                    this.add(LabelImagen1);

                    lbl11 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                    lbl11.setBounds(10, 40 + 165 * y, 150, 30);
                    lbl11.setFont(new Font("Arial", Font.BOLD, 20));
                    this.add(lbl11);

                    lbl12 = new JLabel("Distancia: " + d1);
                    lbl12.setBounds(10, 80 + 165 * y, 150, 30);
                    this.add(lbl12);

                    lbl13 = new JLabel("Destino: " + D1);
                    lbl13.setBounds(10, 100 + 165 * y, 150, 30);
                    this.add(lbl13);

                    lbl14 = new JLabel("Inicio: " + I1);
                    lbl14.setBounds(850, 40 + 165 * y, 300, 30);
                    lbl14.setFont(new Font("Arial", Font.BOLD, 20));
                    this.add(lbl14);

                    lbl15 = new JLabel("Recorrido: ");
                    lbl15.setBounds(po1, 70 + 165 * y, 150, 30);
                    this.add(lbl15);

                    lbl16 = new JLabel("Gasolina actual: " + g1 + "gal");
                    lbl16.setBounds(po1, 85 + 165 * y, 200, 30);
                    this.add(lbl16);

                    btn13 = new JButton("Recargar");
                    btn13.setBounds(965, 150 + 165 * y, 100, 20);
                    btn13.setForeground(Color.red);
                    btn13.addActionListener(this);
                    btn13.setVisible(false);
                    this.add(btn13);

                } else {
                    if (UDrive.ruta[i] < 6) {
                        g1 = 10;
                        a = 0.3;
                        ImageIcon imagenIcono1 = new ImageIcon(getClass().getResource("./v/picanto.png"));
                        Image imageDimension1 = imagenIcono1.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                        ImageIcon imagenadjustada1 = new ImageIcon(imageDimension1);
                        LabelImagen1 = new JLabel(imagenadjustada1); //Label de la iamgen
                        LabelImagen1.setBounds(po1, 80 + 165 * y, 125, 160);
                        this.add(LabelImagen1);

                        lbl11 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                        lbl11.setBounds(10, 40 + 165 * y, 200, 30);
                        lbl11.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl11);

                        lbl12 = new JLabel("Distancia: " + d1);
                        lbl12.setBounds(10, 80 + 165 * y, 150, 30);
                        this.add(lbl12);

                        lbl13 = new JLabel("Destino: " + D1);
                        lbl13.setBounds(10, 100 + 165 * y, 150, 30);
                        this.add(lbl13);

                        lbl14 = new JLabel("Inicio: " + I1);
                        lbl14.setBounds(850, 40 + 165 * y, 300, 30);
                        lbl14.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl14);

                        lbl15 = new JLabel("Recorrido: " + r1 + "km");
                        lbl15.setBounds(po1, 80 + 165 * y, 150, 30);
                        this.add(lbl15);

                        lbl16 = new JLabel("Gasolina actual: " + g1 + "gal");
                        lbl16.setBounds(po1, 95 + 165 * y, 200, 30);
                        this.add(lbl16);

                        btn13 = new JButton("Recargar");
                        btn13.setBounds(965, 150 + 165 * y, 100, 20);
                        btn13.setForeground(Color.red);
                        btn13.addActionListener(this);
                        btn13.setVisible(false);
                        this.add(btn13);

                    } else {
                        g1 = 12;
                        a = 0.45;
                        ImageIcon imagenIcono1 = new ImageIcon(getClass().getResource("./v/tesla.png"));
                        Image imageDimension1 = imagenIcono1.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                        ImageIcon imagenadjustada1 = new ImageIcon(imageDimension1);
                        LabelImagen1 = new JLabel(imagenadjustada1); //Label de la iamgen
                        LabelImagen1.setBounds(po1, 90 + 165 * y, 125, 160);
                        this.add(LabelImagen1);

                        lbl11 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                        lbl11.setBounds(10, 40 + 165 * y, 200, 30);
                        lbl11.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl11);

                        lbl12 = new JLabel("Distancia: " + d1);
                        lbl12.setBounds(10, 80 + 165 * y, 150, 30);
                        this.add(lbl12);

                        lbl13 = new JLabel("Destino: " + D1);
                        lbl13.setBounds(10, 100 + 165 * y, 150, 30);
                        this.add(lbl13);

                        lbl14 = new JLabel("Inicio: " + I1);
                        lbl14.setBounds(850, 40 + 165 * y, 300, 30);
                        lbl14.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl14);

                        lbl15 = new JLabel("Recorrido: " + r1 + "km");
                        lbl15.setBounds(po1, 95 + 165 * y, 150, 30);
                        this.add(lbl15);

                        lbl16 = new JLabel("Gasolina actual: " + g1 + "gal");
                        lbl16.setBounds(po1, 115 + 165 * y, 200, 30);
                        this.add(lbl16);

                        btn13 = new JButton("Recargar");
                        btn13.setBounds(965, 150 + 165 * y, 100, 20);
                        btn13.setForeground(Color.red);
                        btn13.addActionListener(this);
                        btn13.setVisible(false);
                        this.add(btn13);

                    }
                }
            } else {
                if (i == 1) {
                    if (UDrive.ruta[i] < 3) {//La generación de los autos con sus respectivas posiciones
                        g2 = 6;
                        b = 0.1;

                        ImageIcon imagenIcono2 = new ImageIcon(getClass().getResource("./v/moto.png"));
                        Image imageDimension2 = imagenIcono2.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                        ImageIcon imagenadjustada2 = new ImageIcon(imageDimension2);
                        LabelImagen2 = new JLabel(imagenadjustada2); //Label de la iamgen
                        LabelImagen2.setBounds(po2, 75 + 165 * y, 125, 160);
                        this.add(LabelImagen2);

                        lbl21 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                        lbl21.setBounds(10, 40 + 165 * y, 150, 30);
                        lbl21.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl21);

                        lbl22 = new JLabel("Distancia: " + d2);
                        lbl22.setBounds(10, 80 + 165 * y, 150, 30);
                        this.add(lbl22);

                        lbl23 = new JLabel("Destino: " + D2);
                        lbl23.setBounds(10, 100 + 165 * y, 150, 30);
                        this.add(lbl23);

                        lbl24 = new JLabel("Inicio: " + I2);
                        lbl24.setBounds(850, 40 + 165 * y, 300, 30);
                        lbl24.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl24);

                        lbl25 = new JLabel("Recorrido: " + r2 + "km");
                        lbl25.setBounds(po2, 70 + 165 * y, 150, 30);
                        this.add(lbl25);

                        lbl26 = new JLabel("Gasolina actual: " + g2 + "gal");
                        lbl26.setBounds(po2, 85 + 165 * y, 200, 30);
                        this.add(lbl26);

                        btn23 = new JButton("Recargar");
                        btn23.setBounds(965, 150 + 165 * y, 100, 20);
                        btn23.setForeground(Color.red);
                        btn23.addActionListener(this);
                        btn23.setVisible(false);
                        this.add(btn23);

                    } else {
                        if (UDrive.ruta[i] < 6) {
                            g2 = 10;
                            b = 0.3;
                            ImageIcon imagenIcono2 = new ImageIcon(getClass().getResource("./v/picanto.png"));
                            Image imageDimension2 = imagenIcono2.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                            ImageIcon imagenadjustada2 = new ImageIcon(imageDimension2);
                            LabelImagen2 = new JLabel(imagenadjustada2); //Label de la iamgen
                            LabelImagen2.setBounds(po2, 80 + 165 * y, 125, 160);
                            this.add(LabelImagen2);

                            lbl21 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                            lbl21.setBounds(10, 40 + 165 * y, 200, 30);
                            lbl21.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl21);

                            lbl22 = new JLabel("Distancia: " + d2);
                            lbl22.setBounds(10, 80 + 165 * y, 150, 30);
                            this.add(lbl22);

                            lbl23 = new JLabel("Destino: " + D2);
                            lbl23.setBounds(10, 100 + 165 * y, 150, 30);
                            this.add(lbl23);

                            lbl24 = new JLabel("Inicio: " + I2);
                            lbl24.setBounds(850, 40 + 165 * y, 300, 30);
                            lbl24.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl24);

                            lbl25 = new JLabel("Recorrido: " + r2 + "km");
                            lbl25.setBounds(po2, 80 + 165 * y, 150, 30);
                            this.add(lbl25);

                            lbl26 = new JLabel("Gasolina actual: " + g2 + "gal");
                            lbl26.setBounds(po2, 95 + 165 * y, 200, 30);
                            this.add(lbl26);

                            btn23 = new JButton("Recargar");
                            btn23.setBounds(965, 150 + 165 * y, 100, 20);
                            btn23.setForeground(Color.red);
                            btn23.addActionListener(this);
                            btn23.setVisible(false);
                            this.add(btn23);

                        } else {
                            g2 = 12;
                            b = 0.45;
                            ImageIcon imagenIcono2 = new ImageIcon(getClass().getResource("./v/tesla.png"));
                            Image imageDimension2 = imagenIcono2.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                            ImageIcon imagenadjustada2 = new ImageIcon(imageDimension2);
                            LabelImagen2 = new JLabel(imagenadjustada2); //Label de la iamgen
                            LabelImagen2.setBounds(po2, 90 + 165 * y, 125, 160);
                            this.add(LabelImagen2);

                            lbl21 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                            lbl21.setBounds(10, 40 + 165 * y, 200, 30);
                            lbl21.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl21);

                            lbl22 = new JLabel("Distancia: " + d2);
                            lbl22.setBounds(10, 80 + 165 * y, 150, 30);
                            this.add(lbl22);

                            lbl23 = new JLabel("Destino: " + D2);
                            lbl23.setBounds(10, 100 + 165 * y, 150, 30);
                            this.add(lbl23);

                            lbl24 = new JLabel("Inicio: " + I2);
                            lbl24.setBounds(850, 40 + 165 * y, 300, 30);
                            lbl24.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl24);

                            lbl25 = new JLabel("Recorrido: " + r2 + "km");
                            lbl25.setBounds(po2, 95 + 165 * y, 150, 30);
                            this.add(lbl25);

                            lbl26 = new JLabel("Gasolina actual: " + g2 + "gal");
                            lbl26.setBounds(po2, 115 + 165 * y, 200, 30);
                            this.add(lbl26);

                            btn23 = new JButton("Recargar");
                            btn23.setBounds(965, 150 + 165 * y, 100, 20);
                            btn23.setForeground(Color.red);
                            btn23.addActionListener(this);
                            btn23.setVisible(false);
                            this.add(btn23);

                        }
                    }

                } else {
                    if (UDrive.ruta[i] < 3) {//La generación de los autos con sus respectivas posiciones
                        g3 = 6;
                        c = 0.1;
                        ImageIcon imagenIcono3 = new ImageIcon(getClass().getResource("./v/moto.png"));
                        Image imageDimension3 = imagenIcono3.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                        ImageIcon imagenadjustada3 = new ImageIcon(imageDimension3);
                        LabelImagen3 = new JLabel(imagenadjustada3); //Label de la iamgen
                        LabelImagen3.setBounds(po3, 75 + 165 * y, 125, 160);
                        this.add(LabelImagen3);

                        lbl31 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                        lbl31.setBounds(10, 40 + 165 * y, 150, 30);
                        lbl31.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl31);

                        lbl32 = new JLabel("Distancia: " + d3);
                        lbl32.setBounds(10, 80 + 165 * y, 150, 30);
                        this.add(lbl32);

                        lbl33 = new JLabel("Destino: " + D3);
                        lbl33.setBounds(10, 100 + 165 * y, 150, 30);
                        this.add(lbl33);

                        lbl34 = new JLabel("Inicio: " + I3);
                        lbl34.setBounds(850, 40 + 165 * y, 300, 30);
                        lbl34.setFont(new Font("Arial", Font.BOLD, 20));
                        this.add(lbl34);

                        lbl35 = new JLabel("Recorrido: " + r3 + "km");
                        lbl35.setBounds(po3, 70 + 165 * y, 150, 30);
                        this.add(lbl35);

                        lbl36 = new JLabel("Gasolina actual: " + g3 + "gal");
                        lbl36.setBounds(po3, 85 + 165 * y, 200, 30);
                        this.add(lbl36);

                        btn33 = new JButton("Recargar");
                        btn33.setBounds(965, 150 + 165 * y, 100, 20);
                        btn33.setForeground(Color.red);
                        btn33.addActionListener(this);
                        btn33.setVisible(false);
                        this.add(btn33);

                    } else {
                        if (UDrive.ruta[i] < 6) {
                            g3 = 10;
                            c = 0.3;
                            ImageIcon imagenIcono3 = new ImageIcon(getClass().getResource("./v/picanto.png"));
                            Image imageDimension3 = imagenIcono3.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                            ImageIcon imagenadjustada3 = new ImageIcon(imageDimension3);
                            LabelImagen3 = new JLabel(imagenadjustada3); //Label de la iamgen
                            LabelImagen3.setBounds(po3, 80 + 165 * y, 125, 160);
                            this.add(LabelImagen3);

                            lbl31 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                            lbl31.setBounds(10, 40 + 165 * y, 200, 30);
                            lbl31.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl31);

                            lbl32 = new JLabel("Distancia: " + d3);
                            lbl32.setBounds(10, 80 + 165 * y, 150, 30);
                            this.add(lbl32);

                            lbl33 = new JLabel("Destino: " + D3);
                            lbl33.setBounds(10, 100 + 165 * y, 150, 30);
                            this.add(lbl33);

                            lbl34 = new JLabel("Inicio: " + I3);
                            lbl34.setBounds(850, 40 + 165 * y, 300, 30);
                            lbl34.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl34);

                            lbl35 = new JLabel("Recorrido: " + r3 + "km");
                            lbl35.setBounds(po3, 80 + 165 * y, 150, 30);
                            this.add(lbl35);

                            lbl36 = new JLabel("Gasolina actual: " + g3 + "gal");
                            lbl36.setBounds(po3, 95 + 165 * y, 200, 30);
                            this.add(lbl36);

                            btn33 = new JButton("Recargar");
                            btn33.setBounds(965, 150 + 165 * y, 100, 20);
                            btn33.setForeground(Color.red);
                            btn33.addActionListener(this);
                            btn33.setVisible(false);
                            this.add(btn33);

                        } else {
                            g3 = 12;
                            c = 0.45;
                            ImageIcon imagenIcono3 = new ImageIcon(getClass().getResource("./v/tesla.png"));
                            Image imageDimension3 = imagenIcono3.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH);
                            ImageIcon imagenadjustada3 = new ImageIcon(imageDimension3);
                            LabelImagen3 = new JLabel(imagenadjustada3); //Label de la iamgen
                            LabelImagen3.setBounds(po3, 90 + 165 * y, 125, 160);
                            this.add(LabelImagen3);

                            lbl31 = new JLabel(UDrive.vehiculo[UDrive.ruta[i]]);
                            lbl31.setBounds(10, 40 + 165 * y, 200, 30);
                            lbl31.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl31);

                            lbl32 = new JLabel("Distancia: " + d3);
                            lbl32.setBounds(10, 80 + 165 * y, 150, 30);
                            this.add(lbl32);

                            lbl33 = new JLabel("Destino: " + D3);
                            lbl33.setBounds(10, 100 + 165 * y, 150, 30);
                            this.add(lbl33);

                            lbl34 = new JLabel("Inicio: " + I3);
                            lbl34.setBounds(850, 40 + 165 * y, 300, 30);
                            lbl34.setFont(new Font("Arial", Font.BOLD, 20));
                            this.add(lbl34);

                            lbl35 = new JLabel("Recorrido: " + r3 + "km");
                            lbl35.setBounds(po3, 95 + 165 * y, 150, 30);
                            this.add(lbl35);

                            lbl36 = new JLabel("Gasolina actual: " + g3 + "gal");
                            lbl36.setBounds(po3, 115 + 165 * y, 200, 30);
                            this.add(lbl36);

                            btn33 = new JButton("Recargar");
                            btn33.setBounds(965, 150 + 165 * y, 100, 20);
                            btn33.setForeground(Color.red);
                            btn33.addActionListener(this);
                            btn33.setVisible(false);
                            this.add(btn33);
                        }
                    }
                }
            }

            y++;
        }
        //Fin de la generación de los viajes

        //*****************************************************************************************************************************************
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
        if (e.getSource() == btn01) {
            this.dispose();
        }
        if (e.getSource() == btn02) {

        }
        if (e.getSource() == btn03) {
            if (!UDrive.disponible[0] && !UDrive.disponible[1] && !UDrive.disponible[2]) {
                gas1 = g1;
                gas2 = g2;
                gas3 = g3;
                Ruta1 t1 = new Ruta1(this);
                t1.start();
                Ruta2 t2 = new Ruta2(this);
                t2.start();
                Ruta3 t3 = new Ruta3(this);
                t3.start();
                btn21.setEnabled(false);
                b2 = true;
                btn31.setEnabled(false);
                b3 = true;
                btn11.setEnabled(false);
                b1 = true;
                LocalDateTime now1 = LocalDateTime.now();
                ti1 = now1.format(formato);
                LocalDateTime now2 = LocalDateTime.now();
                ti2 = now2.format(formato);
                LocalDateTime now3 = LocalDateTime.now();
                ti3 = now3.format(formato);
            }

        }
        if (e.getSource() == btn11) {//Botón de inicio
            gas1 = g1;
            Ruta1 tu = new Ruta1(this);
            tu.start();
            btn11.setEnabled(false);
            b1 = true;
            LocalDateTime now = LocalDateTime.now();
            ti1 = now.format(formato);

        }
        if (e.getSource() == btn12) {//Botón de regreso
            Viajes.rec1 = 0;
            Ruta11 ru = new Ruta11(this);
            ru.start();
            btn12.setEnabled(false);
            v1 = true;
        }
        if (e.getSource() == btn13) {//Este es el botón de recarga
            if (v1) {
                gas1 = g1;
                Ruta11 ru = new Ruta11(this);
                ru.start();
                btn13.setVisible(false);
            } else {
                gas1 = g1;
                Ruta1 ru = new Ruta1(this);
                ru.start();
                btn13.setVisible(false);
            }

        }
        if (e.getSource() == btn21) {//este es el botón de inicio
            gas2 = g2;
            Ruta2 tu = new Ruta2(this);
            tu.start();
            btn21.setEnabled(false);
            b2 = true;
            LocalDateTime now = LocalDateTime.now();
            ti2 = now.format(formato);

        }
        if (e.getSource() == btn22) {//Este es el botón de regreso
            Viajes.rec2 = 0;
            Ruta22 ru = new Ruta22(this);
            ru.start();
            btn22.setEnabled(false);
            v2 = true;
        }
        if (e.getSource() == btn23) {//Este es el botón de recarga
            if (v2) {
                gas2 = g2;
                Ruta22 ru = new Ruta22(this);
                ru.start();
                btn23.setVisible(false);
            } else {
                gas2 = g2;
                Ruta2 ru = new Ruta2(this);
                ru.start();
                btn23.setVisible(false);
            }
        }
        if (e.getSource() == btn31) {//este es el botón de inicio
            gas3 = g3;
            Ruta3 tu = new Ruta3(this);
            tu.start();
            btn31.setEnabled(false);
            b3 = true;
            LocalDateTime now = LocalDateTime.now();
            ti3 = now.format(formato);

        }
        if (e.getSource() == btn32) {//Este es el botón de regreso
            Viajes.rec3 = 0;
            Ruta33 ru = new Ruta33(this);
            ru.start();
            btn32.setEnabled(false);
            v3 = true;
        }
        if (e.getSource() == btn33) {//Este es el botón de recarga
            if (v3) {
                gas3 = g3;
                Ruta33 ru = new Ruta33(this);
                ru.start();
                btn33.setVisible(false);
            } else {
                gas3 = g3;
                Ruta3 ru = new Ruta3(this);
                ru.start();
                btn33.setVisible(false);
            }
        }

    }

}
