package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class formxx extends home implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private Vector column = null;
    private Vector data = null;
    static protected JTable jt=null;
    protected JScrollPane jp = null;   
	protected static JTextField j3=new JTextField();



	@Override
	public void actionPerformed(ActionEvent e) {
		p2.removeAll();
		p3.removeAll();
		p3.setVisible(false);
		p3.setVisible(true);
		
		p2.setBackground(Color.DARK_GRAY); 
		
		
		JButton j1=new JButton("目前运输");
		j1.setBounds(170,10,200,35);
		JButton j2=new JButton("已完成的物流单");
		j2.setBounds(450,10,200,35);
	
		j3.setBounds(160,60,100,20);
		JLabel j4=new JLabel("输入物流编号进行查询：");
		j4.setForeground(Color.white);
		j4.setBounds(0,60,150,20);
		JButton j5=new JButton("查询物流信息");
		j5.setBounds(280,58,200,25);
		JButton j6=new JButton("更新物流信息");
		j6.setBounds(280,88,200,25);
		
	
		


		JLabel jl=new JLabel("内部货物运输单信息管理");
		jl.setForeground(Color.white);
		jl.setBounds(5,95,170,25);
		
		p2.add(j1);
		p2.add(j2);
		p2.add(j3);
		p2.add(j4);
		p2.add(j5);
		p2.add(j6);


		p2.add(jl);
		p2.setVisible(true);
		
		p3.removeAll();
		
		column=new Vector();
		column.add("物流编号");
		column.add("产品批号");
		column.add("货物编号");
		column.add("货物名称");
		column.add("货物数量");
		column.add("货车牌照");
		column.add("发货地");
		column.add("目的地");
		column.add("当前状态");
		column.add("当前位置");
		data=new Vector();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
	        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.连接数据库
	        ps = ct.prepareStatement("SELECT * FROM form");//3.访问数据库
	        rs = ps.executeQuery();//4.执行查询，要用statement类的executeQuery()方法来下达select指令以查询数据库
		
	        while(rs.next())
	        {
	        	Vector hang=new Vector();
	        	hang.add(rs.getString(1));
	        	hang.add(rs.getString(2));
	        	hang.add(rs.getString(3));
	        	hang.add(rs.getString(4));
	        	hang.add(rs.getString(5));
	        	hang.add(rs.getString(6));
	        	hang.add(rs.getString(7));
	        	hang.add(rs.getString(8));
	        	hang.add(rs.getString(9));
	        	hang.add(rs.getString(10));
	        	data.add(hang);
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
		
			
			formask formask=new formask();
			j5.addActionListener(formask);
			forming forming=new forming();
			j1.addActionListener(forming);
			formed formed=new formed();
			j2.addActionListener(formed);
			formop formop=new formop();
			j6.addActionListener(formop);
		
		// TODO Auto-generated method stub

	}

}
