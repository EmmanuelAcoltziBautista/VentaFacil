/*
Autor:Emmanuel Acoltzi Bautista
Ubicacion:Mexico.Tlaxcala
Fecha:19/07/2023
correo electronico :basedeemma@gmail.com
correo electronico personal:emmaacoltzibautista@gmail.com
*/
package ventana;
import Conexion.Conexion;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PRODUCTO_NUEVO extends JFrame implements ActionListener{
   private JLabel label1,label2,label3,label4,label5;
   private JTextField TEXTO1,TEXTO2;
   private JButton BOTON1,BOTON2;
   String conexion,usuario,contrasena;
    public PRODUCTO_NUEVO(){
   setLayout(null);
   setTitle("Agregar Producto");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
   
  setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
  
   
   label1=new JLabel("Agregar producto");
   label1.setForeground(new Color(255,255,255));
   label1.setFont(new Font("Andale Mono",1,20));
   label1.setBounds(100,10,200,30);
   add(label1);
   
   label2=new JLabel("Nombre producto:");
   label2.setForeground(new Color(255,255,255));
   label2.setBounds(10,80,200,30);
   add(label2);
   
   TEXTO1=new JTextField();
   TEXTO1.setBounds(210,80,200,30);
   add(TEXTO1);
   
   label3=new JLabel("Precio producto:");
   label3.setForeground(new Color(255,255,255));
   label3.setBounds(10,130,200,30);
   add(label3);
   
   TEXTO2=new JTextField();
   TEXTO2.setBounds(210,130,200,30);
   add(TEXTO2);
   
   BOTON1=new JButton("Agregar");
   BOTON1.setBackground(new Color(255,255,255));
   BOTON1.setBounds(10,180,200,30);
   BOTON1.addActionListener(this);
   add(BOTON1);
   
   
   BOTON2=new JButton("Regresar");
   BOTON2.setBackground(new Color(255,255,255));
   BOTON2.setBounds(10,10,90,30);
   BOTON2.addActionListener(this);
   add(BOTON2);
   
   label4=new JLabel("Creado por Emmanuel Acoltzi Bautista Email:emmaacoltzibautista@gmail.com");
   label4.setForeground(new Color(255,255,255));
   label4.setFont(new Font("Arial",1,12));
   label4.setBounds(10,230,500,30);
   add(label4);
          
   Conexion C=new Conexion();
   conexion=C.Con();
   usuario=C.Usu();
   contrasena=C.Contra();
   
   label5=new JLabel();
   label5.setBounds(0,0,500,500);
   add(label5);
   
   ImageIcon im=new ImageIcon("src/ventana/fondo.jpg");
   Icon i=new ImageIcon(im.getImage().getScaledInstance(label5.getWidth(),label5.getHeight(),Image.SCALE_DEFAULT));
   label5.setIcon(i);
   
    }
    @Override
    public void actionPerformed(ActionEvent A){
        if(A.getSource()==BOTON1){
        try{
        Connection cn=DriverManager.getConnection(conexion,usuario,contrasena);
        PreparedStatement pst=cn.prepareStatement("insert into PRODUCTOS values (?,?,?)");
        pst.setString(1,"0");
        pst.setString(2,TEXTO1.getText());
        pst.setString(3,TEXTO2.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Creado");
        
        }catch(Exception E){
        System.out.println(E);
        }    
        }
        if(A.getSource()==BOTON2){
            Principal P=new Principal();
    P.setBounds(0,0,500,400);
    P.setLocationRelativeTo(null);
    P.setVisible(true);
    this.setVisible(false);
        }
    }
    public static void main(String args[]){
   PRODUCTO_NUEVO P=new PRODUCTO_NUEVO();
   P.setBounds(0,0,500,500);
   P.setVisible(true);
   P.setLocationRelativeTo(null);
    }
}
