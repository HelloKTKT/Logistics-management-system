package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ddchangeop extends ddchange implements ActionListener 
{
	private Connection ct = null;  
    private Statement ps = null;  

	
	
    //对订单进行具体修改
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String st=t1.getText();
		
	
		try {
		    Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
	        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
	        ps=ct.createStatement();
	        System.out.println("jdbc ok");
		// TODO Auto-generated method stub
		}
		catch (Exception q)
		{
			q.printStackTrace();
            System.out.println("jdbc gg");
		}
		
		//JComboBox t10=new JComboBox(str1);
		String sql2="UPDATE orders SET goodsid='"+t2.getText()+"'  WHERE orid='"+st+"'";
        String sql10="UPDATE orders SET carid='"+t10.getText()+"'  WHERE orid='"+st+"'";
        String sql11="UPDATE orders SET driverid='"+t11.getText()+"' WHERE orid='"+st+"'";
        String sql12="UPDATE orders SET goaddress='"+t12.getText()+"' WHERE orid='"+st+"'";
        String sql13="UPDATE orders SET orstate='"+t13.getSelectedItem()+"'  WHERE orid='"+st+"'";
        
        
        
        try {
        
            ps.executeUpdate(sql2);
      
            ps.executeUpdate(sql10); 
            ps.executeUpdate(sql11); 
            ps.executeUpdate(sql12);
            ps.executeUpdate(sql13);
            JOptionPane.showMessageDialog(null, "修改成功"); 
            b1.doClick();
            jr.dispose();
           
            
        } 
        catch (SQLException g) {
            // TODO Auto-generated catch block
            g.printStackTrace();
            
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
