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

public class formed extends formxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private Vector column = null;
    private Vector data = null;

    protected JScrollPane jp = null;   

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		p3.removeAll();
		column=new Vector();
		column.add("�������");
		column.add("��Ʒ����");
		column.add("������");
		column.add("��������");
		column.add("��������");
		column.add("��������");
		column.add("������");
		column.add("Ŀ�ĵ�");
		column.add("��ǰ״̬");
		column.add("��ǰλ��");
		data=new Vector();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
		        ps = ct.prepareStatement("SELECT * from form where lostate='�����' ");//3.�������ݿ�
		        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
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
	}

}
