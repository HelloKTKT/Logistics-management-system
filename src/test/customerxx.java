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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class customerxx extends home implements ActionListener {
	
	protected static JTextField jtc=new JTextField("");
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
    static public JTable jt;
    protected JScrollPane jp = new JScrollPane();   

	@Override
	public void actionPerformed(ActionEvent e) {
		p2.removeAll();
		p3.removeAll();
		//p3.setVisible(false);
		//p3.setVisible(true);
		p2.setBackground(Color.LIGHT_GRAY);
		
		JButton jb1=new JButton("���ӿͻ���Ϣ");
		jb1.setBounds(20,10,220,35);
		JButton jb3=new JButton("ɾ���ͻ���Ϣ");
		jb3.setBounds(260,10,220,35);
		JLabel jl=new JLabel("������ͻ����:");
		jl.setBounds(10,60,200,25);
		jtc.setBounds(140,60,120,20);
		//jt.setBounds(10,50,100,25);
		JButton jb2=new JButton("�ͻ��˺Ų�ѯ");
		jb2.setBounds(300,57,150,25);
		JLabel jl1=new JLabel("�ͻ���Ϣ����");
		jl1.setBounds(5,95,120,25);
		p2.add(jb1);
		p2.add(jl);
		p2.add(jtc);
		p2.add(jb2);
		p2.add(jl1);
		p2.add(jb3);
		
		p3.removeAll();
		 columnNames = new Vector();
		 
		 columnNames.add("�ͻ����");
		 columnNames.add("�ͻ�����");
		 columnNames.add("�Ա�"); 
		 columnNames.add("��ϵ�绰");  
		 columnNames.add("��ַ");       
    
	        rowData = new Vector();
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");//1.������������
     ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
     ps = ct.prepareStatement("SELECT * FROM customer");//3.�������ݿ�
     rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
     while (rs.next())
     {
         Vector hang = new Vector();
         hang.add(rs.getString(1));
         hang.add(rs.getString(2));
         hang.add(rs.getString(3));
         hang.add(rs.getString(4));
         hang.add(rs.getString(6));


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
		
		

		customerask customerask=new customerask();
		jb2.addActionListener(customerask);
		customeradd customeradd=new customeradd();
		jb1.addActionListener(customeradd);
		customerde customerde=new customerde();
		jb3.addActionListener(customerde);
		
		
		
		// TODO Auto-generated method stub

	}

}
