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
import java.io.*;
public class Cargando extends JFrame implements ActionListener{
    private JLabel label1,label2,label3;
  public Cargando(){
      setLayout(null);
      setTitle("Cargando...");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  
      setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
      
    label1=new JLabel("Cargando...");
    label1.setForeground(new Color(255,255,255));
    label1.setFont(new Font("Andale Mono",1,20));
    label1.setBounds(200,10,200,30);
    add(label1);
    
 
    
    
    
        try{
            String tabla="cd src/mysql/bin & mysqld.exe";
                    String f= "mysql -u root"
                    + "CREATE DATABASE VentaFacil;" +
"USE VentaFacil;" +
"CREATE TABLE PRODUCTOS(" +
"ID MEDIUMINT AUTO_INCREMENT," +
"PRODUCTO CHAR(255)," +
"PRECIO CHAR(255)," +
"PRIMARY KEY(ID)" +
");";
    new ProcessBuilder("cmd","/c",tabla).inheritIO().start().waitFor();
}catch(Exception E){
System.out.print(E);
}
        
    
    
    label3=new JLabel("Creado por Emmanuel Acoltzi Bautista Email:emmaacoltzibautista@gmail.com");
    label3.setFont(new Font("Arial",1,12));
    label3.setForeground(new Color(255,255,255));
    label3.setBounds(10,130,500,30);
    add(label3);
        
    label2=new JLabel();
    label2.setBounds(0,0,500,200);
    add(label2);
ImageIcon im=new ImageIcon("src/ventana/fondo.jpg");
    Icon i=new ImageIcon(im.getImage().getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_DEFAULT));
    label2.setIcon(i);
  }
  @Override
  public void paint(Graphics G){
  super.paint(G);
  G.setColor(new Color(255,255,255));
  G.drawRect(99-50,79,301+100,31);
 
  try{
      for(int i=0;i<=400;i+=10){
      G.fillRect(50, 80, i,30);
  Thread.sleep(20);
  if(i==400){
      Principal P=new Principal();
    P.setBounds(0,0,500,500);
    P.setLocationRelativeTo(null);
    P.setVisible(true);
    this.setVisible(false);
  }
      }

  }catch(Exception E){}
  }
  @Override
 public void actionPerformed(ActionEvent A){}
    public static void main(String args[]){
        Cargando C=new Cargando();
        C.setBounds(0,0,500,200);
        C.setVisible(true);
        C.setLocationRelativeTo(null);
        C.setResizable(false);
        
}    
}