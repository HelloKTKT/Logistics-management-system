package test;

import java.awt.GridLayout;
import java.awt.TextField;
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

public class formop extends formxx implements ActionListener {
	
    protected static JLabel t1=new JLabel (); 
   protected static String str1[] = {"�ѳ���","�����","������"};  
    protected static JComboBox t2=new JComboBox(str1);
  
    protected JFrame jr=null;
    protected JPanel jl=null;
    static String id;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rn=-1;
		rn = jt.getSelectedRow();

	    if(rn == -1) {  
            JOptionPane.showMessageDialog(null, "��ѡ��һ��");  
            return ;  
        }  		
	   id = (String) jt.getValueAt(rn, 0);
	   final String id4 = (String) jt.getValueAt(rn, 1);
	    String id2 = (String) jt.getValueAt(rn, 8);
	    final String id3 = (String) jt.getValueAt(rn, 7);

	     final JFrame jr=new JFrame("��������״̬");
	     JPanel jl=new JPanel();
	    t1.setText(id);
	    t2.setSelectedItem(id2);

	    JLabel jl1=new JLabel("������ţ�");
        JLabel jl2=new JLabel("����״̬Ϊ��");
       
        
        JButton jb=new JButton("ȷ��");
        
        jr.setSize(270,200);
	       jr.setVisible(true);
	       jl.setLayout(new GridLayout(3,2));
	       jr.add(jl);
	       jl.add(jl1);jl.add(t1);
	       jl.add(jl2);jl.add(t2);
	 
	       jl.add(jb);
	       
	       jb.addActionListener(new ActionListener()
	       {
	    		private Connection ct=null;
	    	    private Statement ps = null;  
	    	    private ResultSet rs = null;  
	    	   public void actionPerformed(ActionEvent e) 
	    	   {
	    		   try
	   			{
	    			   Class.forName("com.mysql.jdbc.Driver");
						 ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuliu","root","");//2.�������ݿ�
					        ps = ct.createStatement();//3.�������ݿ�
					         //ps.executeUpdate();//4.ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�
					         System.out.println("jdbc ok");
					     	String sql2="UPDATE form SET lostate='"+t2.getSelectedItem()+"'  WHERE loid='"+id+"'";
					     	String sql3="UPDATE goods SET goposition='"+id3+"'  WHERE goodsid='"+id4+"'";
					     	String sql4="UPDATE form SET carposition='�ѵ���'  WHERE loid='"+id+"'";
					     	
					     	 ps.executeUpdate(sql2);
					     	 
					     	 
					     	 
					     	 
					     	if(	t2.getSelectedItem().equals("�����"))
					     	{
					     		ps.executeUpdate(sql3);
					     		ps.executeUpdate(sql4);
					     	}
					     	 
					     	 
					     	 
					     	 
	   			        System.out.println("load  ok!");
	   			        
	   			        
	   			        
	   			        
	   			        
	   			        
	   			     JOptionPane.showMessageDialog(null, "���³ɹ�");
			            b6.doClick();
			            jr.dispose();
	   			     
	   			    
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

	   		            ps.close();
	   		            ct.close();
	   		            System.out.println("close ok");
	   		        }catch (SQLException o)
	   		        {
	   		            o.printStackTrace();
	   		            System.out.println("close gg");
	   		        }
	   			}
	    	   }  
	       });
 
		// TODO Auto-generated method stub

	}

}
