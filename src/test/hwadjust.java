package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.carchange.carchok;

public class hwadjust extends hwxx implements ActionListener {
	private Connection ct=null;
    private PreparedStatement ps = null;  
    private ResultSet rs = null;  
    
    public  JLabel jl11=new JLabel();
    public  JLabel jl22=new JLabel();
    public  JLabel jl33=new JLabel();
    public  JLabel jl44=new JLabel();
    public  JLabel jl55=new JLabel();
    public  JLabel jl66=new JLabel();
    static public  JTextField jl77=new JTextField();
    static public  JTextField jl88=new JTextField();
    
    static protected JLabel d1=new JLabel();
    static protected JLabel d2=new JLabel();
    static protected JLabel d3=new JLabel();
    static protected JLabel d4=new JLabel();
    static protected JLabel d5=new JLabel();
    static protected JLabel d6=new JLabel();
    static protected JLabel d7=new JLabel();
    static protected JLabel d8=new JLabel();

    static int i;
    static String ii;

    static String id;
	@Override
	public void actionPerformed(ActionEvent e) {
		

		int rn = jt.getSelectedRow();

		
	    if(rn == -1) 
	    {  
            JOptionPane.showMessageDialog(null, "��ѡ��һ��");  
            return ;  
        }  
	   id = (String) jt.getValueAt(rn, 0);
        rn = jt.getSelectedRow();
		// TODO Auto-generated method stub
        JFrame jf=new JFrame("���Ȼ���");
		
		jf.setSize(270,400);
		jf.setVisible(true);
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(10,2));
	     JLabel jl1 = new JLabel("��Ʒ����");
	     JLabel jl2 = new JLabel("������");
	     JLabel jl3 = new JLabel("��������");
	     JLabel jl4 = new JLabel("����");
	     JLabel jl5 = new JLabel("����");
	     JLabel jl6 = new JLabel("����λ��");
	     JLabel jl7 = new JLabel("Ŀ��λ��");	     
	     JLabel jl8 = new JLabel("���ͻ���");
	     

	

		JButton jb1=new JButton("����������");
		JButton jb2=new JButton("�鿴���л���");
		
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
		        ps = ct.prepareStatement("SELECT * FROM goods");//3.�������ݿ�
		        rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
		        while(rs.next())
		        {
		        	if(rs.getString(1).equals(id))
		        	{
		        		
		        		jl11.setText(rs.getString(1));
		        		jl22.setText(rs.getString(2));
		        		jl33.setText(rs.getString(3));
		        		jl44.setText(rs.getString(4));
		        		jl55.setText(rs.getString(5));
		        		jl66.setText(rs.getString(6));
		        	
		        	
		  

		        	break;
		        	}
		        }
		        System.out.println("load  ok!");
		     
		    
		}
		catch(Exception q)
		{
			 q.printStackTrace();
		        System.out.println("load gg");
		}
		finally
		{
	        try
	        {
	            rs.close();
	            ps.close();
	            ct.close();
	            System.out.println("close ok");
	        }catch (SQLException o)
	        {
	            o.printStackTrace();
	            System.out.println("close gg");
	        }
		}
		

		jf.add(jp);
		jp.add(jl1);jp.add(jl11);
		jp.add(jl2);jp.add(jl22);
		jp.add(jl3);jp.add(jl33);
		jp.add(jl4);jp.add(jl44);
		jp.add(jl5);jp.add(jl55);
		jp.add(jl6);jp.add(jl66);
		jp.add(jl7);jp.add(jl77);
		jp.add(jl8);jp.add(jl88);
	

	
		jp.add(jb1);jp.add(jb2);
		
		formadd formadd=new formadd();
		jb1.addActionListener(formadd);
		
	jb2.addActionListener(new ActionListener()
			
	{
		public void actionPerformed(ActionEvent e)
			{
				b3.doClick();
				carxx.j8.doClick();
			}
		
			
	});
		
		
	}
		public class formadd implements ActionListener
		{
			
			
	
			public void actionPerformed(ActionEvent e1)
			{
				
			
				JLabel jlb1=new JLabel("�������");
				JLabel jlb2=new JLabel("��Ʒ����");
				JLabel jlb3=new JLabel("������");
				JLabel jlb4=new JLabel("��������");
				JLabel jlb5=new JLabel("��������");
				JLabel jlb6=new JLabel("��������");
				JLabel jlb7=new JLabel("������");
				JLabel jlb8=new JLabel("Ŀ�ĵ�");
			


				JButton formok=new JButton("ȷ��");

				 final JFrame jr=new JFrame("��������Ϣ");
				 jr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				 //jr.setDefaultCloseOperation(jr.EXIT_ON_CLOSE);
				 //jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			       JPanel jl=new JPanel();
			       jl.setLayout(new GridLayout(10,2));
			       jr.setSize(500,300);
			       jr.setVisible(true);
			    
			       
			       try{
		     			//int i=null;
		                 Class.forName("com.mysql.jdbc.Driver");
		                 System.out.println("JBDC ���سɹ�!");
		                 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
		                 ps = ct.prepareStatement("SELECT * FROM form");//3.�������ݿ�
		                 rs = ps.executeQuery();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
		                 while (rs.next())
		                 {
		                 	//i=rs.getString(1);	
		                 	 i = Integer.parseInt(rs.getString(1));
		                 	i++;
		             ii=Integer.toString(i);
		                 }
		                 
		                 d1.setText(ii);
		                 d2.setText(jl11.getText());
		                 d3.setText(jl22.getText());
		                 d4.setText(jl33.getText());
		                 d5.setText(jl55.getText());
		                 d6.setText(jl88.getText());
		                 d7.setText(jl66.getText());
		                 d8.setText(jl77.getText());
		                 
		                 
		                 
		             }catch(Exception a){
		                 System.out.println("JBDC gg!");
		                 a.printStackTrace();
		             }
		      
		        try{
		            Class.forName("com.mysql.jdbc.Driver");
		            System.out.println("jdbc ok");
		             
		        }catch(Exception d){
		            System.out.println("jdbc gg");
		            d.printStackTrace();
		        }
		        jr.add(jl);
		    	jl.add(jlb1);jl.add(d1);
				jl.add(jlb2);jl.add(d2);
				jl.add(jlb3);jl.add(d3);
				jl.add(jlb4);jl.add(d4);
				jl.add(jlb5);jl.add(d5);
				jl.add(jlb6);jl.add(d6);
				jl.add(jlb7);jl.add(d7);
				jl.add(jlb8);jl.add(d8);
				jl.add(formok);
				
				formcreate formcreate=new formcreate();
				formok.addActionListener(formcreate);
		        
		      
		}
		

	}

}
