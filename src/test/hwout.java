package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.driverop.carchok;

public class hwout extends hwxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    
    public  JTextField jl11=new JTextField();
    public  JTextField jl22=new JTextField();
    public  JTextField jl33=new JTextField();

    static String id;
    JFrame jf=null;

	@Override
	public void actionPerformed(ActionEvent e) {
		int rn = jt.getSelectedRow();

		
	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "请选择一行");  
            return ;  
        }  
	    id = (String) jt.getValueAt(rn, 0);
        rn = jt.getSelectedRow();
	
		

        JFrame jf=new JFrame("请确认信息");
			
		
			jf.setSize(270,200);
			jf.setVisible(true);
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(4,2));
		     JLabel jl1 = new JLabel("货物批号");
		     JLabel jl2 = new JLabel("当前数量(件)");
		     JLabel jl3 = new JLabel("出货数量(件)");
		
			
			jl11.setEditable(false);
			jl22.setEditable(false);
	
			JButton jb1=new JButton("出货完毕");
			
			try
			{
				int t=0;
				Class.forName("com.mysql.jdbc.Driver");
				 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
			        ps = ct.prepareStatement("SELECT * FROM goods");//3.访问数据库
			        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
			        while(rs.next())
			        {
			        	if(rs.getString(1).equals(id))
			        	{
			        		
			        		jl11.setText(rs.getString(1));
			        		jl22.setText(rs.getString(5));
	
			        		t=1;
			
			        	break;
			        	}
			        }
			        System.out.println("load  ok!");
			     
			    
			}
			catch(Exception q)
			{
				 q.printStackTrace();
			        System.out.println("load gg");
			}
			finally
			{
		        try
		        {
		            rs.close();
		            ps.close();
		            ct.close();
		            System.out.println("close ok");
		        }catch (SQLException o)
		        {
		            o.printStackTrace();
		            System.out.println("close gg");
		        }
			}
			

			jf.add(jp);
			jp.add(jl1);jp.add(jl11);
			jp.add(jl2);jp.add(jl22);
			jp.add(jl3);jp.add(jl33);


			jp.add(jb1);
			
			carchok carchok=new carchok();
			jb1.addActionListener(carchok);
			
		
			
			
		}
			public class carchok implements ActionListener
			{
				Statement ps = null;  
		
				public void actionPerformed(ActionEvent e1)
				{
					//String st=jl22.getText();
					// System.out.println("jl22.getText()");
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
					        ps = ct.createStatement();//3.访问数据库
					         //ps.executeUpdate();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
					         System.out.println("jdbc ok");

					}
					     
					catch(Exception q)
					{
						 q.printStackTrace();
					        System.out.println("load gg");
					        
					}

					//String sql1="UPDATE huowu SET hwid='"+jl11.getText()+"'  WHERE hwid='"+jt.getText()+"'";
				
					String sql1="update goods set gonumber= gonumber-"+jl33.getText()+" where goodsid='"+jl11.getText()+"';";
			
			
				
		
			        try {
			        	ps.executeUpdate(sql1);
			
			       
						
			
			            JOptionPane.showMessageDialog(null, "出货成功"); 
			            jf.dispose();
			            b2.doClick();
			           
			            
			        } 
			        catch (SQLException g) {
			            // TODO Auto-generated catch block
			            g.printStackTrace();
			            JOptionPane.showMessageDialog(null, "出货失败"); 
			            
			        }
			        
			        finally{
			            try{
			                ct.close();
			            }catch(SQLException ar){
			                ar.printStackTrace();
			            }
			     
			        }
				}
			}
			
			
		
		// TODO Auto-generated method stub

	}


