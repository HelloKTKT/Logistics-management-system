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

public class writing extends ddxx implements ActionListener {
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private String driver = "com.mysql.jdbc.Driver";  
    private String url = "jdbc:mysql://localhost:3306/wuliu";  

  

	@Override
	public void actionPerformed(ActionEvent e) {
		p3.removeAll();
		 Vector rowData=new Vector();
	     Vector columnNames=new Vector();
		   columnNames.add("�������");
		   columnNames.add("��Ʒ����");
		   columnNames.add("������");
	        columnNames.add("��������");
	        columnNames.add("����������");
	        columnNames.add("�ͻ����");
	        columnNames.add("�ջ���");
	        columnNames.add("�ջ���ַ");
	        columnNames.add("�ջ��˵绰");
	        columnNames.add("��������");
	        columnNames.add("˾���绰");
	        columnNames.add("������");
	        columnNames.add("����״̬");
	        columnNames.add("Ŀǰλ��");
	
	try {
    Class.forName("com.mysql.jdbc.Driver");//1.������������
    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
    ps = ct.prepareStatement("SELECT * FROM orders");//3.�������ݿ�
    rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
    while (rs.next())
    {
    	if(rs.getString(13).equals("������"))
    	{
        Vector hang = new Vector();
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
        hang.add(rs.getString(11));
        hang.add(rs.getString(12));
        hang.add(rs.getString(13));
        hang.add(rs.getString(14));
        rowData.add(hang);
        }
         
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
