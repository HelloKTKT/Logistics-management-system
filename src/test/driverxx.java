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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class driverxx extends home implements ActionListener {

	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
    
	static protected JTable jt;
    protected JScrollPane jp ; 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 JButton jb1=new JButton("录入司机信息");
		 JButton jb2=new JButton("删除司机信息");
		 JButton jb3=new JButton("修改司机信息");
		
			p2.removeAll();
			p3.removeAll();
			p3.setVisible(false);
			p3.setVisible(true);
		
		p2.setBackground(Color.cyan); 
		  JLabel jl=new JLabel("司机信息管理");
		    jl.setFont(new Font("宋体", Font.PLAIN, 20));
		    
		    jl.setForeground(Color.black);
		    jl.setBounds(260,10,200,20);
		    jb1.setBounds(230,40,200,20);
		    jb2.setBounds(230,70,200,20);
		    jb3.setBounds(230,100,200,20);

		    p2.add(jl);
		    p2.add(jb1);
		    p2.add(jb2);
		    p2.add(jb3);
		    
		    
		    columnNames = new Vector();
			 
	        columnNames.add("司机编号");
	        columnNames.add("司机姓名");
	        columnNames.add("联系电话");        
	        columnNames.add("驾照编号");
	        columnNames.add("住址");
	        

	        rowData = new Vector();
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
        ps = ct.prepareStatement("SELECT * FROM driver");//3.访问数据库
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
		    
		    
		    
		   p2.setVisible(false);
		   p2.setVisible(true);
		    
		    p3.setVisible(false);
			p3.setVisible(true);
		// TODO Auto-generated method stub
			driveradd driveradd=new driveradd();
			jb1.addActionListener(driveradd);
			driverde driverde=new driverde();
			jb2.addActionListener(driverde);
			driverop driverop=new driverop();
			jb3.addActionListener(driverop);

	}


}
