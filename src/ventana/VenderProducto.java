/*
Autor:Emmanuel Acoltzi Bautista
Ubicacion:Mexico.Tlaxcala
Fecha:19/07/2023
correo electronico :basedeemma@gmail.com
correo electronico personal:emmaacoltzibautista@gmail.com
*/




package ventana;
import Conexion.Conexion;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import static java.lang.Float.parseFloat;
import javax.swing.table.DefaultTableModel;
//import Conexion.Conexion;
public class VenderProducto extends JFrame implements ActionListener{
    private JLabel label1,label2,label3,label4,label5;
    private JButton BOTON1,BOTON2,BOTON3,BOTON4;
    private JScrollPane DESPLAZAR;
    private JTextField TEXTO1,TEXTO2;
    private JTextArea AREA;
    private JComboBox COMBO1;
    String Conex;
    String con;
    String usu;
    float total=0;
    String CantidadInventario;
    DefaultTableModel model =new DefaultTableModel();
    String producto="";
    
        String loquehay="";
    String precio="";
    public VenderProducto(){
setLayout(null);
setTitle("Vender Producto");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
    
    label1=new JLabel("Vender Producto");
    label1.setFont(new Font("Andale Mono",1,20));
    label1.setForeground(new Color(255,255,255));
    label1.setBounds(200,10,200,30);
    add(label1);
    
    
    AREA=new JTextArea();
    DESPLAZAR=new JScrollPane(AREA);
    DESPLAZAR.setBounds(10,80,400,200);
    add(DESPLAZAR);
    
    label3=new JLabel("Total a pagar:");
    label3.setFont(new Font("Andale Mono",1,20));
    label3.setForeground(new Color(255,255,255));
    label3.setBounds(10,300,300,30);
    add(label3);
    
    label2=new JLabel("Cantidad:");
    label2.setForeground(new Color(255,255,255));
    label2.setFont(new Font("Andale Mono",1,15));
    label2.setBounds(10,430-100,200,30);
    add(label2);
    
    TEXTO1=new JTextField();
    TEXTO1.setBounds(110,430-100,100,30);
    add(TEXTO1);
    
    COMBO1=new JComboBox();
    
    
        Conexion co=new Conexion();
        Conex=co.Con();
        usu=co.Usu();
        con=co.Contra();
        //System.out.println(Conex);
        
    
    try{
        
        
    Connection cn=DriverManager.getConnection(Conex,usu,con);
    PreparedStatement pst=cn.prepareStatement("SELECT * FROM PRODUCTOS");
    ResultSet rs=pst.executeQuery();
    while(rs.next()){
        
    COMBO1.addItem(rs.getString("PRODUCTO"));
    
    }
    }catch(Exception E){
    System.out.println(E);
    }
    COMBO1.setBounds(220,430-100,200,30);
    add(COMBO1);
    
    BOTON1=new JButton("Agregar al Tiket");
    BOTON1.setBackground(new Color(255,255,255));
    BOTON1.setBounds(10,480-100,200,30);
    BOTON1.addActionListener(this);
    add(BOTON1);
    
    
    BOTON2=new JButton("Imprimir Ticket");
    BOTON2.setBackground(new Color(255,255,255));
    BOTON2.setBounds(220,480-100,200,30);
    BOTON2.addActionListener(this);
    add(BOTON2);
    
    
    BOTON3=new JButton("Vaciar Ticket");
    BOTON3.setBackground(new Color(255,255,255));
    BOTON3.setBounds(110,480-50,200,30);
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
    Icon i=new ImageIcon(im.getImage().getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_DEFAULT));
    label5.setIcon(i);
    }
    @Override
    public void actionPerformed(ActionEvent A){
    if(A.getSource()==BOTON1){
    
        //pregunto que escogio para despues hacer mas preguntas LOL
        
        producto=(String) COMBO1.getSelectedItem();
    
      try{  
    
          Connection cn1=DriverManager.getConnection(Conex,usu,con);
      
          //pregunto en donde esta ese producto
          
          PreparedStatement pst1=cn1.prepareStatement("SELECT * FROM PRODUCTOS WHERE PRODUCTO='"+producto+"'");
          ResultSet rs1=pst1.executeQuery();
          
          //si si esta que debe de estar si no como lo eligio jajaja
          
          if(rs1.next()){
              
          
          
          float cantidad=Integer.parseInt(TEXTO1.getText());
      /* CantidadInventario=rs1.getString("CANTIDAD");
       float inventario=parseFloat(CantidadInventario);
      float in=inventario-cantidad;
      */
      
       
          //pregunto el precio del producto seleccionado
          
          precio=rs1.getString("PRECIO");
        float pre=parseFloat(precio);
        float preciototal=cantidad*pre;
        /*
      Connection cn3=DriverManager.getConnection(Conex,usu,con);
      PreparedStatement pst3=cn3.prepareStatement("update prodd");*/
        

//aqui construyo el ticket

loquehay=loquehay+"\n Cantidad: "+cantidad+"\t Producto: "+producto+"\t\t Total= $"+preciototal;

//aqui sumo el total

total=total+preciototal;

label3.setText("Total a pagar: $"+total);


AREA.setText(loquehay);
    TEXTO1.setText("");
          
          }
      }catch(Exception E){
      }
    }
    if(A.getSource()==BOTON2){
        
    //aqui imprimo
      loquehay=loquehay+"\n\n Total a pagar: $"+total;
      AREA.setText(loquehay);
      try{
      AREA.print();
      }catch(Exception E){}
    Reset();
    }
    if(A.getSource()==BOTON3){
    Reset();
    }
    if(A.getSource()==BOTON4){
     Principal P=new Principal();
    P.setBounds(0,0,500,400);
    P.setLocationRelativeTo(null);
    P.setVisible(true);
    this.setVisible(false);
    }
    }
    public void Reset(){
    AREA.setText("");
    loquehay="";
    total=0;
    label3.setText("");
    TEXTO1.setText("");
    }
    public static void main(String args[]){
    VenderProducto V=new VenderProducto();
    V.setBounds(0,0,500,500);
    V.setVisible(true);
    V.setResizable(false);
    V.setLocationRelativeTo(null);
    }

}
