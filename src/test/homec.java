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

public class homec  {
	

	protected static JPanel p1=null;
	protected static JPanel p2=null;
	protected static JPanel p3=null;
	protected static JFrame t=null;
	protected static JButton b1=new JButton("货物信息");
	protected static JButton b2=new JButton("我的订单");
	protected static JButton b3=new JButton("个人信息");

	protected static String zh=null;

	
	
	public void homecc(String vip,String no) 
    {  
        // TODO Auto-generated method stub  
 	
 	zh=no;
 JLabel jl=new JLabel("欢迎进入物流管理客户系统");
 jl.setFont(new Font("宋体", Font.PLAIN, 36));
 jl.setForeground(Color.BLUE);
 jl.setBounds(110,20,500,50);
 
 JLabel jll=new JLabel("欢迎您,"+vip+",编号："+no);
 jll.setBounds(0,0,200,20);

 
 
 		t=new JFrame("客户自助系统");
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
 	      
 	  
 	 
 	     
 	       //JButton b8= new JButton("员工信息");
 	   
 	    
 	     
 	       b1.setBounds(0,0,200,30);
 	       b2.setBounds(0,30,200,30);
 	       b3.setBounds(0,60,200,30);
 	
 
 	       
 	       p1.add(b1);
 	       p1.add(b2);
 	       p1.add(b3);
 

 	       p2.add(jl);
 	       p2.add(jll);/*
*/// add to your "external" style sheet that controls the "onload" table cell color, border width and color.




 	       
 	      
 	       
 	       lookgoods lookgoods=new lookgoods();
 	       b1.addActionListener(lookgoods);
 	       myorder myorder=new myorder();
 	       b2.addActionListener(myorder);
 	       myxx myxx=new myxx();
 	       b3.addActionListener(myxx);
 	
 	       
 	        
 	       
 	       t.addWindowListener
 	       (new WindowAdapter ()
 	       {
 	    	   public void windowClosing ( WindowEvent e )
 	    	   {
 	    		   int res=JOptionPane.showConfirmDialog(null, "是否退出程序", "离开", JOptionPane.YES_NO_OPTION);
 	    		  if(res==JOptionPane.YES_OPTION)
 	    		  {   
 	    			  System.exit(0);
 	    		  }
 	    	   }   	    	   
 	       }); 
 	       
    }  }

