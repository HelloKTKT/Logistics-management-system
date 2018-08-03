package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class carask extends carxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private Vector columnNames = null;
    private Vector data = null;
    //private JTable jt=null;
    protected JScrollPane jp = null;   

	@Override
	public void actionPerformed(ActionEvent e) {
		p3.removeAll();
		columnNames=new Vector();
	     columnNames.add("货车编号");
	        columnNames.add("货车型号");
	        columnNames.add("货车状态");        
	        columnNames.add("货车当前位置");
	 
	        columnNames.add("司机编号");
		data=new Vector();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
		        ps = ct.prepareStatement("SELECT * FROM car WHERE carid= '"+j3.getText()+"'");//3.访问数据库
		        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
		        while(rs.next())
		        {
		        	//if(rs.getString(1).equals(j3.getText()))
		        	//{
		        	Vector hang=new Vector();
		            hang.add(rs.getString(1));
		            hang.add(rs.getString(2));
		            hang.add(rs.getString(3));
		            hang.add(rs.getString(4));
		            hang.add(rs.getString(5));
		  
		        	data.add(hang);
		        	//break;
		        	//}
		        }
		        System.out.println("load  ok!");
		    
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
			jt=new JTable(data,columnNames);
			jp = new JScrollPane(jt);  
			  p3.add(jp);
				jp.setBounds(0, 0,700, 430);
		
		
		// TODO Auto-generated method stub

	}

}
