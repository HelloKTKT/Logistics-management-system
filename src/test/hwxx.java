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

public class hwxx extends home implements ActionListener {
	
	//protected JLabel jl=null;

	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    private Vector column = null;
    private Vector data = null;
    static protected JTable jt=null;
    protected JScrollPane jp = null;   
	protected static JTextField j3=new JTextField();
	static protected String[] str1={"ȫ��","�麣�ֿ�","���ڲֿ�","���ݲֿ�","��ͷ�ֿ�","������","����ͻ�"};
	static protected JComboBox jcb1=new JComboBox(str1);

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		p2.removeAll();
		p3.removeAll();
		p3.setVisible(false);
		p3.setVisible(true);
		
		p2.setBackground(Color.pink); 
		
		
		JButton j1=new JButton("��ӻ���");
		j1.setBounds(10,10,100,25);
		JButton j2=new JButton("�������");
		j2.setBounds(120,10,100,25);
		JButton jb3=new JButton("����");
		jb3.setBounds(230,10,100,25);
	
		j3.setBounds(160,60,100,20);
		JLabel j4=new JLabel("��������Ž��в�ѯ��");
		j4.setBounds(0,60,150,20);
		JButton j5=new JButton("��ѯ����");
		j5.setBounds(280,58,100,25);
		JLabel j6=new JLabel("λ�ã�");
		j6.setBounds(450,10,50,25);
		JButton j7=new JButton("��ѯ");
		j7.setBounds(500,60,70,25);
		
		jcb1.setBounds(500,10,130,25);

		JLabel jl=new JLabel("������Ϣ�������");
		jl.setBounds(5,95,120,25);
		
		p2.add(j1);
		p2.add(j2);
		p2.add(j3);
		p2.add(j4);
		p2.add(j5);
		p2.add(j6);
		p2.add(jcb1);
		p2.add(j7);
		p2.add(jb3);

		p2.add(jl);
		p2.setVisible(true);
		
		p3.removeAll();
		
		column=new Vector();
		column.add("�������");
		column.add("������");
		column.add("��������");
		column.add("����");
		column.add("�������");
		column.add("λ��");
		data=new Vector();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");//1.������������
	        ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
	        ps = ct.prepareStatement("SELECT * FROM goods");//3.�������ݿ�
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
	
	
		
		
		
		hwadd hwadd=new hwadd();
		j1.addActionListener(hwadd);
		hwadjust hwadjust=new hwadjust();
		j2.addActionListener(hwadjust);
		hwask hwask=new hwask();
		j5.addActionListener(hwask);
		hwask2 hwask2=new hwask2();
		j7.addActionListener(hwask2);
		hwout hwout=new hwout();
		jb3.addActionListener(hwout);

	
        
		
		
		// TODO Auto-generated method stub

	}
	
		
	

}
