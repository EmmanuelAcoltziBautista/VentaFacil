/*
Autor:Emmanuel Acoltzi Bautista
Ubicacion:Mexico.Tlaxcala
Fecha:19/07/2023
correo electronico :basedeemma@gmail.com
correo electronico personal:emmaacoltzibautista@gmail.com
*/
package ventana;
import javax.swing.*;
import Conexion.Conexion;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ActualizarProducto extends JFrame implements ActionListener{
private JLabel label1,label2,label3,label4,label5;
private JComboBox COMBO1;
private JTextField TEXTO1,TEXTO2;
private JButton BOTON1,BOTON2,BOTON3,BOTON4;
String Conex="";
String usu="";
String pass="";
int idProducto;
public ActualizarProducto(){
setLayout(null);

setDefaultCloseOperation(EXIT_ON_CLOSE);

setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());

Conexion con=new Conexion();
Conex=con.Con();
usu=con.Usu();
pass=con.Contra();

label1=new JLabel("Actualizar producto");
label1.setFont(new Font("Andale Mono",1,20));
label1.setForeground(new Color(255,255,255));
label1.setBounds(100,10,300,30);
add(label1);




COMBO1=new JComboBox();
try{
    Connection cn=DriverManager.getConnection(Conex,usu,pass);
    PreparedStatement pst=cn.prepareStatement("SELECT * FROM PRODUCTOS");
    ResultSet rs=pst.executeQuery();
    while(rs.next()){
        COMBO1.addItem(rs.getString("PRODUCTO"));
    }
}catch(Exception E){
System.out.println(E);
}
COMBO1.setBounds(10,80,200,30);
add(COMBO1);

BOTON1=new JButton("Actualizar");
BOTON1.setBackground(new Color(255,255,255));
BOTON1.setBounds(250,80,200,30);
BOTON1.addActionListener(this);
add(BOTON1);

label2=new JLabel("Producto:");
label2.setFont(new Font("Andale Mono",1,12));
label2.setForeground(new Color(255,255,255));
label2.setBounds(10,130,200,30);
add(label2);

TEXTO1=new JTextField();
TEXTO1.setBounds(200,130,200,30);
add(TEXTO1);

label3=new JLabel("Precio:");
label3.setFont(new Font("Ariañ",1,12));
label3.setForeground(new Color(255,255,255));
label3.setBounds(10,180,200,30);
add(label3);

TEXTO2=new JTextField();
TEXTO2.setBounds(200,180,200,30);
add(TEXTO2);

BOTON2=new JButton("Actualizar");
BOTON2.setBackground(new Color(255,255,255));
BOTON2.setBounds(10,230,200,30);
BOTON2.addActionListener(this);
add(BOTON2);

BOTON3=new JButton("Eliminar");
BOTON3.setBackground(new Color(255,255,255));
BOTON3.setBounds(230,230,200,30);
BOTON3.addActionListener(this);
add(BOTON3);

BOTON4=new JButton("Regresar");
BOTON4.setBackground(new Color(255,255,255));
BOTON4.setBounds(10,10,90,30);
BOTON4.addActionListener(this);
add(BOTON4);

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
    String busqueda=(String)COMBO1.getSelectedItem();
    try{
    Connection cn1=DriverManager.getConnection(Conex,usu,pass);
    PreparedStatement pst1=cn1.prepareStatement("select * from productos where producto='"+busqueda+"'");
    ResultSet rs1=pst1.executeQuery();
    if(rs1.next()){
    TEXTO1.setText(rs1.getString("Producto"));
    TEXTO2.setText(rs1.getString("precio"));
    idProducto=Integer.parseInt(rs1.getString("id"));
    }
    }catch(Exception E){}
    }
    if(A.getSource()==BOTON4){
     Principal P=new Principal();
    P.setBounds(0,0,500,400);
    P.setLocationRelativeTo(null);
    P.setVisible(true);
    this.setVisible(false);
    }
    if(A.getSource()==BOTON2){
        //actualizo
        try{
        Connection cn2=DriverManager.getConnection(Conex,usu,pass);
        PreparedStatement pst2=cn2.prepareStatement("update productos set producto=?, precio=? where id='"+idProducto+"'");
        pst2.setString(1, TEXTO1.getText().trim());
        pst2.setString(2,TEXTO2.getText().trim());
        pst2.executeUpdate();
        JOptionPane.showMessageDialog(null, "La actualizacion se realizo con exito");
        }catch(Exception E){}
    }
    if(A.getSource()==BOTON3){
    try{
    Connection cn3=DriverManager.getConnection(Conex,usu,pass);
    PreparedStatement pst3=cn3.prepareStatement("delete from productos where id='"+idProducto+"'");
    pst3.executeUpdate();
    JOptionPane.showMessageDialog(null,"El producto se elimino con exito");
    }catch(Exception E){}
    }
    
}
public static void main(String args[]){
       ActualizarProducto AP=new ActualizarProducto(); 
       AP.setBounds(0,0,500,500);
       AP.setVisible(true);
       AP.setLocationRelativeTo(null);
       AP.setResizable(true);
    }
}
