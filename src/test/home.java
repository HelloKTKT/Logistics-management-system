package test;



import java.awt.Color;

import java.awt.Font;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//����Ա���

public class home  {

	
	protected static JPanel p1=null;
	protected static JPanel p2=null;
	protected static JPanel p3=null;
	protected static JFrame t=null;
	protected static JButton b1=new JButton("�ͻ�������Ϣ");
	protected static JButton b2=new JButton("������Ϣ");
	protected static JButton b3=new JButton("������Ϣ");
	protected static JButton b4=new JButton("�ͻ���Ϣ");
	protected static JButton b5=new JButton("˾����Ϣ");
	protected static JButton b6=new JButton("�ڲ�������Ϣ");
	protected static JButton b7=null;
	protected static JButton b8=new JButton("Ա����Ϣ");
	protected static String zh=null;
		
      // public static void main(String[] args)  
	 public void home11(String vip,String no) 
       {  
           // TODO Auto-generated method stub  
    	
    	zh=no;
    JLabel jl=new JLabel("��ӭ������������ϵͳ");
    jl.setFont(new Font("����", Font.PLAIN, 36));
    jl.setForeground(Color.BLUE);
    jl.setBounds(110,20,500,50);
    
    JLabel jll=new JLabel("��ӭ��,"+vip+",��ţ�"+no);
    jll.setBounds(0,0,200,20);

    
    
    		t=new JFrame("��������ϵͳ");
    		   t.setBounds(200,50,900,550);
    		   t.setLayout(null);
    		   //t.setSize(700,500);
    		    t.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    		    
    		   t.setResizable(false);
    		   t.setVisible(true);
    		   
    		    p1=new JPanel();
    		    p2=new JPanel();
    		    p3=new JPanel();
    		   
    		   p1.setBackground(Color.BLUE);  
    		   p1.setLayout(null);
    		   p2.setBackground(Color.ORANGE); 
    		   p2.setLayout(null);
    		   p3.setBackground(Color.white); 
    		   p3.setLayout(null);
    		   
    		   p1.setBounds(0,0,200,550);
    		   p2.setBounds(200,0,700,120);
    		   p3.setBounds(200,120,700,430);
    		   
    		   //p3.setLayout(new GridLayout(2,5));
    		   t.add(p1);  
    	       t.add(p2); 
    	       t.add(p3);
    		   //Container k=t.getContentPane();
    		   //k.setLayout(new BoxLayout(t,BoxLayout.X_AXIS));
    	    
    	  
    	 
    	       JButton b7= new JButton("������Ϣ");
    	       //JButton b8= new JButton("Ա����Ϣ");
    	   
    	    
    	     
    	       b1.setBounds(0,0,200,30);
    	       b2.setBounds(0,30,200,30);
    	       b3.setBounds(0,60,200,30);
    	       b4.setBounds(0,90,200,30);
    	       b5.setBounds(0,120,200,30);
    	       b6.setBounds(0,150,200,30);
    	       b7.setBounds(0,180,200,30);
    	       b8.setBounds(0,210,200,30);
    
    	       
    	       p1.add(b1);
    	       p1.add(b2);
    	       p1.add(b3);
    	       p1.add(b4);
    	       p1.add(b5);
    	       p1.add(b6);
    	       p1.add(b7);
    	       p1.add(b8);
  
    	       p2.add(jl);
    	       p2.add(jll);/*
*/// add to your "external" style sheet that controls the "onload" table cell color, border width and color.




    	       
    	      
    	       
    	       ddxx a=new ddxx();
    	       b1.addActionListener(a);
    	       hwxx hwxx=new hwxx();
    	       b2.addActionListener(hwxx);
    	       carxx carxx=new carxx();
    	       b3.addActionListener(carxx);
    	       customerxx customer=new customerxx();
    	       b4.addActionListener(customer);
    	       driverxx driverxx=new driverxx();
    	       b5.addActionListener(driverxx);
    	       formxx formxx=new formxx();
    	       b6.addActionListener(formxx);
    	       personal personal=new personal();   	       
    	       b7.addActionListener(personal);
    	       employees employees=new employees();
    	       b8.addActionListener(employees);
    	       
    	        
    	       
    	       t.addWindowListener
    	       (new WindowAdapter ()
    	       {
    	    	   public void windowClosing ( WindowEvent e )
    	    	   {
    	    		   int res=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�����", "�뿪", JOptionPane.YES_NO_OPTION);
    	    		  if(res==JOptionPane.YES_OPTION)
    	    		  {   
    	    			  System.exit(0);
    	    		  }
    	    	   }   	    	   
    	       }); 
    	       
       }  

}