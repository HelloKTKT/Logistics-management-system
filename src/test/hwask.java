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

public class hwask extends hwxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private Vector column = null;
    private Vector data = null;
    //private JTable jt=null;
    protected JScrollPane jp = null;   

	@Override
	public void actionPerformed(ActionEvent e) {
		p3.removeAll();
		column=new Vector();
		column.add("入库批号");
		column.add("货物编号");
		column.add("货物名称");
		column.add("种类");
		column.add("库存数量");
		column.add("位置");
		data=new Vector();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
		        ps = ct.prepareStatement("SELECT * FROM goods");//3.访问数据库
		        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
		        while(rs.next())
		        {
		        	if(rs.getString(1).equals(j3.getText()))
		        	{
		        	Vector hang=new Vector();
		        	hang.add(rs.getString(1));
		        	hang.add(rs.getString(2));
		        	hang.add(rs.getString(3));
		        	hang.add(rs.getString(4));
		        	hang.add(rs.getString(5));
		        	hang.add(rs.getString(6));
		        	data.add(hang);
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
			jt=new JTable(data,column);
			jp = new JScrollPane(jt);  
			  p3.add(jp);
				jp.setBounds(0, 0,690, 400);
		
		
		// TODO Auto-generated method stub

	}

}
