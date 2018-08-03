package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class myorderget extends myorder implements ActionListener {
	
	private Connection ct = null;  
    private Statement ps = null;  
  


    
	//static protected JTable jt;
    protected JScrollPane jp ; 
    
    static String id;
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 int rn = jt.getSelectedRow();

			
		    if(rn == -1) {  
	            JOptionPane.showMessageDialog(null, "请选择一行");  
	            return ;  
	        }  
		    id = (String) jt.getValueAt(rn, 0);
		    
		    
		// TODO Auto-generated method stub

			String sql1="UPDATE orders SET orstate='已完成'   WHERE orid='"+id+"'";
		    String sql2="UPDATE orders SET carposition='已到达'   WHERE orid='"+id+"'";
			
			
			try{
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("JBDC 加载成功!");
	        }catch(Exception a){
	            System.out.println("JBDC gg!");
	            a.printStackTrace();
	        }
	        try{
	            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root",""); //连接数据库
	            ps=ct.createStatement(); //访问数据库
	             
	            ps.executeUpdate(sql1);
	            ps.executeUpdate(sql2);
	             
	            //System.out.println("MySQL 连接成功!");
	            //stat = conn.createStatement();
	            //stat.executeUpdate(sql);
	            //System.out.println("插入数据成功!");
	            JOptionPane.showMessageDialog(null, "操作成功");
	            b2.doClick();
	       
	            //.doClick();
	          
	                 
	             
	        }catch (SQLException b){
	            b.printStackTrace(); 
	        
	         
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
