package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ordercarop extends ddchange implements ActionListener {
	

	
	private Connection ct = null;  
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  

    private Vector columnNames = null;
    private Vector rowData = null;
     static private JTable jtc=null;
     private JScrollPane jpc = new JScrollPane(); 
  

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame jfc=new JFrame("���ó���");
		jfc.setBounds(200,100,600,500);
		jfc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jfc.setLayout(null);
		
		JPanel jp1=new JPanel ();
		JPanel jp2=new JPanel ();
		
		jp1.setBounds(0,0,600,400);
		jp2.setBounds(0,400,600,100);
		
		jfc.add(jp1);
		jfc.add(jp2);
		
		jp1.setLayout(null);
		jp2.setLayout(null);
		
	   JButton carok=new JButton("ȷ��ѡ��");
		carok.setBounds(200,0,200,50);
		jp2.add(carok);
	
		
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
jtc=new JTable(rowData,columnNames); 

jpc = new JScrollPane(jtc);   

jp1.add(jpc);
	jpc.setBounds(0, 0,600, 400);
	
	
	carok.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			int rn1=-1;
			rn1 = jtc.getSelectedRow();

		    if(rn1 == -1) {  
	            JOptionPane.showMessageDialog(null, "��ѡ��һ��");  
	            return ; } 
		    
		    String carid = (String) jtc.getValueAt(rn1, 0);
		    String driverid = (String) jtc.getValueAt(rn1, 4);
		    t10.setText(carid);
		    t11.setText(driverid);
	            
		}
		
	});
	

	jfc.setVisible(true);	// TODO Auto-generated method stub

	}

}
