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
		 
	        columnNames.add("�������");
	        columnNames.add("�����ͺ�");
	        columnNames.add("����״̬");        
	        columnNames.add("������ǰλ��");

	        columnNames.add("˾�����");
	     
	        rowData = new Vector();
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");//1.������������
     ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
     ps = ct.prepareStatement("SELECT * FROM car where carstate='����'");//3.�������ݿ�
     rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
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
