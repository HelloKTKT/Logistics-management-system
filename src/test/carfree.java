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

public class carfree extends carxx implements ActionListener {
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
    //public JTable jt=null;
    protected JScrollPane jp = new JScrollPane();   

	@Override
	public void actionPerformed(ActionEvent e) {
		p3.removeAll();
		 columnNames = new Vector();
		 
	        columnNames.add("货车编号");
	        columnNames.add("货车型号");
	        columnNames.add("货车状态");        
	        columnNames.add("货车当前位置");

	        columnNames.add("司机编号");
	     
	        rowData = new Vector();
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
     ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
     ps = ct.prepareStatement("SELECT * FROM car where carstate='空闲'");//3.访问数据库
     rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
     while (rs.next())
     {
         Vector hang = new Vector();
         hang.add(rs.getString(1));
         hang.add(rs.getString(2));
         hang.add(rs.getString(3));
         hang.add(rs.getString(4));
         hang.add(rs.getString(5));
 

         rowData.add(hang);
          
     }
     System.out.println("load  ok!");
 }catch (Exception q){
     q.printStackTrace();
     System.out.println("load gg");
 }finally{
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
		
		//p3.setLayout(new GridLayout(2,5));
 jt=new JTable(rowData,columnNames); 
  
  jp = new JScrollPane(jt);   
  
  p3.add(jp);
		jp.setBounds(0, 0,700, 430);
		
		// TODO Auto-generated method stub

	}

}
