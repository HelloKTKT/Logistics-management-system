package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class myxxop  extends myxx implements ActionListener {
	private Connection ct = null;  
    private Statement ps = null;  

	@Override
	public void actionPerformed(ActionEvent e) {
		//String st=zh;
		
		
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
		String sql1="UPDATE customer SET csex='"+jl88.getSelectedItem()+"'  WHERE cid='"+zh+"'";
	
		String sql3="UPDATE customer SET ccomname='"+jl00.getText()+"'  WHERE cid='"+zh+"'";
		String sql4="UPDATE customer SET cnumber='"+jt101.getText()+"'  WHERE cid='"+zh+"'";
		

        try {
        	ps.executeUpdate(sql1);
 
            ps.executeUpdate(sql3);
            ps.executeUpdate(sql4);
    
            JOptionPane.showMessageDialog(null, "修改成功"); 
           
            
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
         
		// TODO Auto-generated method stub

	}

}

