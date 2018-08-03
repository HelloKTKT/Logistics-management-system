package test;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


//打开订单信息面板
public class ddxx extends home implements ActionListener {
	
	public JButton j7=null;
	static protected JTable jt;
    protected JScrollPane jp ; 
    static int rn=-1;
    static String id;
    private Connection ct = null;  
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	
	protected static JTextField j3=new JTextField();

	//protected JLabel jl=null;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		p2.removeAll();
		p3.removeAll();
		p3.setVisible(false);
		p3.setVisible(true);
     
		p2.setBackground(Color.YELLOW); 
	
		//JTextField j3=new JTextField();
		j3.setBounds(150,60,120,20);
		JLabel j4=new JLabel("输入编号进行查询：");
		j4.setBounds(10,60,120,20);
		JButton j5=new JButton("查询订单");
		j5.setBounds(280,58,100,25);
	
		JButton j7=new JButton("订单操作");
		j7.setBounds(50,10,150,25);
		JButton j8=new JButton("待办订单");
		j8.setBounds(300,10,150,25);
		JLabel jl=new JLabel("订单信息管理界面");
		jl.setBounds(5,95,120,25);
		
		
		
	
	
		p2.add(j3);
		p2.add(j4);
		p2.add(j5);
	
		p2.add(j7);
		p2.add(jl);
		p2.add(j8);
		

	    Vector data=new Vector();
	     Vector columnNames=new Vector();
		   columnNames.add("订单编号");
		   columnNames.add("产品批号");
		   columnNames.add("货物编号");
	        columnNames.add("货物名称");
	        columnNames.add("数量（件）");
	        columnNames.add("客户编号");
	        columnNames.add("收货人");
	        columnNames.add("收货地址");
	        columnNames.add("收货人电话");
	        columnNames.add("货车牌照");
	        columnNames.add("司机电话");
	        columnNames.add("发货地");
	        columnNames.add("订单状态");
	        columnNames.add("目前位置");
		
		
	        try
			   {
		            Class.forName("com.mysql.jdbc.Driver");
		            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
		            ps = ct.prepareStatement("SELECT * FROM orders");//3.访问数据库
		            rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
		            System.out.println("jdbc ok");
		             
		        }catch(Exception d)
		        {
		            System.out.println("jdbc gg");
		            d.printStackTrace();
		        }
		        
	           try
	           {
	        	   int jkl=0;
	        	  while(rs.next()) 
	        	  {
	        		 
	        			  Vector hang = new Vector();
	        	            hang.add(rs.getString(1));
	        	            hang.add(rs.getString(2));
	        	            hang.add(rs.getString(3));
	        	            hang.add(rs.getString(4));
	        	            hang.add(rs.getString(5));
	        	            hang.add(rs.getString(6));
	        	            hang.add(rs.getString(7));
	        	            hang.add(rs.getString(8));
	        	            hang.add(rs.getString(9));
	        	            hang.add(rs.getString(10));
	        	            hang.add(rs.getString(11));
	        	            hang.add(rs.getString(12));
	        	            hang.add(rs.getString(13));
	        	            hang.add(rs.getString(14));
	        	            data.add(hang);
	        
	        		 
	        	  } 
	        	 
	           }
	           catch(Exception d)
	           {
	        	   System.out.println("ask gg!");     	  
	        	
	        	   d.printStackTrace();
	           }
			
	           finally{
	               try{
	                   rs.close();
	                   ps.close();
	                   ct.close();
	                   System.out.println("close ok");
	               }catch (SQLException o){
	                   o.printStackTrace();
	                   System.out.println("close gg");
	               }
	           }
		
		p2.setVisible(false); //刷新
		p2.setVisible(true); 
	
	 
	     	 ddchange ddc=new ddchange();
		       j7.addActionListener(ddc);
		       ddask ddask=new ddask();
		       j5.addActionListener(ddask);
		  
		         writing writing=new writing();
		         j8.addActionListener(writing);
		       
		       
	       
		// TODO Auto-generated method stub
		       
		       
		      


	
	//查询按钮事件
	/*public class ddask implements ActionListener
	{
		
		private Connection ct = null;  
	    private PreparedStatement ps = null;  
	    private ResultSet rs = null;  
	    private Vector data=new Vector();
	    private Vector columnNames=new Vector();
	    
		public void actionPerformed(ActionEvent e)
		{*/
		
			
		        
		        
			
	          jt=new JTable(data,columnNames); 
	           
	            jp = new JScrollPane(jt);   
	           
	           p3.add(jp);
	      		jp.setBounds(0, 0,700, 430);  
	      		
	      	 
			
		}
	}
	


