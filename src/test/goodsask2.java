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

public class goodsask2 extends lookgoods implements ActionListener {
	
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
		column.add("������");
		column.add("��������");
		column.add("����");
		column.add("����");
		data=new Vector();
		String ak=(String)jcb1.getSelectedItem();
		 System.out.println(ak);
		 /*if(ak.equals("ȫ��"))
		 {
			 b2.doClick();
		 return;			 
		 }*/
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
			 ps = ct.prepareStatement("SELECT goid,goname,gotype,sum(gonumber)  FROM goods group by goid");;//3.�������ݿ�
		        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
		        while(rs.next())
		        {
		        	if((rs.getString(3).equals(ak))||(ak.equals("ȫ��")))
		        	{
		        	Vector hang=new Vector();
		        	hang.add(rs.getString(1));
		        	hang.add(rs.getString(2));
		        	hang.add(rs.getString(3));
		        	hang.add(rs.getString(4));
		      
		        	data.add(hang);
		        	
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
