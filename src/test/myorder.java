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

public class myorder extends lookgoods implements ActionListener {
	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
    
	static protected JTable jt;
    protected JScrollPane jp ; 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		 JButton jb2=new JButton("ȷ�ϵ���");
		
			p2.removeAll();
			p3.removeAll();
			p3.setVisible(false);
			p3.setVisible(true);
		
		p2.setBackground(Color.orange); 
		  JLabel jl=new JLabel("�ҵĶ���");
		    jl.setFont(new Font("����", Font.PLAIN, 20));
		    
		    jl.setForeground(Color.black);
		    jl.setBounds(260,10,200,20);
	
		    jb2.setBounds(230,70,200,40);

		    p2.add(jl);
		
		    p2.add(jb2);
		    
		    
		    columnNames = new Vector();
			 
		    columnNames.add("�������");
		    columnNames.add("������");
		    columnNames.add("��������");
		    columnNames.add("����");
		    columnNames.add("�ջ�������");
		    columnNames.add("�ջ��˵�ַ");
		    columnNames.add("�ջ��˵绰");
		    columnNames.add("��������");
		    columnNames.add("������");
		    columnNames.add("����״̬");
		    columnNames.add("��ǰλ��");
		    

	        rowData = new Vector();
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");//1.������������
       ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
       ps = ct.prepareStatement("SELECT * from orders");//3.�������ݿ�
       rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
       while (rs.next())
       {
    	   if(rs.getString(6).equals(zh))
    	   {
           Vector hang = new Vector();
           hang.add(rs.getString(1));
           hang.add(rs.getString(3));
           hang.add(rs.getString(4));
          
           hang.add(rs.getString(5));
           hang.add(rs.getString(7));
           hang.add(rs.getString(8));
           hang.add(rs.getString(9));
           hang.add(rs.getString(10));
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
		    
		    
		    
		   p2.setVisible(false);
		   p2.setVisible(true);
		    
		    p3.setVisible(false);
			p3.setVisible(true);
			
			
			myorderget myorderget=new myorderget();
			jb2.addActionListener(myorderget);
		// TODO Auto-generated method stub

	}

}
