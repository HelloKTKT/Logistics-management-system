package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class myxx extends homec implements ActionListener {

	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;
    static JPasswordField jt1=new JPasswordField();
    static JPasswordField jt2=new JPasswordField();
    static JPasswordField jt3=new JPasswordField();
    static String str[] = {"男", "女"}; 
    protected static JComboBox jl88=new JComboBox(str);
    
    static JTextField jl00=new JTextField();
    static JTextField jt101=new JTextField();
	@Override
	public void actionPerformed(ActionEvent e) {
		p2.removeAll();
		p3.removeAll();
		
		
		
		    JLabel jl1=new JLabel("帐号："); 
		    JLabel jl2=new JLabel("姓名：");
		    JLabel jl3=new JLabel("修改密码");
		    JLabel jl4=new JLabel("请输入原密码：");
		    JLabel jl5=new JLabel("请输入新密码：");
		    JLabel jl6=new JLabel("请再输入一次新密码：");
		    
		    JLabel jl7=new JLabel("个人信息");
		    JLabel jl8=new JLabel("性别：");
		    
		    JLabel jl10=new JLabel("联系地址：");
		    JLabel jl101=new JLabel("联系电话：");
		    
		    JLabel jl11=new JLabel();
		    JLabel jl22=new JLabel();

		    JButton jb=new JButton("确认修改");
		    JButton jb1=new JButton("保存修改");
		    
		
		   p2.setBackground(Color.magenta); 
		   JLabel jl=new JLabel("个人信息修改");
		    jl.setFont(new Font("宋体", Font.PLAIN, 60));
		    jl.setForeground(Color.WHITE);
		    jl.setBounds(150,20,500,50);
		    
		    jl7.setBounds(290,0,100,20);
		
    
		    jl1.setBounds(100,30,50,20);  jl11.setBounds(160,30,50,20);
		    jl2.setBounds(100,80,50,20);  jl22.setBounds(160,80,50,20);
		    jl3.setBounds(290,160,100,20);
		    jl4.setBounds(200,200,100,20);
		    jl5.setBounds(200,240,100,20);
		    jl6.setBounds(160,280,150,20);
		    
		    jl8.setBounds(300,20,200,20); jl88.setBounds(500,20,150,20);
		   
		    jl10.setBounds(300,57,200,20);jl00.setBounds(500,57,150,20);
		    jl101.setBounds(300,95,200,20);jt101.setBounds(500,95,150,20);
		    jb1.setBounds(420,120,100,30);
		    
		    jt1.setBounds(300, 200, 150, 20);
		    jt2.setBounds(300, 240, 150, 20);
		    jt3.setBounds(300, 280, 150, 20);
		    
		    jb.setBounds(300, 320, 100, 30);
		    
		    
		    p3.add(jl1);
		    p3.add(jl2);
		    p3.add(jl3);
		    p3.add(jl4);
		    p3.add(jl5);
		    p3.add(jl6);
		    p3.add(jl7);
		    p3.add(jl8);
		    
		    p3.add(jl10);
		    
		    p3.add(jl11);
		    p3.add(jl22);
		    p3.add(jl88);
		 
		    p3.add(jl00);
		    p3.add(jl101);
		    p3.add(jt101);
		    p3.add(jb1);
		    
		    p3.add(jt1);
		    p3.add(jt2);
		    p3.add(jt3);
		    p3.add(jb);
		    

		    p2.add(jl);
		    
		    
		    try
			{
				Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
		        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
		        ps = ct.prepareStatement("SELECT * FROM customer where cid='"+zh+"'");//3.访问数据库
		        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
			
		        while(rs.next())
		        {
		        jl11.setText(rs.getString(1));
		       	jl22.setText(rs.getString(2));   
		       	jl88.setSelectedItem(rs.getString(3));
		       	
		       	jl00.setText(rs.getString(6));
		       	jt101.setText(rs.getString(4));
		      
		        }
		        System.out.println(zh);
		    }
		catch(Exception q)
		{
			 q.printStackTrace();
		        System.out.println("load gg");
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

		    
		    
		    
		    
	   p3.setVisible(false);
		p3.setVisible(true);
		
		myxxop myxxop=new myxxop();
		jb1.addActionListener(myxxop);
		
		
		jb.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e1)
        	{
	    		try
				{
					Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
			        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
			        ps = ct.prepareStatement("SELECT * FROM customer where cid='"+zh+"'");//3.访问数据库
			        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
				if(String.valueOf(jt2.getPassword()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入新密码");
					return;
				}
				
				
			   
			        while(rs.next())
			        {
			        	if(	!String.valueOf(jt1.getPassword()).equals(rs.getString(5)))
			        	{
			        		JOptionPane.showMessageDialog(null, "请输入正确的密码");
			        		break;
			        	}
			            if(!String.valueOf(jt2.getPassword()).equals(String.valueOf(jt3.getPassword())))
			            {
			        		if(	!String.valueOf(jt1.getPassword()).equals(rs.getString(5)))
				        	{
				        		JOptionPane.showMessageDialog(null, "请输入正确的密码");
				        		break;
				        	}
			            
			            else{
				        		JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
				        		return;
				        	}
			            }
			            else
			            {
			            	String sql="UPDATE customer SET ccode='"+String.valueOf(jt2.getPassword())+"'  WHERE cid='"+zh+"'";
			            	ps.executeUpdate(sql);
			            	JOptionPane.showMessageDialog(null, "密码修改成功");
			            	jt1.setText("");
			            	jt2.setText("");
			            	jt3.setText("");
			            	
			            	break;
			            	
			            }
				        	
			        	}
			       
			        }
			      
			        	/*if(jt1.getText()!=jt1.getText());
			        	{
			        		JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");			  
			        	}*/
			        	
			      
		 
			        
			    
			catch(Exception q)
			{
				 q.printStackTrace();
			        System.out.println("load gg");
			}
        		
        		
        	}
	    });
		
		// TODO Auto-generated method stub

	}
	

}
