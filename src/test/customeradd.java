package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class customeradd extends customerxx implements ActionListener {

	
		
		private Connection ct = null;  
	    private PreparedStatement ps = null;  
	    private ResultSet rs = null;  

	    private JLabel a = new JLabel("新增客户编号");
	    private JLabel b1 = new JLabel("客户姓名");
	    private JLabel c = new JLabel("性别");
	    private JLabel d = new JLabel("联系电话");
	    private JLabel e1 = new JLabel("公司地址");
	    private JLabel f = new JLabel("登录密码");
	    private JLabel g = new JLabel("再输一次登录密码");
	   
	    private JTextField d1=new JTextField();
	    private JTextField d2=new JTextField();
	    //private JTextField d3=new JTextField();
	    private JTextField d4=new JTextField();
	    private JTextField d5=new JTextField();

	    private JComboBox jcb=new JComboBox();
	    //private JTextField d7=new JTextField();
	    private JPasswordField d6=new JPasswordField(); 
	    private JPasswordField d7=new JPasswordField();
	 

	    private JButton bt = new JButton("添加");
	    private JButton bt1 = new JButton("重置");


		@Override
		public void actionPerformed(ActionEvent e) {
			
	   
	       
	        
	     //面板设置
	        JFrame window=new JFrame();
	        JPanel w=new JPanel();
	        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        String str1[] = {"男", "女"};  
	        jcb = new JComboBox(str1);  
	        try{
	     			//int i=null;
	                 Class.forName("com.mysql.jdbc.Driver");
	                 System.out.println("JBDC 加载成功!");
	                 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
	                 ps = ct.prepareStatement("SELECT * FROM customer");//3.访问数据库
	                 rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
	      
	             }catch(Exception a){
	                 System.out.println("JBDC gg!");
	                 a.printStackTrace();
	             }
	           
	           
	        
	        w.setLayout(new GridLayout(10,2));
	        window.setTitle("添加客户信息");
	        window.setSize(350,400);
	        window.setVisible(true); 
	        window.add(w);
	        w.add(a);
	        w.add(d1);
	        w.add(b1);
	        w.add(d2);
	        w.add(c);
	        w.add(jcb);
	        w.add(d);
	        w.add(d4);
	        w.add(e1); 
	        w.add(d5);  
	        w.add(f);
	        w.add(d6);
	        w.add(g);
	        w.add(d7);
	      
	        
	     
	       
	  
	     
	        
	        dingdanaddok ok1=new dingdanaddok();
		       bt.addActionListener(ok1);
		       dingdanaddre re1=new dingdanaddre();
		       bt1.addActionListener(re1);

	        w.add(bt);
	        w.add(bt1);
	             
	             
	}
		  //重置按钮事件
			public class dingdanaddre implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					d1.setText("");
					d2.setText("");
				
					d4.setText("");
					d5.setText("");
				
					d6.setText("");
					d7.setText("");
				
				
				
					
				}
				}
		
		
		
		
	      //添加按钮事件（具体的数据插入操作）
		public class dingdanaddok implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				  String sql = "INSERT INTO customer(cid,cname,csex,cnumber,ccode,ccomname) "
			                + "values(?,?,?,?,?,?)";   //数据库操作
				  
				  
				  if(!(new String(d6.getPassword())).equals(new String(d7.getPassword())))
				{
					JOptionPane.showMessageDialog(null, "两次密码不一致", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				  
				  
				  
				  
				try{
					//int i=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            System.out.println("JBDC 加载成功!");
		
		            
		        }catch(Exception a){
		            System.out.println("JBDC gg!");
		            a.printStackTrace();
		        }
				
		        try{
		            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root",""); //连接数据库
		            ps=ct.prepareStatement(sql);  //访问数据库
		            
		             
		            ps.setString(1,d1.getText());		  
		            ps.setString(2,d2.getText());		          
		            ps.setString(3,(String) jcb.getSelectedItem());
		            ps.setString(4,d4.getText());
		            ps.setString(5,d5.getText()); 
		            ps.setString(6,new String(d6.getPassword()));
		            
		            
		      
		            
		            //1 2 3 4 5 6 7 8代表（？？？？？？？？）

		            ps.executeUpdate();
		             
		            //System.out.println("MySQL 连接成功!");
		            //stat = conn.createStatement();
		            //stat.executeUpdate(sql);
		            //System.out.println("插入数据成功!");
		            JOptionPane.showMessageDialog(null, "添加成功");
		            
		            
		            b4.doClick();
		            
		                 
		             
		        }catch (SQLException b){
		            b.printStackTrace();     
		            JOptionPane.showMessageDialog(null, "请勿输入重复客户编号", "添加失败", JOptionPane.ERROR_MESSAGE);
		        }finally{
		            try{
		                ct.close();
		                System.out.println("MySQL 关闭成功");
		            }catch (SQLException c){
		                System.out.println("MySQL 关闭失败 ");
		                c.printStackTrace();
		            }
		             
		        }

		}
		}
	        
	        
		}
	        