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

public class carxx extends home implements ActionListener {
	
	protected static JTextField j3=new JTextField();
	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
     static protected JTable jt=null;
    protected JScrollPane jp = new JScrollPane(); 
    public static JButton j8=new JButton("���л���");

	@Override
	public void actionPerformed(ActionEvent e) {
		p2.removeAll();
		p3.removeAll();
		p3.setVisible(false);
		p3.setVisible(true);
		p2.setBackground(Color.GRAY);
		JButton j1=new JButton("¼�������Ϣ");
		j1.setBounds(10,10,150,25);
		JButton j2=new JButton("ɾ��������Ϣ");
		j2.setBounds(170,10,150,25);
		j3.setBounds(150,60,120,20);
		JLabel j4=new JLabel("�����Ž��в�ѯ��");
		j4.setBounds(10,60,120,20);
		JButton j5=new JButton("��ѯ����");
		j5.setBounds(280,58,100,25);
		//JButton j6=new JButton("ȫ������");
		//j6.setBounds(230,10,100,25);
		JButton j7=new JButton("������Ϣ����");
		j7.setBounds(340,10,150,25);
		//JButton j8=new JButton("���л���");
		j8.setBounds(500,10,100,25);
		JLabel jl=new JLabel("������Ϣ�������");
		jl.setBounds(5,95,120,25);
	
		
		

		p2.add(j1);
		p2.add(j2);
		p2.add(j3);
		p2.add(j4);
		p2.add(j5);
		
		p2.add(j7);
		p2.add(jl);
		p2.add(j8);

		
		
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
      ps = ct.prepareStatement("SELECT * FROM car");//3.�������ݿ�
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
		
		
		carad carad=new carad();
		j1.addActionListener(carad);
		cardelete cardelete=new cardelete();
		j2.addActionListener(cardelete);
		carask carask=new carask();
		j5.addActionListener(carask);
		carchange carchange=new carchange();
		j7.addActionListener(carchange);
		carfree carfree=new carfree();
		j8.addActionListener(carfree);
	
		
		

		// TODO Auto-generated method stub

	}

}
