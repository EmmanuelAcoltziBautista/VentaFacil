/*
Autor:Emmanuel Acoltzi Bautista
Ubicacion:Mexico.Tlaxcala
Fecha:19/07/2023
correo electronico :basedeemma@gmail.com
correo electronico personal:emmaacoltzibautista@gmail.com
*/
package ventana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Principal extends JFrame implements ActionListener{
private JLabel label1,label2,label5;
private JButton BOTON1,BOTON2,BOTON3;
    public Principal(){
setLayout(null);
setTitle("VentaFacil");
setDefaultCloseOperation(EXIT_ON_CLOSE);

setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());

label1=new JLabel("VentaFacil");
label1.setForeground(new Color(255,255,255));
label1.setFont(new Font("Andale Mono",1,20));
label1.setBounds(200,10,300,30);
add(label1);

BOTON1=new JButton("Agregar nuevo producto");
BOTON1.setBackground(new Color(255,255,255));
BOTON1.setBounds(10,80,200,30);
BOTON1.addActionListener(this);
add(BOTON1);


BOTON2=new JButton("Vender producto");
BOTON2.setBackground(new Color(255,255,255));
BOTON2.setBounds(10,130,200,30);
BOTON2.addActionListener(this);
add(BOTON2);


BOTON3=new JButton("Actualizar");
BOTON3.setBackground(new Color(255,255,255));
BOTON3.setBounds(10,180,200,30);
BOTON3.addActionListener(this);
add(BOTON3);

label2=new JLabel("Creado por Emmanuel Acoltzi Bautista emmaacoltzibautista@gmail.com ©");
label2.setFont(new Font("Arial",1,12));
label2.setForeground(new Color(255,255,255));
label2.setBounds(0,230,500,30);
add(label2);

label5=new JLabel();
label5.setBounds(0,0,500,500);
add(label5);

ImageIcon im=new ImageIcon("src/ventana/fondo.jpg");
Icon i=new ImageIcon(im.getImage().getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_DEFAULT));
label5.setIcon(i);

}
    @Override
    public void actionPerformed(ActionEvent A){
        if(A.getSource()==BOTON1){
            
   PRODUCTO_NUEVO P=new PRODUCTO_NUEVO();
   P.setBounds(0,0,500,500);
   P.setVisible(true);
   P.setLocationRelativeTo(null);
   this.setVisible(false);
        }
        if(A.getSource()==BOTON2){
        VenderProducto V=new VenderProducto();
    V.setBounds(0,0,500,500);
    V.setVisible(true);
    V.setResizable(false);
    V.setLocationRelativeTo(null);
    this.setVisible(false);
        }
        if(A.getSource()==BOTON3){
         ActualizarProducto AP=new ActualizarProducto(); 
       AP.setBounds(0,0,500,500);
       AP.setVisible(true);
       AP.setLocationRelativeTo(null);
       AP.setResizable(true);
       this.setVisible(false);
        
        }
    }
    public static void main(String args[]){
    Principal P=new Principal();
    P.setBounds(0,0,500,400);
    P.setLocationRelativeTo(null);
    P.setVisible(true);
    }    }